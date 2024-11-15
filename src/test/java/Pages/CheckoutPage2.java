package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage2 extends BaseTest {

    public CheckoutPage2() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartItems;

    @FindBy(id = "finish")
    public WebElement finishButton;

    //----------------------------

    public void clickOnFinishButton() {
        finishButton.click();
    }

}
