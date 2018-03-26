package com.applet.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

@Component
public class FtpUtil {
    //读取配置文件
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("application-ftp");
    //读取配置文件参数
    private static final String url = resourceBundle.getString("ftp.url");
    private static final int port = Integer.parseInt(resourceBundle.getString("ftp.port"));
    private static final String username = resourceBundle.getString("ftp.username");
    private static final String password = resourceBundle.getString("ftp.password");
    private static final String path = resourceBundle.getString("ftp.path");
    //ftp实例
    private static FTPClient ftpClient;
    //log
    private static final Logger log = LoggerFactory.getLogger(FtpUtil.class);

    /**
     * ftp文件上传入口
     *
     * @param files 前端input传入的图片集合
     */
    public static String fileUpload(MultipartFile[] files) {
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        try {
            //连接FTP
            if (!FtpUtil.ftpConnect()) return null;
            for (MultipartFile file : files) {
                //获取上传的文件名
                String fileName = file.getOriginalFilename();
                //判断上传的文件是否为空
                if (StringUtil.isNull(fileName)) continue;
                //获取文件后缀
                String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
                //随机字符串生成,当前时间+随机字符串=文件名
                fileName = DateUtil.getNoFormatTime().concat(RandomUtil.getRandomString(8)).concat(suffix);
                //将文件转成流
                is = file.getInputStream();
                //图片压缩
                is = ImageUtil.imgZip(is, suffix.substring(1));
                //上传图片
                if (FtpUtil.ftpUpload(fileName, is)) {
                    sb.append(";").append(fileName);
                }
            }
        } catch (IOException e) {
            log.error("FTP文件上传时出错");
            System.out.println("FTP文件上传时出错");
        } finally {
            //关闭流
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                log.error("FTP上传时流关闭错误");
                System.out.println("FTP上传时流关闭错误");
            }
            //关闭FTP连接
            FtpUtil.closeConnect();
        }
        return sb.toString().substring(1);
    }

    /**
     * ftp文件删除入口
     *
     * @param name 删除的文件名
     * @return 删除是否成功
     */
    public static Boolean fileDelete(String name) {
        if (StringUtil.isNull(name)) return false;
        boolean result = true;
        try {
            if (!FtpUtil.ftpConnect()) return false;
            result = ftpDelete(name);
        } catch (IOException e) {
            log.error("FTP上传时流关闭错误");
            System.out.println("FTP上传时流关闭错误");
        } finally {
            FtpUtil.closeConnect();
        }
        return result;
    }

    /**
     * 第一步
     * 建立ftp连接
     *
     * @return 是否连接成功
     */
    private static boolean ftpConnect() {
        //实例化一个ftp客户端
        ftpClient = new FTPClient();
        try {
            //建立ftp连接
            ftpClient.connect(url, port);
            //输入ftp账号密码
            ftpClient.login(username, password);
            //主动模式
            //ftpClient.enterLocalActiveMode();
            //被动模式
            ftpClient.enterLocalPassiveMode();
            // 看返回的值是不是230，如果是，表示登陆成功
            int reply = ftpClient.getReplyCode();
            //判断是否连接成功
            if (!FTPReply.isPositiveCompletion(reply)) {
                log.info("FTP连接失败");
                System.out.println("FTP连接失败");
                //连接失败时断开连接
                ftpClient.disconnect();
                //返回false
                return false;
            }
            //设置ftp连接目录
            if (!isDirectory()) return false;
            //设置文件编码格式
            //ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        } catch (IOException e) {
            log.error("FTP连接错误");
            System.out.println("FTP连接错误");
        }
        return true;
    }

    /**
     * 第二步
     * 设置ftp连接目录
     *
     * @return 目录是否连接成功
     */
    private static Boolean isDirectory() {
        try {
            //切换目录,切换成功返回true
            if (!ftpClient.changeWorkingDirectory(path)) {
                System.out.println(path);
                //如果目录不存在创建目录
                String[] dirs = path.split("/");
                String path = "";
                for (String dir : dirs) {
                    if (StringUtil.isNull(dir)) continue;
                    path = path.concat("/").concat(dir);
                    //切换目录失败则创建目录
                    if (!ftpClient.changeWorkingDirectory(path)) {
                        //创建失败则方法结束
                        if (!ftpClient.makeDirectory(path)) {
                            log.error("FTP目录切换失败");
                            System.out.println("FTP目录创建失败");
                            return false;
                        }
                    }
                }
                //目录创建成功,切换到该目录
                ftpClient.changeWorkingDirectory(path);
            }
        } catch (IOException e) {
            log.error("FTP目录切换失败");
            System.out.println("FTP目录切换失败");
        }
        return true;
    }

    /**
     * 第三步,上传或者删除
     * ftp文件上传
     *
     * @param is       上传的文件
     * @param fileName 上传的文件名
     * @return 是否上传成功
     */
    private static boolean ftpUpload(String fileName, InputStream is) throws IOException {
        return !StringUtil.isNull(fileName) && is != null && ftpClient.storeFile(fileName, is);
    }

    /**
     * 第三步,上传或者删除
     * ftp文件删除
     *
     * @param fileName 删除的文件名
     * @return 是否删除成功
     */
    private static boolean ftpDelete(String fileName) throws IOException {
        return !StringUtil.isNull(fileName) && ftpClient.deleteFile(new String(fileName.getBytes("GBK"), "ISO-8859-1"));
    }

    /**
     * 最后一步
     * 退出并关闭FTP连接
     */
    private static void closeConnect() {
        try {
            //判断是否还连接
            if (ftpClient != null && ftpClient.isConnected()) {
                //退出登录
                ftpClient.logout();
                //关闭ftp连接
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            log.error("FTP连接断开失败");
            System.out.println("FTP连接断开失败");
        }
    }
}