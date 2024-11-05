package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {
    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement InvenotoryHeaderTitle;

    @FindBy(css = "button[class*='btn_primary']")
    public List<WebElement> addToCartButton;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productName;

    @FindBy(xpath = "//div[@class='inventory_item_description']")
    public WebElement productDescription;

    @FindBy(css = ".inventory_item_img")
    public List<WebElement> productPicture;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public List<WebElement> removeButton;

    //---------------------------------

    public void clickOnAddToCartButton() {
        addToCartButton.get(0).click();
    }

    public void clickOnTwoAddToCartButtons() {
        for (int i = 0; i < 2; i++) {
            clickOnAddToCartButton();
        }
    }

    public void clickOnAllSixAddToCartButtons() {
        for (int i = 0; i < 6; i++) {
            clickOnAddToCartButton();
        }
    }

    public void clickOnProductName(int index) {
        productName.get(index).click();
    }

    public void clickOnRemoveButton() {
        removeButton.get(0).click();
    }

    public void clickOnTwoRemoveButtons() {
        for (int i = 0; i < 2; i++) {
            clickOnRemoveButton();
        }
    }

    public void clickOnAllSixRemoveButtons() {
        for (int i = 0; i < 6; i++) {
            clickOnRemoveButton();
        }
    }

    public void clickOnProductPicture(int index) {
        productPicture.get(index).click();
    }

}
