package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage3 extends BaseTest {
    public CheckoutPage3() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    public WebElement thankYouMessage;

    @FindBy(className = "complete-text")
    public WebElement completionMessage;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    //-----------------------------

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }
}
