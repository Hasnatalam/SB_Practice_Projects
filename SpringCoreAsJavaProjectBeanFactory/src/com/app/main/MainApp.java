package com.app.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.app.sbeans.Student;

public class MainApp 
{
    public static void main(String[] args) 
    {
        ClassPathResource resource =
                new ClassPathResource("com/app/cfgs/applicationContext.xml");

        BeanFactory factory =
                new XmlBeanFactory(resource);

        Student student =
                factory.getBean("student", Student.class);

        student.display();
    }
}