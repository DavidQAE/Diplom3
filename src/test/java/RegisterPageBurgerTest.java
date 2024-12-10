import api.BaseUrl;
import api.Delete;
import driver.WebDriverCreator;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.RegisterPageBurger;

import static org.junit.Assert.assertTrue;
import static testdata.UserData.*;
//
public class RegisterPageBurgerTest extends BaseUrl {
    private WebDriver driver = WebDriverCreator.createWebDriver();
    RegisterPageBurger registerPageBurger = new RegisterPageBurger(driver);
    Delete delete = new Delete();

    @Before
    public void goSetup(){
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @DisplayName("Try to register and check")
    @Test
    public void testSuccessRegister() {
        normalRegister();
        checkNormalRegister();

    }

    @Step("Register with normal data")
    public void normalRegister() {
        registerPageBurger.successRegister();
    }

    @Step("Check registration and delete user")
    public void checkNormalRegister() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(registerPageBurger.getLoginButton()));
        assertTrue("Элемент не отобразился", element.isDisplayed());

        delete.deleteUser(email, password);
    }

    @DisplayName("Try to register with wrong password and check")
    @Test
    public void testBadRegister() {
        wrongRegister();
        checkWrongRegister();

    }

    @Step("Register with normal data")
    public void wrongRegister() {
        registerPageBurger.badRegister();
    }

    @Step("Check registration")
    public void checkWrongRegister() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(registerPageBurger.getWrongPasswordMessage()));
        assertTrue("Элемент не отобразился", element.isDisplayed());
    }

   @After
    public void tearDown() {
        driver.quit();
   }




}