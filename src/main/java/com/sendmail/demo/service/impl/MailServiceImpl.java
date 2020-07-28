package com.sendmail.demo.service.impl;

import com.sendmail.demo.service.MailService;
import com.sendmail.demo.util.MailUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;

@Service
public class MailServiceImpl  implements MailService {

    @Resource
    private MailUtil mailUtil;

    //发送text格式的邮件
    @Override
    public void sendAuthMail() {
        String from = "demouser@163.com";
        String[] to = {"371125307@qq.com"};
        String subject = "老刘代码库发送给您的验证码";
        String[] cc = {};
        String[] bcc = {};
        String content = "您的验证码：543210,请勿泄露";
        String[] files = {"/data/springboot2/logo.jpg"};
        try {
            mailUtil.sendTextMail(from,to,cc,bcc,subject,content,files);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送出错");
        }
    }

    //发送html格式的邮件
    @Override
    public void sendRegMail() {
        String from = "demouser@163.com";
        String[] to = {"371125307@qq.com"};
        String subject = "恭喜您成功注册老刘代码库网站";
        //String content = "邮件已发送成功";
        HashMap<String,String> content= new HashMap<String,String>();
        content.put("username","laoliu");
        content.put("nickname","老刘");
        content.put("id","0000001");
        String templateName= "mail/regmail.html";
        try {
            mailUtil.sendHtmlMail(from, to, null, null, subject, templateName, content);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送出错");
        }
    }
}
