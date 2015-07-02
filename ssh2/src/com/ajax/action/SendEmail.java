package com.ajax.action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	private String userEmail;//用户邮箱
	private String verificationCode;//验证码
	
	

 
    public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public void sendEmail() throws Exception {
         
         Properties prop = new Properties();
         prop.setProperty("mail.host", "smtp.163.com");
         prop.setProperty("mail.transport.protocol", "smtp");
         prop.setProperty("mail.smtp.auth", "true");        //使用JavaMail发送邮件的5个步骤
         //1、创建session
         Session session = Session.getInstance(prop);
         //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
         session.setDebug(true);
         //2、通过session得到transport对象
         Transport ts = session.getTransport();
         //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
         ts.connect("smtp.163.com", "a373791230", "kxqhblanfxidxtyy");
         //4、创建邮件
         Message message = createSimpleMail(session);
         //5、发送邮件
         ts.sendMessage(message, message.getAllRecipients());
         ts.close();
     }
      
     public  MimeMessage createSimpleMail(Session session)
             throws Exception {
         //创建邮件对象
         MimeMessage message = new MimeMessage(session);
         //指明邮件的发件人
         message.setFrom(new InternetAddress("a373791230@163.com"));
         //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
         message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
         //邮件的标题
         message.setSubject("更改密码验证");
         //邮件的文本内容
         message.setContent("你好,以下验证码是用来验证您是否可以更改密码 /n验证码："+verificationCode, "text/html;charset=UTF-8");
         //返回创建好的邮件对象
         return message;
     }
 }