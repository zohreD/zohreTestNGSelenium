package com.cybertek.tests.day9_popups_tabs_frames;

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
import java.util.Set;

public class TestCasesHW1_5 {

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
    public void test1_BirthDate(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        WebElement enterDate = driver.findElement(By.cssSelector("input[name='birthday']"));
        enterDate.sendKeys("wrong_dob");

        String expectedText = "The date of birth is not valid";

       WebElement getText = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        String actualText = getText.getText();

        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void test2_programingLang(){

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        List<WebElement> languages = driver.findElements(By.xpath("//label[@class='form-check-label']"));

        System.out.println("languages.size() = " + languages.size());

        Assert.assertEquals(languages.get(0).getText(), "C++");
        Assert.assertEquals(languages.get(1).getText(), "Java");
        Assert.assertEquals(languages.get(2).getText(), "JavaScript");

    }
    @Test
    public void test3_firstName(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("input[name='firstname']"));
        inputBox.sendKeys("z");

        String expectedText = "first name must be more than 2 and less than 64 characters long";

        String actualText = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();

        Assert.assertEquals(actualText, expectedText);

    }
    @Test
    public void test4_lastName(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("input[name='lastname']"));
        inputBox.sendKeys("z");

        String expectedText = "The last name must be more than 2 and less than 64 characters long";

        String actualText = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).getText();

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void test5(){

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        WebElement FirstNameBox = driver.findElement(By.cssSelector("input[name='firstname']"));
        FirstNameBox.sendKeys("Mike");

        WebElement LastnameBox = driver.findElement(By.cssSelector("input[name='lastname']"));
        LastnameBox.sendKeys("Smith");

        WebElement usernameBox = driver.findElement(By.cssSelector("input[name='username']"));
        usernameBox.sendKeys("mikesmith");

        WebElement emailBox = driver.findElement(By.cssSelector("input[name='email']"));
        emailBox.sendKeys("mike@smith.com");

        WebElement passwordBox = driver.findElement(By.cssSelector("input[name='password']"));
        passwordBox.sendKeys("mikesmith123");

        WebElement phoneBox = driver.findElement(By.cssSelector("input[name='phone']"));
        phoneBox.sendKeys("571-000-0000");

        WebElement selectGender = driver.findElement(By.cssSelector("input[value='male']"));
        selectGender.click();

        WebElement enterDate = driver.findElement(By.cssSelector("input[name='birthday']"));
        enterDate.sendKeys("9/11/2011");

        WebElement selectDepartment = driver.findElement(By.name("department"));

        Select department = new Select(selectDepartment);

        department.selectByVisibleText("Accounting Office");

        WebElement selectJobTitle = driver.findElement(By.name("job_title"));

        Select jobTitle = new Select(selectJobTitle);

        jobTitle.selectByVisibleText("Developer");

        driver.findElement(By.cssSelector("input[value='java']")).click();

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String actualText = driver.findElement(By.xpath("//div[@class='alert alert-success']/p")).getText();

        String expectedText = "You've successfully completed registration!";

        Assert.assertEquals(actualText, expectedText, "success message is displayed");








    }

}
