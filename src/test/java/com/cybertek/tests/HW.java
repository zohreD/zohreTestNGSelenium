package com.cybertek.tests;

import com.cybertek.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW extends TestBase{

    @DataProvider
    public Object[][] statusCode(){

        String [][] data = {
                {"https://practice-cybertekschool.herokuapp.com/status_codes", "200"},
                {"https://practice-cybertekschool.herokuapp.com/status_codes", "301"},
                {"https://practice-cybertekschool.herokuapp.com/status_codes", "404"},
                {"https://practice-cybertekschool.herokuapp.com/status_codes", "500"}
        };

        return data;
    }

    @Test(dataProvider = "statusCode")
    public void test_9_12(String link, String code){

        driver.get(link);

        driver.findElement(By.cssSelector("a[href='status_codes/"+code+"']")).click();

        String expectedText = "This page returned a " + code+" status code";
        String actualText = driver.findElement(By.xpath("//p")).getText();

        Assert.assertTrue(actualText.contains(expectedText));









    }
}
