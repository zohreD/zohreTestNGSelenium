package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW2 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        System.out.println(driver.findElement(By.xpath("//a[text()='Home']")).getText());

        System.out.println(driver.findElement(By.xpath("//h2[text()='Forgot Password']")).getText());

        System.out.println(driver.findElement(By.xpath("//*[text()='E-mail']")).getText());

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
        emailInput.sendKeys("mike@smith.com");

        System.out.println(driver.findElement(By.xpath("//button[@*='submit']")).getText());

        driver.quit();


    }
}
