package com.cybertek.tests.day15_revieew;

import com.cybertek.pages.ContactsInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void verification() {
        extentLogger = report.createTest("FullName, email, and phone number verification");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as Sales Manager");
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Navigate to ---> Customers ----> Contacts");
        dashboardPage.navigateToModule("Customers", "Contacts");

        dashboardPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on email");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactsInfoPage contactsInfoPage = new ContactsInfoPage();

        extentLogger.info("Verify Full Name is Mariam Brackstone");
        Assert.assertEquals(contactsInfoPage.fullname.getText(), "Mariam Brackstone", "verify fullname");

        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactsInfoPage.phone.getText(), "+18982323434", "verify phone number");

        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactsInfoPage.email.getText(), "mbrackstone9@example.com", "verify emails");


        extentLogger.pass("PASSED");

    }


}
