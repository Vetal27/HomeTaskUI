package testRozetkaUI;

import org.openqa.selenium.WebDriver;
import testRozetkaUI.pages.*;


public class PageFactory {
    WebDriver driver;
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage getHomePage()    { return new HomePage(driver); }
    public IPhonePage getIPhonePage() {
        return new IPhonePage(driver);
    }
    public CartPage getCartPage() {
        return new CartPage(driver);
    }
    public IPhone12ProMaxPage getIPhone12ProMaxPage() {
        return new IPhone12ProMaxPage(driver);
    }
    public RegistrationPage getRegistrationPage() {
        return new RegistrationPage(driver);
    }

}

