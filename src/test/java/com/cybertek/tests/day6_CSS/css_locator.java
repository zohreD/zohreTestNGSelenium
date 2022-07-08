package com.cybertek.tests.day6_CSS;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class css_locator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement donclick= driver.findElement(By.cssSelector("#disappearing_button"));

        System.out.println(donclick.getText());

        driver.quit();

        //button[starts-with(@id,'button_')]
    }
}
