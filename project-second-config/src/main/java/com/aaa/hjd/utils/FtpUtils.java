package com.aaa.hjd.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.jupiter.api.Test;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/14 0014
 * Time: 12:42
 * Description:
 * ftp文件上传
 */
public class FtpUtils {
    public static boolean UploadFile(String host,Integer port,String username,String password,
                                     String basePath,String filePath,String fileName, InputStream input){
        FTPClient ftpClient = new FTPClient();
        try {
            // 1.创建临时路径(方便于后面我需要上传文件的时候，检测日期文件夹是否存在，如果不存在需要进行创建)
            // 2020-->2020/05--->2020/05/15(就是方便于拼接这个文件夹目录)
            String tmpPath = "";
            int reply;
            //连接ftp
            ftpClient.connect(host,port);
            //登陆ftp
            ftpClient.login(username, password);
            reply=ftpClient.getReplyCode();
            // isPositiveCompletion():就是检测状态码的信息，如果成功返回true，如果失败返回false
            if (!FTPReply.isPositiveCompletion(reply)) {
                //关闭连接
                ftpClient.disconnect();
                return false;
            }
            tmpPath=basePath+"/"+filePath;
            if(!ftpClient.changeWorkingDirectory(basePath + filePath)) {
                // 说明路径不存在，需要进行创建文件夹
                // java中可是没有mkdir -p命令的 mkdir -p /home/ftp/2020/05/15/，只能一层一层创建
                // 8.分割filePath--->String[] ---> ["", "2020", "05", "15"]
                String[] dirs = filePath.split("/");
                // 9.把basePath(/home/ftp)赋值给临时路径(tmpPath)
                tmpPath = basePath;
                // 10.循环dirs数组
                for(String dir : dirs) {
                    // 严谨判断 判断dir一定不能为null
                    // 跳过本次循环，进入下一次循环
                    if (null == dir || "".equals(dir)) {continue;}
                    // 11.拼接临时路径
                    // /home/ftp/2020
                    tmpPath += "/" + dir;
                    // 12.再次检测确保该路径不存在
                    if(!ftpClient.changeWorkingDirectory(tmpPath)) {
                        // 13.创建文件夹
                        // makeDirectory()--->就是创建文件夹的方法，返回为bolean
                        if(!ftpClient.makeDirectory(tmpPath)) {
                            return false;
                        }
                    }
                }
            }
            //二进制上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            if (!ftpClient.storeFile(fileName,input)) {
                //文件上传失败
                return false;
            }
            //关闭io流
            input.close();
            //退出ftp
            ftpClient.logout();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Test
    public void testDemo(){
        File file = new File("D:/snake.jpg");
        try {
            InputStream inputStream=new FileInputStream(file);
            boolean test = FtpUtils.UploadFile("192.168.111.138",21,"zwc",
                    "123456","/home/zwc","2020/05/29","snake11.jpg",inputStream);
            System.out.println(test + "222");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
