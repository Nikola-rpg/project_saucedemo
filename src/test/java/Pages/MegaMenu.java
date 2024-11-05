package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MegaMenu extends BaseTest {
    public MegaMenu() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(css = "a[class='shopping_cart_link']")
    public WebElement cartButton;

    //--------------------------------

    public void clickOnMenuButton() {
        menuButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

}
