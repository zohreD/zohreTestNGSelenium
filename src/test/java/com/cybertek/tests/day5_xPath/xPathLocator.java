package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='button2()']"));

        button2.click();

        Thread.sleep(3000);

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button1 = driver.findElement(By.xpath("//*[.='Button 1']"));

        button1.click();

        Thread.sleep(2000);

        driver.quit();




    }
}
