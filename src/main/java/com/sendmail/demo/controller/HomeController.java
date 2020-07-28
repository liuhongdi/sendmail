package com.sendmail.demo.controller;

import com.sendmail.demo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping("/home")
@Controller
public class HomeController {

    private static Logger log= LoggerFactory.getLogger(HomeController.class);

    @Resource
    private MailService mailService;

    //发送一封注册成功的邮件,html格式
    @GetMapping("/regmail")
    @ResponseBody
    public String regMail() {
        mailService.sendRegMail();
        return "mail sended";
    }

    //发送一封注册成功的邮件,text格式
    @GetMapping("/authmail")
    @ResponseBody
    public String authMail() {
        mailService.sendAuthMail();
        return "mail sended";
    }
}
