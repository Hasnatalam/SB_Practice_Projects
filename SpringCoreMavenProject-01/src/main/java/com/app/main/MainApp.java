package com.app.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.app.beans.Student;

public class MainApp 
{
    public static void main(String[] args) 
    {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext(
//                        "com/app/cfgs/applicationContext.xml");
//
//        Student student =
//                context.getBean("student", Student.class);
        ClassPathResource resource =
                new ClassPathResource("com/app/cfgs/applicationContext.xml");

        BeanFactory factory =
                new XmlBeanFactory(resource);

        Student student =
                factory.getBean("student", Student.class);

        student.display();
    }
}