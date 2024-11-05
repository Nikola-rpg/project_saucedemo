package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveFromCartFunctionality extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void userCanRemoveOneAddedProductFromCartOnInventoryPage() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(1, cartPage.cartItems.size());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnRemoveButton();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 20)
    public void userCanRemoveTwoDifferentProductsFromTheCartOnInventoryPage() {
        loginPage.logIn();
        homepagePage.clickOnTwoAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(2, cartPage.cartItems.size());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnTwoRemoveButtons();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 30)
    public void userCanRemoveAllSixDifferentProductsFromTheCartOnInventoryPage() {
        loginPage.logIn();
        homepagePage.clickOnAllSixAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(6, cartPage.cartItems.size());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnAllSixRemoveButtons();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 40)
    public void userCanRemoveOneAddedProductFromCartOnItemPage() {
        loginPage.logIn();
        homepagePage.clickOnProductName(0);
        itemPage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(1, cartPage.cartItems.size());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnProductName(0);
        itemPage.clickOnRemoveButton();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 50)
    public void userCanRemoveTwoAddedProductsFromCartOnItemPage() {
        loginPage.logIn();
        homepagePage.clickOnTwoAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(2, cartPage.cartItems.size());
        cartPage.clickOnContinueShopingButton();
        homepagePage.clickOnProductName(0);
        itemPage.clickOnRemoveButton();
        itemPage.clickOnBackToProductsLink();
        homepagePage.clickOnProductName(1);
        itemPage.clickOnRemoveButton();
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 60)
    public void userCanRemoveAllSixDifferentProductsFromTheCartOnItemPage() {
        loginPage.logIn();
        homepagePage.clickOnAllSixAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(6, cartPage.cartItems.size());
        cartPage.clickOnContinueShopingButton();
        for (int i = 0; i < homepagePage.productName.size(); i++) {
            homepagePage.clickOnProductName(i);
            itemPage.clickOnRemoveButton();
            itemPage.clickOnBackToProductsLink();
        }
        megaMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 70)
    public void userCanRemoveOneAddedProductFromCartOnCartPage() {
        loginPage.logIn();
        homepagePage.clickOnProductName(0);
        itemPage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(1, cartPage.cartItems.size());
        cartPage.clickOnRemoveButton();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 80)
    public void userCanRemoveTwoAddedProductsFromCartOnCartPage() {
        loginPage.logIn();
        homepagePage.clickOnTwoAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(2, cartPage.cartItems.size());
        cartPage.clickOnTwoRemoveButtons();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }

    @Test(priority = 90)
    public void userCanRemoveAllSixAddedProductsFromCartOnCartPage() {
        loginPage.logIn();
        homepagePage.clickOnAllSixAddToCartButtons();
        megaMenu.clickOnCartButton();
        Assert.assertEquals(6, cartPage.cartItems.size());
        cartPage.clickOnSixRemoveButtons();
        Assert.assertTrue(cartPage.cartItems.isEmpty());
    }
}
