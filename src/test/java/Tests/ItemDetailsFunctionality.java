package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemDetailsFunctionality extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void userCanViewDetailsOfOneProductByClickingOnProductNameTitle() {
        loginPage.logIn();
        for (int i = 0; i < 6; i++) {
            String expectedProductName = homepagePage.productName.get(i).getText();
            homepagePage.clickOnProductName(i);
            Assert.assertTrue(itemPage.productName.isDisplayed());
            Assert.assertTrue(itemPage.productDescription.isDisplayed());
            Assert.assertEquals(itemPage.productName.getText(), expectedProductName);
            itemPage.clickOnBackToProductsLink();
        }
    }

    @Test(priority = 20)
    public void userCanViewDetailsOfOneProductByClickingOnProductPicture() {
        loginPage.logIn();
        int j = 0;
        for (int i = 0; i < 6; i++) {
            String expectedProductName = homepagePage.productName.get(i).getText();
            homepagePage.clickOnProductPicture(j);
            Assert.assertTrue(itemPage.productName.isDisplayed());
            Assert.assertTrue(itemPage.productDescription.isDisplayed());
            Assert.assertEquals(itemPage.productName.getText(), expectedProductName);
            itemPage.clickOnBackToProductsLink();
            j += 2;
        }
    }
}
