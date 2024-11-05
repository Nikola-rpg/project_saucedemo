package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartItemName;

    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    public WebElement continueShopingButton;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    //----------------------------------------------

    public void clickOnContinueShopingButton() {
        continueShopingButton.click();
    }

    public void clickOnRemoveButton() {
        removeButton.click();
    }

    public void clickOnTwoRemoveButtons() {
        for (int i = 0; i < 2; i++) {
            removeButton.click();
        }
    }

    public void clickOnSixRemoveButtons() {
        for (int i = 0; i < 6; i++) {
            removeButton.click();
        }
    }

    public void clickOnCheckOutButton() {
        checkoutButton.click();
    }


}
