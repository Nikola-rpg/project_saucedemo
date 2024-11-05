package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutFunctionality extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLogOut() {
        loginPage.logIn();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        megaMenu.clickOnMenuButton();
        megaMenu.clickOnLogoutButton();
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
