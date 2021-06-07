package testRozetkaUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private static final By CART_PAGE = By.xpath("//h3[text()=' Кошик ']");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean cartPageVisible(){
        return driver.findElement(CART_PAGE).isDisplayed();
    }
}
