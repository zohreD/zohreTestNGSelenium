package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();

        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {

            System.out.println(option.getText());

        }
    }
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        //1. select using getfirst...
        String expectedOption = "Select a State";

        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption, expectedOption, "verify it is Virginia");

        //2.Select using index
        stateDropdown.selectByIndex(51);
        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify it is wyoming");

        //3. select by value
        stateDropdown.selectByValue("TX");
        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify it is Texas");




    }

}