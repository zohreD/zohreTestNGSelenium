package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueButton = driver.findElement(By.cssSelector("#blue"));
        System.out.println("blueButton.getAttribute(\"outerHTML\") = " + blueButton.getAttribute("outerHTML"));
        System.out.println("blueButton.getAttribute(\"type\") = " + blueButton.getAttribute("type"));
        System.out.println("blueButton.getAttribute(\"name\") = " + blueButton.getAttribute("name"));
        System.out.println("blueButton.getAttribute(\"innerHTML\") = " + blueButton.getAttribute("innerHTML"));

        driver.quit();


    }
}
