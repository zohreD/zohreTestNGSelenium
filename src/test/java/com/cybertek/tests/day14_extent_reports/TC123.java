package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC123 extends TestBase {

    @Test
    public void TC123(){

        extentLogger = report.createTest("FullName, email, and phone number verification");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as Sales Manager");
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Navigate the dashboard: Customers to Contacts");
        dashboardPage.navigateToModule("Customers", "Contacts");

        dashboardPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on email");

        driver.findElement(By.xpath("//*[text()='mbrackstone9@example.com'][@data-column-label='Email']")).click();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = driver.findElement(By.xpath("(//h1[@class='user-name'])")).getText();

        extentLogger.info("Verify Full Name");
        Assert.assertEquals(actualFullName, expectedFullName, "verify full name");

        String expectedEmail = "mbrackstone9@example.com";
        String actualEmail = driver.findElement(By.cssSelector("a[title='mbrackstone9@example.com']")).getText();

        extentLogger.info("Verify email");
        Assert.assertEquals(actualEmail, expectedEmail , "verify emails");

        String expectedPhoneNumber = "+18982323434";
        String actualPhoneNumber = driver.findElement(By.cssSelector("a.phone")).getText();

        extentLogger.info("Verify phone number");
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, "verify phone numbers");


        extentLogger.pass("PASSED");



    }

}
