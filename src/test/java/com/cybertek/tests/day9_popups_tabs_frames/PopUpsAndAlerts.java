package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {

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
        driver.get("https://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
    }


    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.findElement(By.xpath("//button[1]")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        alert.accept();

        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);

        alert.dismiss();

        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("mikeSmith");

        alert.accept();



    }





}
