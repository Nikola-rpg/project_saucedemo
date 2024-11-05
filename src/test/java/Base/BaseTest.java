package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public MegaMenu megaMenu;
    public LoginPage loginPage;
    public HomepagePage homepagePage;
    public CartPage cartPage;
    public ItemPage itemPage;
    public CheckoutPage1 checkoutPage1;
    public CheckoutPage2 checkoutPage2;
    public CheckoutPage3 checkoutPage3;

    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        excelReader = new ExcelReader("TestData.xlsx");

        megaMenu = new MegaMenu();
        loginPage = new LoginPage();
        homepagePage = new HomepagePage();
        cartPage = new CartPage();
        itemPage = new ItemPage();
        checkoutPage1 = new CheckoutPage1();
        checkoutPage2 = new CheckoutPage2();
        checkoutPage3 = new CheckoutPage3();
    }
}
