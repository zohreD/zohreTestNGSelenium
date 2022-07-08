package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void uploadFileTxt() {

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement inputFile = driver.findElement(By.name("file"));
        inputFile.sendKeys("C:\\Users\\allam\\OneDrive\\Desktop\\Some Text.txt");

        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, "Some Text.txt");

    }

    @Test
    public void fileUploadTest2(){

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement inputFile = driver.findElement(By.name("file"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath + "/" + filePath;

        inputFile.sendKeys(fullPath);

        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, "textfile.txt");




    }

}
