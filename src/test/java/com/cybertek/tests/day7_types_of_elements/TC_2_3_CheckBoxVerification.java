package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_2_3_CheckBoxVerification {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement succesMessage = driver.findElement(By.xpath("//div[text()='Success - Check box is checked']"));

        Assert.assertFalse(succesMessage.isDisplayed(), "is not displayed");

        WebElement checkBox = driver.findElement(By.xpath("(//label/input[@*='checkbox'])[1]"));

        checkBox.click();

        Assert.assertTrue(succesMessage.isDisplayed(),"is displayed");


        Thread.sleep(3000);



        Assert.assertTrue(checkBox.isDisplayed(), "is displayed");



    }

    @Test
    public void test2(){

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        String ExpectedCheckBtn = "Check All";

        WebElement checkAll = driver.findElement(By.cssSelector("[value='Check All']"));

        String checkAllText = checkAll.getAttribute("value");

        Assert.assertTrue(ExpectedCheckBtn.equals(checkAllText));

        checkAll.click();

        WebElement checkbox1 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input[@type='checkbox'])[2]"));
        Assert.assertTrue(checkbox1.isSelected(),"verify is selected");

        WebElement checkbox2 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input[@type='checkbox'])[3]"));
        Assert.assertTrue(checkbox2.isSelected());

        WebElement checkbox3 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input[@type='checkbox'])[4]"));
        Assert.assertTrue(checkbox3.isSelected());

        WebElement checkbox4 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input[@type='checkbox'])[5]"));
        Assert.assertTrue(checkbox4.isSelected());

        String expedtedText = "Uncheck All";
        WebElement uncheckAll = driver.findElement(By.cssSelector("[value='Uncheck All']"));
        String actualResult = uncheckAll.getAttribute("value");

        Assert.assertTrue(expedtedText.equals(actualResult));


    }
}
