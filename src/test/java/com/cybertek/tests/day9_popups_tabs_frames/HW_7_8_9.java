package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_7_8_9 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void test7(){

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/upload']")).click();

        WebElement inputFile = driver.findElement(By.name("file"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath + "/" + filePath;

        inputFile.sendKeys(fullPath);

        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, "textfile.txt");

    }

    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/autocomplete']")).click();

        WebElement myCountry = driver.findElement(By.id("myCountry"));
        myCountry.sendKeys("United States of America");

        driver.findElement(By.cssSelector("input[type='button']")).click();


    }


}
