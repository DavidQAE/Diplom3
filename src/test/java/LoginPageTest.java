import api.BaseUrl;
import api.Delete;
import api.UserCreation;
import driver.WebDriverCreator;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPageBurger;

import static org.junit.Assert.assertTrue;
import static testdata.UserData.*;

//
public class LoginPageTest extends BaseUrl {
    private WebDriver driver = WebDriverCreator.createWebDriver();
    LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
    Delete delete = new Delete();
    UserCreation userCreation = new UserCreation();

    @Before
    public void goSetup(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        userCreation.createUser(email, name, password);

    }

    @DisplayName("Try to login while click to button in the home page")
    @Test
    public void testLoginThroughHomePageButton() {

      loginHomePageButton();
      checkLoginHomePage();

    }

    @Step("Login through home page button")
    public void loginHomePageButton() {
        loginPageBurger.loginThroughHomePageButton();
    }

    @Step("Check login")
    public void checkLoginHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageBurger.getOrderButton()));
        assertTrue("Не удалось залогиниться", element.isDisplayed());
    }
    @DisplayName("Try to login while click to button in the header")
    @Test
    public void testLoginThroughHeaderButton() {

        loginHeaderButton();
        checkLoginHeader();

    }

    @Step("Login through header button")
    public void loginHeaderButton() {
        loginPageBurger.loginThroughHeaderButton();
    }

    @Step("Check login")
    public void checkLoginHeader() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageBurger.getOrderButton()));
        assertTrue("Не удалось залогиниться", element.isDisplayed());
    }

    @DisplayName("Try to login while click to link in the register form")
    @Test
    public void testLoginThroughLink() {

        loginThroughLink();
        checkLoginThroughLink();

    }

    @Step("Login through link")
    public void loginThroughLink() {
        loginPageBurger.loginThroughLink();
    }

    @Step("Check login")
    public void checkLoginThroughLink() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageBurger.getOrderButton()));
        assertTrue("Не удалось залогиниться", element.isDisplayed());
    }
    @DisplayName("Try to login while click to link in the recovery form")
    @Test
    public void testLoginThroughRecoveryLink() {

        loginThroughRecoveryLink();
        checkLoginThroughRecoveryLink();

    }

    @Step("Login through recovery link")
    public void loginThroughRecoveryLink() {
        loginPageBurger.loginThroughRecoveryLink();
    }

    @Step("Check login")
    public void checkLoginThroughRecoveryLink() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageBurger.getOrderButton()));
        assertTrue("Не удалось залогиниться", element.isDisplayed());
    }


    @After
    public void tearDown() {
        delete.deleteUser(email, password);
        driver.quit();
    }
}
