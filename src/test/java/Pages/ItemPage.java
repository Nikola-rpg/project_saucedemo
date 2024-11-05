package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BaseTest {
    public ItemPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[class*='btn_primary']")
    public WebElement addToCartButton;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsLink;

    @FindBy(className = "inventory_details_name")
    public WebElement productName;

    @FindBy(className = "inventory_details_desc")
    public WebElement productDescription;

    @FindBy(id = "remove")
    public WebElement removeButton;


    //-------------------------------------------

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnBackToProductsLink() {
        backToProductsLink.click();
    }

    public void clickOnRemoveButton() {
        removeButton.click();
    }

}
