package com.aaa.hjd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/27
 * @author 19435
 */

/**
 * 作用与方法上

 */
@Target({ElementType.METHOD})
/**
 * 运行时生效
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLogAnnotation {

    /**
     * 需要执行的操作类型
     * @return
     */
    String operationType() default "";

    /**
     * 执行操作的内容
     * @return
     */
    String operationName() default "";

}
