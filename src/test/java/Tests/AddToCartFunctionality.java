package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartFunctionality extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        megaMenu = new MegaMenu();
        homepagePage = new HomepagePage();
        loginPage = new LoginPage();
        cartPage = new CartPage();
        itemPage = new ItemPage();
    }

    @Test(priority = 10)
    public void userCanAddOneProductToTheCart() {
        loginPage.logIn();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(1, cartPage.cartItems.size());
        Assert.assertTrue(cartPage.cartItemName.get(0).isDisplayed());
        Assert.assertEquals(homepagePage.productName.get(0).getText(), cartPage.cartItemName.get(0).getText());
    }

    @Test(priority = 20)
    public void userCanAddTwoDifferentProductsToTheCartOnInventoryPage() {
        loginPage.logIn();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnTwoAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(2, cartPage.cartItems.size());
        for (int i = 0; i < cartPage.cartItems.size(); i++) {
            Assert.assertTrue(cartPage.cartItemName.get(i).isDisplayed());
            Assert.assertEquals(homepagePage.productName.get(i).getText(), cartPage.cartItemName.get(i).getText());
        }
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 30)
    public void userCanAddAllSixDifferentProductToTheCartOnInventoryPage() {
        loginPage.logIn();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnAllSixAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(6, cartPage.cartItems.size());
        for (int i = 0; i < homepagePage.productName.size(); i++) {
            Assert.assertTrue(cartPage.cartItemName.get(i).isDisplayed());
            Assert.assertEquals(homepagePage.productName.get(i).getText(), cartPage.cartItemName.get(i).getText());
        }
    }

    @Test(priority = 40)
    public void userCanAddOneProductToCartOnItemPage() {
        loginPage.logIn();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnProductName(0);
        itemPage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(1, cartPage.cartItems.size());
        Assert.assertTrue(cartPage.cartItemName.get(0).isDisplayed());
    }

    @Test(priority = 50)
    public void userCanAddTwoDifferentProductsToTheCartOnItemPage() {
        loginPage.logIn();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnProductName(0);
        itemPage.clickOnAddToCartButton();
        itemPage.clickOnBackToProductsLink();
        homepagePage.clickOnProductName(1);
        itemPage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(2, cartPage.cartItems.size());
        for (int i = 0; i < cartPage.cartItems.size(); i++) {
            Assert.assertTrue(cartPage.cartItemName.get(i).isDisplayed());
            Assert.assertEquals(homepagePage.productName.get(i).getText(), cartPage.cartItemName.get(i).getText());
        }
    }

    @Test(priority = 60)
    public void userCanAddAllSixDifferentProductsToTheCartOnItemPages() {
        loginPage.logIn();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
        cartPage.clickOnContinueShopingButton();
        for (int i = 0; i < homepagePage.productName.size(); i++) {
            homepagePage.clickOnProductName(i);
            itemPage.clickOnAddToCartButton();
            itemPage.clickOnBackToProductsLink();
        }
        megaMenu.clickOnCartButton();
        Assert.assertEquals(6, cartPage.cartItems.size());
        for (int i = 0; i < homepagePage.productName.size(); i++) {
            Assert.assertTrue(cartPage.cartItemName.get(i).isDisplayed());
            Assert.assertEquals(homepagePage.productName.get(i).getText(), cartPage.cartItemName.get(i).getText());
        }
    }

}
