package testRozetkaUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private static final By LOGIN_BUTTON = By.xpath("//button[@class='header__button ng-star-inserted']");

    private static final By NAME_FIELD = By.xpath("//input[@id='registerUserName']");
    private static final By SURNAME_FIELD = By.xpath("//input[@id='registerUserSurname']");
    private static final By PHONE_NUMBER_FIELD = By.xpath("//input[@id='registerUserPhone']");
    private static final By PASSWORD_FIELD = By.xpath("//input[id='registerUserPassword']");
    private static final By ENTER_EMAIL_MESSAGE = By.xpath("//p[@class='validation-message ng-star-inserted'][text()=' Введіть свою ел. пошту ']");
    private static final By REGISTRATION_BUTTON = By.xpath("//button[text()=' Зареєструватися ']");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogInButton(){ driver.findElement(LOGIN_BUTTON).click(); }
    public void enterName(final String name){
        driver.findElement(NAME_FIELD).sendKeys(name);
}
    public void clickOnNameField(){
        driver.findElement(NAME_FIELD).click();
}
    public void enterSurname(final String surname){
        driver.findElement(SURNAME_FIELD).sendKeys(surname);
}
    public void clickOnSurnameField(){
        driver.findElement(SURNAME_FIELD).click();
}
    public void enterPhoneNumber(final String phoneNumber){ driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber); }
    public void clickOnPhoneNumberField(){ driver.findElement(PHONE_NUMBER_FIELD).click();}
    public void enterPassword(final String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
}
    public void clickOnPasswordField(){
        driver.findElement(PASSWORD_FIELD).click();
}
    public void clickOnRegistrationButton(){
        driver.findElement(REGISTRATION_BUTTON).click();
}
    public boolean mailErrorMessage(){ return driver.findElement(ENTER_EMAIL_MESSAGE).isDisplayed(); }

}
