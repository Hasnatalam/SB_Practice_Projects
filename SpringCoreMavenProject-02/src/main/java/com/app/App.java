package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.sbeans.Student;

public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "com/app/cfgs/applicationContext.xml");

        Student student = context.getBean("student", Student.class);

        student.display();
    }
}