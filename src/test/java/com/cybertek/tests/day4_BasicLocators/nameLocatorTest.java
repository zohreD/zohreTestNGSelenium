package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike_smith@yahoo.com");

        //lazy way
        driver.findElement(By.name("email")).sendKeys();

        WebElement clickSignUp = driver.findElement(By.name("wooden_spoon"));
        clickSignUp.click();


        //lazy way :)
        driver.findElement(By.name("wooden_spoon")).click();








    }

}
