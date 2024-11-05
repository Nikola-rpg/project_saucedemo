package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFunctionality extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void userCanLogInWithValidUsernameAndPassword() {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        String logInLink = driver.getCurrentUrl();
        loginPage.clickOnLoginButton();
        Assert.assertNotEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        Assert.assertTrue(homepagePage.InvenotoryHeaderTitle.isDisplayed());

    }

    @Test(priority = 20)
    public void userCanNotLogInWithInvalidUsername() {
        loginPage.userNameField.sendKeys("not_standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        String logInLink = driver.getCurrentUrl();
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertTrue(loginPage.failedNotification.getText().contains("Username and password do not match any user in this service"));
    }

    @Test(priority = 30)
    public void usrCanNotLogInWithInvalidPassword() {
        loginPage.userNameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("not_secret_sauce");
        String logInLink = driver.getCurrentUrl();
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertTrue(loginPage.failedNotification.getText().contains("Username and password do not match any user in this service"));
    }

    @Test(priority = 40)
    public void userCanNotLogInWithInvalidUsernameAndInvalidPassword() {
        loginPage.userNameField.sendKeys("not_standard_user");
        loginPage.passwordField.sendKeys("not_secret_sauce");
        String logInLink = driver.getCurrentUrl();
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertTrue(loginPage.failedNotification.getText().contains("Username and password do not match any user in this service"));
    }

    @Test(priority = 50)
    public void userCanNotLogInWithEmptyUsernameField() {
        loginPage.userNameField.clear();
        loginPage.passwordField.sendKeys("secret_sauce");
        String logInLink = driver.getCurrentUrl();
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertTrue(loginPage.failedNotification.getText().contains("Username is required"));
    }

    @Test(priority = 60)
    public void userCanNotLogInWithEmptyPasswordField() {
        loginPage.userNameField.sendKeys("standard_user");
        loginPage.passwordField.clear();
        String logInLink = driver.getCurrentUrl();
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertTrue(loginPage.failedNotification.getText().contains("Password is required"));
    }

    @Test(priority = 70)
    public void userCanNotLogInWithEmptyUsernameAndPasswordField() {
        loginPage.userNameField.clear();
        loginPage.passwordField.clear();
        String logInLink = driver.getCurrentUrl();
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), logInLink);
        Assert.assertTrue(loginPage.failedNotification.getText().contains("Username is required"));
    }

}
