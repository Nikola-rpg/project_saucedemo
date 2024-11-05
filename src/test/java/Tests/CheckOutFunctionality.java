package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutFunctionality extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void userCanCompleteCheckOutAndFinishPurchaseOfOneProduct() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputFirstName("Petar");
        checkoutPage1.inputLastName("Petrovic");
        checkoutPage1.inputPostalCode("11000");
        checkoutPage1.clickOnContinueButton();
        Assert.assertTrue(checkoutPage2.cartItems.get(0).isDisplayed());
        Assert.assertEquals(checkoutPage2.cartItems.get(0).getText(), homepagePage.productName.get(0).getText());
        checkoutPage2.clickOnFinishButton();
        Assert.assertTrue(checkoutPage3.thankYouMessage.isDisplayed());
        Assert.assertEquals(checkoutPage3.thankYouMessage.getText(), "Thank you for your order!");
        Assert.assertTrue(checkoutPage3.completionMessage.isDisplayed());
        Assert.assertTrue(checkoutPage3.completionMessage.getText().contains("Your order has been dispatched"));
        Assert.assertTrue(checkoutPage3.backHomeButton.isDisplayed());
    }

    @Test(priority = 20)
    public void userCanCompleteCheckOutAndFinishPurchaseOfTwoProducts() {
        loginPage.logIn();
        homepagePage.clickOnTwoAddToCartButtons();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputFirstName("Petar");
        checkoutPage1.inputLastName("Petrovic");
        checkoutPage1.inputPostalCode("11000");
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(2, checkoutPage2.cartItems.size());
        for (int i = 0; i < checkoutPage2.cartItems.size(); i++) {
            Assert.assertTrue(checkoutPage2.cartItems.get(i).isDisplayed());
            Assert.assertEquals(checkoutPage2.cartItems.get(i).getText(), homepagePage.productName.get(i).getText());
        }
        checkoutPage2.clickOnFinishButton();
        Assert.assertTrue(checkoutPage3.thankYouMessage.isDisplayed());
        Assert.assertEquals(checkoutPage3.thankYouMessage.getText(), "Thank you for your order!");
        Assert.assertTrue(checkoutPage3.completionMessage.isDisplayed());
        Assert.assertTrue(checkoutPage3.completionMessage.getText().contains("Your order has been dispatched"));
        Assert.assertTrue(checkoutPage3.backHomeButton.isDisplayed());
    }

    @Test(priority = 30)
    public void userCanCompleteCheckOutAndFinishPurchaseOfAllSixProducts() {
        loginPage.logIn();
        homepagePage.clickOnAllSixAddToCartButtons();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputFirstName("Petar");
        checkoutPage1.inputLastName("Petrovic");
        checkoutPage1.inputPostalCode("11000");
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(6, checkoutPage2.cartItems.size());
        for (int i = 0; i < checkoutPage2.cartItems.size(); i++) {
            Assert.assertTrue(checkoutPage2.cartItems.get(i).isDisplayed());
            Assert.assertEquals(checkoutPage2.cartItems.get(i).getText(), homepagePage.productName.get(i).getText());
        }
        checkoutPage2.clickOnFinishButton();
        Assert.assertTrue(checkoutPage3.thankYouMessage.isDisplayed());
        Assert.assertEquals(checkoutPage3.thankYouMessage.getText(), "Thank you for your order!");
        Assert.assertTrue(checkoutPage3.completionMessage.isDisplayed());
        Assert.assertTrue(checkoutPage3.completionMessage.getText().contains("Your order has been dispatched"));
        Assert.assertTrue(checkoutPage3.backHomeButton.isDisplayed());
    }

    @Test(priority = 40)
    public void userCannotCompleteTheCheckOutProcessWithAnEmptyFirstNameField() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputLastName("Petrovic");
        checkoutPage1.inputPostalCode("11000");
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("First Name is required"));
    }

    @Test(priority = 50)
    public void userCannotCompleteTheCheckOutProcessWithAnEmptyLastNameField() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputFirstName("Petar");
        checkoutPage1.inputPostalCode("11000");
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("Last Name is required"));
    }

    @Test(priority = 60)
    public void userCannotCompleteTheCheckOutProcessWithAnEmptyPostalCodeField() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputFirstName("Petar");
        checkoutPage1.inputLastName("Petrovic");
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("Postal Code is required"));
    }

    @Test(priority = 70)
    public void userCannotCompleteTheCheckOutProcessWithEmptyFirstNameAndLastNameFields() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputPostalCode("11000");
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("First Name is required"));
    }

    @Test(priority = 80)
    public void userCannotCompleteTheCheckOutProcessWithEmptyFirstNameAndPostalCodeFields() {
        loginPage.logIn();
        if (homepagePage.removeButton.get(0).isDisplayed()) {
            megaMenu.clickOnCartButton();
        } else {
            homepagePage.clickOnAddToCartButton();
        }
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputLastName("Petrovic");
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("First Name is required"));
    }

    @Test(priority = 90)
    public void userCannotCompleteTheCheckOutProcessWithEmptyLastNameAndPostalCodeFields() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        checkoutPage1.inputFirstName("Petar");
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("Last Name is required"));
    }

    @Test(priority = 100)
    public void userCannotCompleteTheCheckOutProcessWithEmptyFirstNameLastNameAndPostalCodeFields() {
        loginPage.logIn();
        homepagePage.clickOnAddToCartButton();
        megaMenu.clickOnCartButton();
        cartPage.clickOnCheckOutButton();
        String checkoutPage1Link = driver.getCurrentUrl();
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage1Link);
        Assert.assertTrue(checkoutPage1.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutPage1.errorMessage.getText().contains("First Name is required"));
    }

}
