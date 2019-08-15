package com.example.SpringBootVideo.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.util.Random;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {
	
	 //ftp服务器地址
    public String hostname = "192.168.171.187";
    //ftp服务器端口号默认为21
    public Integer port = 21 ;
    //ftp登录账号
    public String username = "majunjie";
    //ftp登录密码
    public String password = "123";
    
    public FTPClient ftpClient = null;
    
       
    /**
     * 初始化ftp服务器
     */
    public void initFtpClient() {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            System.out.println("connecting...ftp服务器:"+this.hostname+":"+this.port); 
            ftpClient.connect(hostname, port); //连接ftp服务器
            ftpClient.login(username, password); //登录ftp服务器
            int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
            if(!FTPReply.isPositiveCompletion(replyCode)){
                System.out.println("connect failed...ftp服务器:"+this.hostname+":"+this.port); 
            }
            System.out.println("connect successfu...ftp服务器:"+this.hostname+":"+this.port); 
        }catch (MalformedURLException e) { 
           e.printStackTrace(); 
        }catch (IOException e) { 
           e.printStackTrace(); 
        } 
    }
    
    
    
    /**
     *文件上传 
     */
	
	public  Boolean upload(InputStream inputStream,String fileName) throws SocketException, IOException{
		
		initFtpClient();
		
		System.out.println("准备上传");
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);	
		System.out.println("开始上传");
		ftpClient.storeFile(fileName, inputStream);
		ftpClient.logout();
		return true;
				
	}
	

}
