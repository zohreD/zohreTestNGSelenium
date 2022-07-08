package com.cybertek.tests.day7_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @Test
    public void test1(){
        System.out.println("First Test Case");
    }

    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Webdriver, Opening Browser");
    }

    @AfterClass
    public void quit(){
        System.out.println("Webdriver, closing Browser");
    }


    @AfterClass
    public void afterClss(){
        System.out.println("Report");
    }

}
