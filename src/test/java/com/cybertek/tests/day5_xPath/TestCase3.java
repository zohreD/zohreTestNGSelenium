package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.wikipedia.org");

        WebElement enterSearchTerm = driver.findElement(By.id("searchInput"));
        enterSearchTerm.sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@value='selenium webdriver']")).clear();


        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Selenium (software)");

        driver.findElement(By.xpath("//span[@class='oo-ui-labelElement-label']")).click();

        String actualURL = driver.getCurrentUrl();

        String expectedURL = "https://www.wikipedia.org/Selenium_(software)";

        if(expectedURL.equalsIgnoreCase(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver.quit();





    }
}
