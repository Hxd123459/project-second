package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.annotation.LoginLogAnnotation;
import com.aaa.hjd.model.TUser;
import com.aaa.hjd.utils.DateTimeUtils;

import com.aaa.hjd.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/27
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private PubService pubService;

    /**
     * @date:  2020/5/27
     * @author: 秀仔
     * @Description
     * 定义一个切面，
     * 定义切注解标注的生效
     * @param []
     * @return void
     * @throws
     */
    @Pointcut("@annotation(com.aaa.hjd.annotation.LoginLogAnnotation)")
    public void pointcut () {
    }
    /**
     * @date:  2020/5/27
     * @author: 秀仔
     * @Description
     * 定义环形切点
     * 参数：ProceedingJoinPoint:
     *      里面封装了目标路径中的所有参数
     *      可以任意获取
     * @param [proceedingJoinPoint]
     * @return java.lang.Object
     * @throws
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws ClassNotFoundException {
        //定义返回值
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //获取username信息，获取目标方法的参数及即可
        //获取目标方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        TUser user = null;
        for (Object arg : args) {
            //转换类型，并赋值
            user = (TUser) arg;
        }
        //获取当前时间
        String dateTime = DateTimeUtils.getNow();
        //获取ip地址
        //获取request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取ip
        String ip = IPUtils.getIpAddr(request);
        //需要获取到目标类的目标方法，再获取opeationType和operationName
        //获取全限定名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取目标方法名
        String targetMethodName = proceedingJoinPoint.getSignature().getName();
        //通过反射获取类对象
        Class targetClass = Class.forName(className);
        //获取类中所有方法
        Method[] methods = targetClass.getMethods();
        String operationName = "";
        String operationType = "";
        //循环对比
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.equals(targetMethodName)) {
                //可能有方法的重载，还需判断参数个数
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length) {
                    //获取目标数据
                    operationName = method.getAnnotation(LoginLogAnnotation.class).operationName();
                    operationType = method.getAnnotation(LoginLogAnnotation.class).operationType();
                }
            }
        }
        HashMap map = new HashMap();
        map.put("username", user.getUsername());
        map.put("loginTime", dateTime);
        map.put("ip", ip);
        map.put("operationType", operationType);
        map.put("operationName", operationName);
        //执行新增日志
        pubService.addLoginLog(map);
        return result;

    }
}
