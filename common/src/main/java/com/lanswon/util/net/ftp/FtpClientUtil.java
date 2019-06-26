package com.lanswon.util.net.ftp;

import com.lanswon.util.codec.EncodingEnum;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * ftp客户端
 * @author jaswine
 */
public class FtpClientUtil {

    // todo 需要大修改

    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "101.132.1.113";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "ftp";
    //密码
    private static final String FTP_PASSWORD = "123456";
    //图片路径
    private static final String FTP_BASEPATH = "/home/ftpadmin/health/images";

    /**
     * 上传文件
     * @param originFileName
     * @param input
     * @return
     */
    public  static boolean uploadFile(String originFileName, InputStream input){

        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            ftp.changeWorkingDirectory(FTP_BASEPATH );
            ftp.storeFile(originFileName,input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }
}
