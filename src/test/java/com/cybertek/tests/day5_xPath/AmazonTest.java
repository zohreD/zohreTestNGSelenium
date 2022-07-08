package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        driver.findElement(By.name("field-keywords")).sendKeys("selenium");

        driver.findElement(By.id("nav-search-submit-button")).click();

        String expectedResult = "1-48 of 101 results for";

        String actualResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();

        if(expectedResult.equalsIgnoreCase(actualResult)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(3000);

        driver.quit();

    }
}
