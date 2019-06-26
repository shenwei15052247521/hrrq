package com.lanswon.core.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * FTP客户端工具类
 *
 * @author Jaswine
 */
public class FtpUtilsApache {

    /** 字符编码 */
    private static final String UTF_8 = "UTF-8";
    /** 超时时长 */
    private static final int TIMEOUT = 6000;
    /** 缓冲池大小 */
    private static final int BUFFER_SIZE = 1024 * 4;

    @Value("${ftp.ip}")
    private String ip
            ;
    /**
     * 获得FTPclient
     *
     * @param ipAddress IP地址
     * @param port      端口
     * @param username  用户名
     * @param password  密码
     */
    public static FTPClient login(String ipAddress, int port, String username, String password) throws IOException {
        FTPClient client = new FTPClient();
        /* 超时时长 */
        client.setDefaultTimeout(TIMEOUT);
        client.setConnectTimeout(TIMEOUT);
        client.setDataTimeout(TIMEOUT);
        /* buffer池大小 */
        client.setBufferSize(BUFFER_SIZE);
        /* 字符编码 */
        client.setControlEncoding(UTF_8);
        client.connect(ipAddress, port);
        client.login(username, password);
        /* 主动模式，长时间端口占用 */
        client.enterLocalActiveMode();
        return client;
    }

    /**
     * 登出FTP服务器
     */
    public static void logout(FTPClient client) throws IOException {
        if (client != null) {
            client.logout();
            client.disconnect();
        }
    }

    /**
     * 获取指定路径下的文件列表
     */
    public static FTPFile[] getFTPFiles(FTPClient client, String path) throws IOException {
        if (client == null || !client.isConnected()) {
            throw new IllegalArgumentException("FtpClient has bean closed!");
        }

        return client.listFiles(path);
    }

    /**
     * 在指定目录下创建目录
     *
     * @param path    在哪个目录下创建
     * @param dirName 要创建的目录名称
     */
    public static boolean mkDir(FTPClient client, String path, String dirName) {
        if (client == null || !client.isConnected()) {
            throw new IllegalArgumentException("FtpClient has bean closed!");
        }

        try {
            client.changeWorkingDirectory(path);
            return client.makeDirectory(dirName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 在指定目录下删除文件
     *
     * @param path     在哪个目录下删除
     * @param fileName 要删除的文件名称
     */
    public static boolean deleteFile(FTPClient client, String path, String fileName) {
        if (client == null || !client.isConnected()) {
            throw new IllegalArgumentException("FtpClient has bean closed!");
        }

        try {
            client.changeWorkingDirectory(path);
            return client.deleteFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 向FTP服务器上传文件
     *
     * @param file 要上传的文件
     * @param path 上传路径(/var/ftp/pub/)
     */
    public static boolean upload(FTPClient client, File file, String path) {
        return upload(client, Arrays.asList(file), path);
    }

    /**
     * 向FTP服务器上传文件
     *
     * @param files 要上传的文件
     * @param path  上传路径
     */
    public static boolean upload(FTPClient client, List<File> files, String path) {
        if (client == null || !client.isConnected()) {
            throw new IllegalArgumentException("FtpClient has bean closed!");
        }

        BufferedInputStream bis = null;
        try {
            client.changeWorkingDirectory(path);
            client.setFileType(FTPClient.BINARY_FILE_TYPE);
            for (File file : files) {
                bis = new BufferedInputStream(new FileInputStream(file));
                client.storeFile(file.getName(), bis);
                bis.close();
                bis = null;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 上传文件
     * @param client ftp客户端
     * @param path 上传路径
     * @param filename 文件名
     * @param ins 流
     * @return rres
     */
    public static boolean uploadFile(FTPClient client, String path, String filename, InputStream ins) throws IOException {
        boolean success = false;
        client.setFileType(FTP.BINARY_FILE_TYPE);
        try {
            if (client.changeWorkingDirectory(path)) {
                if (client.storeFile(filename, ins)) {
                    success =true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client.isConnected()) {
                try {
                    client.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    /**
     * 从FTP服务器下载文件
     *
     * @param fileName 要下载的文件名("test_1.txt")
     * @param srcPath  FTP服务器文件的路径(/var/ftp/pub/)
     * @param destPath 下载后保存的路径(E:/workspace/utils/)
     */
    public static boolean download(FTPClient client, String fileName, String srcPath, String destPath) {
        return download(client, Arrays.asList(fileName), srcPath, destPath);
    }

    /**
     * 从FTP服务器下载文件
     *
     * @param fileNames 要下载的文件名(Arrays.asList("test_1.txt", "test_2.txt");)
     * @param srcPath   FTP服务器文件的路径(/var/ftp/pub/)
     * @param destPath  下载后保存的路径(E:/workspace/utils/)
     */
    public static boolean download(FTPClient client, List<String> fileNames, String srcPath, String destPath) {
        if (client == null || !client.isConnected()) {
            throw new IllegalArgumentException("FtpClient has bean closed!");
        }

        BufferedOutputStream bos = null;
        try {
            client.changeWorkingDirectory(srcPath);
            client.setFileType(FTPClient.BINARY_FILE_TYPE);
            for (String fileName : fileNames) {
                bos = new BufferedOutputStream(new FileOutputStream(destPath + "/" + fileName));
                client.retrieveFile(fileName, bos);
                bos.close();
                bos = null;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 判断文件是否存在
     *
     * @param client   ftp客户端
     * @param path     路径
     * @param filename 文件名
     * @return boolean
     * @throws IOException 异常
     */
    public static boolean isFileExsits(FTPClient client, String path, String filename) throws IOException {
        FTPFile[] files = getFTPFiles(client, path);
        if (files.length == 0) {
            return false;
        }
        for (FTPFile file : files) {
            if (filename.equals(file.getName())) {
                return true;
            }
        }
        return false;
    }
}