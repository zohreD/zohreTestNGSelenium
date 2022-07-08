package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {


    @Test
    public void wrongPasswordTest() {
        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: User1");
        loginPage.usernameInput.sendKeys("User1");

        extentLogger.info("Enter Password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");
    }


    @Test
    public void wrongUsernameTest(){

        extentLogger = report.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: someUsername");
        loginPage.usernameInput.sendKeys("someUsername");

        extentLogger.info("Enter Password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("PASSED");
    }




}
