package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class TestCase2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com");

        WebElement enterInput = driver.findElement(By.name("_nkw"));
        enterInput.sendKeys("selenium");
        WebElement clickSearchButton = driver.findElement(By.id("gh-btn"));
        clickSearchButton.click();

        if(driver.getTitle().contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();



    }
}
