package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "verify repeat is selected");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "verify weekday is not selected");

    }

    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatDropdown.getOptions();

        for (WebElement options : actualOptions) {
            actualList.add(options.getText());

        }
    //easy way of doing the list below
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList, expectedList, "verify daily weekly yearly are the same");

        Assert.assertEquals(actualList2, expectedList, "verify daily weekly yearly are the same");



    }
}
