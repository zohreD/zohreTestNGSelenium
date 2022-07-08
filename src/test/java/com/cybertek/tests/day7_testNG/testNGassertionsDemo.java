package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGassertionsDemo {

    @Test
    public void test1(){

        Assert.assertEquals("title","title");

    }

    @Test
    public void test2(){
        //verify email contains @
        String email = "mike@smith.com";
        Assert.assertTrue(email.contains("@"), "verify email contains @");
    }
    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "verify title starts with Cyb ");
    }

    @Test
    public void test4(){
        Assert.assertFalse(0>1);
    }






}
