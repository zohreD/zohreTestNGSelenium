package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webtableExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getHeaders(){
        //how many columns

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

    }
    @Test
    public void printTableSize(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        List<WebElement> rowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rowsWithHeaders.size() = " + rowsWithHeaders.size());

        List<WebElement> allRowsWOheader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println("allRowsWOheader.size() = " + allRowsWOheader.size());
    }
    @Test
    public void getRow(){
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= numRows.size() ; i++) {

            WebElement rows = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i + "-" + rows.getText());

        }
    }
    @Test
    public void getAllCellInOneRow(){

        List<WebElement> cellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        System.out.println("cellsInOneRow.size() = " + cellsInOneRow.size());
        for (WebElement element : cellsInOneRow) {

            System.out.println(element.getText());

        }

    }   @Test
    public void getAsingleCellByIndex(){

        List<WebElement> cellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        WebElement singleElement = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singleElement.getText() = " + singleElement.getText());

    }
    @Test
    public void printAllCellsByIndex(){
        
        int rowNum = getRowNumber();
        int colNum = getColumnNumber();

        for (int i = 1; i <= getRowNumber(); i++) {

            for (int j = 1; j <= getColumnNumber(); j++) {

                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";

                System.out.println("cellXpath = " + cellXpath);

                WebElement singleElement = driver.findElement(By.xpath(cellXpath));
                System.out.println("singleElement.getText() = " + singleElement.getText());

            }

        }
        
        
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstName = "Jason";

        String xpath = "//table[@id='table1']/tbody/tr/*[text()='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }

    private int getColumnNumber() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        return headers.size();
    }

    private int getRowNumber() {
        List<WebElement> allRowsWOheader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWOheader.size();
    }

}
