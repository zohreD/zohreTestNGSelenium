package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 0; i <=3; i++) {
             String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));

            Actions actions = new Actions(driver);
            actions.moveToElement(img).perform();

            String xpathText = "//h5[.='name: user"+i+"']";
            WebElement text = driver.findElement(By.xpath(xpathText));
            Assert.assertTrue(text.isDisplayed(), "verify "+i+" is displayed");
        }
    }

}
