package testRozetkaUI;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import testRozetkaUI.pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class MyStepdefenitions {
    private static final long DEFAULT_TIMEOUT = 30;
    private static final By BUY_BUTTON = By.xpath("//button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']");
    WebDriver driver;
    private HomePage homePage;
    private IPhonePage IPhonePage;
    private CartPage cartPage;
    private IPhone12ProMaxPage iPhone12ProMaxPage;
    private RegistrationPage registrationPage;
    public PageFactory pageFactory;

    @Before
    public void profileSetUp() {
        chromedriver().setup();
    }

    @Given("User opens {string} page")
        public void userWriteSearchWordAndClickEnerButton(final String URL) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactory = new PageFactory(driver);
        driver.get(URL);
    }

    @When("User clicks on 'Search Field'")
    public void userClicksOnSearchField() {
        homePage = pageFactory.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnSearchField();
    }

    @And("User write {string} and click Enter button")
    public void userWriteSearchWordAndClickEnterButton(final String word) {
        homePage.searchByKeyword(word);

    }

    @And("User choose 'Apple' products")
    public void userChooseAppleProducts() {
        IPhonePage = pageFactory.getIPhonePage();
        homePage.implicitWait(DEFAULT_TIMEOUT);
        IPhonePage.clickOnAppleProductsButton();
        homePage.implicitWait(DEFAULT_TIMEOUT);
    }

    @And("User click on first product")
    public void userClickOnFirstProduct() {
        IPhonePage.clickOnFirstProduct();

    }

    @And("user check that product name contains {string}")
    public void userCheckThatSearchWordContainsProductName(final String prodName) {
        iPhone12ProMaxPage = pageFactory.getIPhone12ProMaxPage();
        homePage.implicitWait(DEFAULT_TIMEOUT);
        assertTrue(iPhone12ProMaxPage.getProductName().contains(prodName));
    }

    @And("user click buy button")
    public void userClickBuyButton() {
        WebElement myElement = driver.findElement(BUY_BUTTON);
        Actions builder = new Actions(driver);
        builder.moveToElement(myElement).build().perform();
        iPhone12ProMaxPage.clickOnBuyButton();
    }

    @Then("User see cart window")
    public void userSeeCartWindow() {
        cartPage = pageFactory.getCartPage();
        homePage.implicitWait(DEFAULT_TIMEOUT);
        assertTrue(cartPage.cartPageVisible());
    }
    @When("User clicks on 'Log In' button")
    public void userClicksOnLogInButton() {
        homePage.clickOnSignInButton();
        homePage.implicitWait(DEFAULT_TIMEOUT);
    }

    @And("User click 'Registration' button")
    public void userClickRegistrationButton() {
        registrationPage = pageFactory.getRegistrationPage();
        registrationPage.clickOnLogInButton();
    }

    @And("User clicks on 'Name' field")
    public void userClicksOnNameField() {
        registrationPage = pageFactory.getRegistrationPage();
        registrationPage.clickOnNameField();
    }

    @And("User enter name {string}")
    public void userEnterName(final String word) {
        homePage.implicitWait(DEFAULT_TIMEOUT);
        registrationPage.enterName(word);
    }


    @And("User clicks on 'Surname' field")
    public void userClicksOnSurnameField() {
        registrationPage.clickOnSurnameField();
    }

    @And("User enter surname {string}")
    public void userWriteWord(final String surname) {
        registrationPage.enterSurname(surname);
    }


    @And("User click on 'Phone Number' field")
    public void userClickOnPhoneNumberField() {
        registrationPage.clickOnPhoneNumberField();
    }

    @And("User enter phone number {string}")
    public void userWrPhoneNumber(final String phoneNumber) {
        registrationPage.enterPhoneNumber(phoneNumber);
    }

    @And("User clicks on 'Password' field'")
    public void userClicksOnPasswordField() {
        registrationPage.clickOnPasswordField();
    }

    @And("User enter password {string}")
    public void userWriPassword(final String password) {
        registrationPage.enterPassword(password);
    }

    @And("user click on 'registration' button")
    public void userClickOnRegistrationButton() {
        registrationPage.clickOnRegistrationButton();
    }

    @Then("User see 'Write e-mail' message")
    public void userSeeWriteEMailMessage() {
        assertTrue(registrationPage.mailErrorMessage());
    }

    @And("User Write {string}")
    public void userWriteSearchWord(final String word) {
        homePage.clickOnSearchField();
        homePage.writeWordInSearchField(word);
    }

    @Then("User see 'Message'")
    public void userSeeMessage() {
        homePage.implicitWait(DEFAULT_TIMEOUT);
        assertTrue(homePage.noResult());

    }

    @And("User click 'Sort Button'")
    public void userClickSortButton() {
        IPhonePage.clickOnSortButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User click 'From Cheap to Expensive' button")
    public void userClickFromCheapToExpensiveButton() throws InterruptedException {
        IPhonePage.clickOnCheapButton();
        IPhonePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User check that first product cheaper than last")
    public void userCheckThatFirstProductCheaperThanLast() {
        List<WebElement> list = IPhonePage.getProductPriceList();
        for (int i = 1; i < list.size(); i++) {
            String first_string = list.get(i).getText().replaceAll(" ", "");
            String second_string = list.get(i -1).getText().replaceAll(" ", "");
            int first_value = Integer.parseInt(first_string);
            int second_value = Integer.parseInt(second_string);
            assertTrue(second_value <= first_value);
        }
    }

    @And("User click 'From Expensive to Cheap' button")
    public void userClickFromExpensiveToCheapButton() throws InterruptedException {

        IPhonePage.clickOnExpensiveButton();
        IPhonePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User check that first product more expensive than last")
    public void userCheckThatFirstProductMoreExpensiveThanLast() {
        List<WebElement> list = IPhonePage.getProductPriceList();
        for (int i = 2; i < list.size(); i++) {
            String first_string = list.get(i).getText().replaceAll(" ", "");
            String second_string = list.get(i - 1).getText().replaceAll(" ", "");
            int first_value = Integer.parseInt(first_string);
            int second_value = Integer.parseInt(second_string);
            assertTrue(first_value <= second_value);
        }
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
