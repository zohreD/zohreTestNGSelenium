package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@cybertek.com");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        Thread.sleep(3000);

        String actualURL = driver.getCurrentUrl();

        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        if(expectedURL.equalsIgnoreCase(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedURL" + expectedURL);
            System.out.println("actualURL" + actualURL);
        }

        driver.quit();




    }


}
