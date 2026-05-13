package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.AppConfig;
import com.app.sbeans.WishMessageGenerator;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
       // ApplicationContext context = new ClassPathXmlApplicationContext("com/app/config/applicationContext.xml");
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        WishMessageGenerator bean = context.getBean(WishMessageGenerator.class);
        System.out.println(bean.getWishMassage());
    }
}
