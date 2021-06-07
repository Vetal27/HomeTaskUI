package testRozetkaUI.pages;

import org.openqa.selenium.*;

public class HomePage extends BasePage {
    private static final By SEARCH_FIELD = By.xpath("//input[@name='search']");
    private static final By SIGN_IN_BUTTON = By.xpath("//li[@class='header-actions__item header-actions__item--user']//button[@class='header__button ng-star-inserted']");
    private static final By NO_RESULT_POPUP = By.xpath("//p[@class='search-suggest__item search-suggest__item-content search-suggest__item-content_type_no-results search-suggest__item-text ng-star-inserted']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSearchField() {
        driver.findElement(SEARCH_FIELD).click();
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(SEARCH_FIELD).sendKeys(keyword, Keys.ENTER);
    }
    public void writeWordInSearchField(final String keyword){
        driver.findElement(SEARCH_FIELD).sendKeys(keyword);
    }

    public void clickOnSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public boolean noResult() {
        return driver.findElement(NO_RESULT_POPUP).isDisplayed();
    }


}
