package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class disabledElements {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement disabledBtn = driver.findElement(By.id("green"));

        Assert.assertFalse(disabledBtn.isEnabled());

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement disabledBox = driver.findElement(By.cssSelector("[type='text']"));

        WebElement enableBtn = driver.findElement(By.cssSelector("[onclick='swapInput()']"));

        enableBtn.click();

        Thread.sleep(3000);

        disabledBox.sendKeys("Hello World");




    }
}
