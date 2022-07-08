package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.cssSelector("#tinymce")).clear();

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //if you have 2 frames and would like to move back then you use

        driver.switchTo().defaultContent();

        //if you have multiple frames then you use

        driver.switchTo().frame(0);

        //another way is using webelement

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with webelement");


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.id(\"content\")) = " + driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);

        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());





    }
}
