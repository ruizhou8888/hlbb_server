package com.hlbb.frm.kit;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailKit {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired  
    private JavaMailSender mailSender;  
      
    @Value("${spring.mail.username}")  
    private String from;  
    
    
    public void sendHtmlMail(String to, String subject, String content){  
        MimeMessage message = mailSender.createMimeMessage();  
  
        try {  
            //true表示需要创建一个multipart message  
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  
            helper.setFrom(from);  
            helper.setTo(to);  
            helper.setSubject(subject);  
            helper.setText(content, true);  
  
            mailSender.send(message);  
            logger.info("html邮件已经发送。");  
        } catch (MessagingException e) {  
            logger.error("发送邮件时发生异常！", e);  
        }  
    }
    
    public void sendEmailCode(String to){
    	String subject = "海里巴巴注册";
    	long code = Math.round(Math.random()*9000+1000);
    	String content = "<p>Hi,"+to+"</p><p>感谢您注册海里巴巴！验证码："+code+"</p><p>如果您没有进行此操作，请忽略该邮件。</p>";
    	sendHtmlMail(to,subject,content);
    }
}
