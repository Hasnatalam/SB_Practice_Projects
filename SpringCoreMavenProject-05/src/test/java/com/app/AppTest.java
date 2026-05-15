package com.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.app.config.AppConfig;
import com.app.sbeans.WishMessageGenerator;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    private WishMessageGenerator wishMessageGenerator;

    
    @BeforeAll
    public static void beforeAll() {
    	System.out.println("Before All");
    }
    @BeforeEach
    public void beforeEach() {
    	System.err.println("Before Each");
    }
    @AfterEach
    public void afterEach() {
    	System.out.println("After Each");
    }
    @AfterAll
    public static void afterAll() {
    	System.out.println("After All");
    }
    
    @Test
    public void getMassageTest() {

        String actual = wishMessageGenerator.getWishMassage();

        String expected = "Good After noon";
        System.out.println("getMassageTest");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getSumTest() {

        int actual = wishMessageGenerator.getSum(1,2);

        int expected = 3;
        System.out.println("getSumTest");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getSumOfAllTest() {
    	int actual = wishMessageGenerator.getSumOfAll(1,2,3,4,5);
    	int expectd = 15;

        System.out.println("getSumOfAllTest");
    	Assertions.assertEquals(expectd, actual);
    }
}