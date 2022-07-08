package com.cybertek.tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Vytrack_HW extends TestBase{

    DashboardPage dashboardPage;
    @BeforeMethod
    public void LoginAsStoreManager(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

    }

    @Test
    public void TestCase_001(){

       String actualSub = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']")).getText();
       String expectedSub ="Options";
        Assert.assertEquals(actualSub, expectedSub, "verify subs");

    }
    @Test
    public void TestCase_002(){

        String actualPageNum = driver.findElement(By.xpath("//input[@value='1']")).getAttribute("value");
        String expectedPageNum = "1";
        Assert.assertEquals(actualPageNum, expectedPageNum, "verify page num");
    }

    @Test
    public void TestCase_003(){
        String actualViewNum = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText();
        String expected = "25";
        Assert.assertEquals(actualViewNum, expected, "verify view nums");
    }
    @Test
    public void TestCase_004(){

    }
}
