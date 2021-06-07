package testRozetkaUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IPhone12ProMaxPage extends BasePage {
private static final By PRODUCT_NAME = By.xpath("//h1[contains (@text(), 'Apple iPhone 12 Pro Max 256 GB']");
private static final By BUY_BUTTON = By.xpath("//button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']");
    public IPhone12ProMaxPage(WebDriver driver) {
        super(driver);
    }
public String getProductName(){ return driver.findElement(PRODUCT_NAME).getText(); }
public void clickOnBuyButton(){
        driver.findElement(BUY_BUTTON).click();
}

}
