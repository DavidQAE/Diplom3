import api.BaseUrl;
import api.Delete;
import api.UserCreation;
import driver.WebDriverCreator;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.ConstructorPageBurger;
import pageobject.RegisterPageBurger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static testdata.UserData.*;
//

public class TransitionsTests extends BaseUrl{
    private WebDriver driver = WebDriverCreator.createWebDriver();
    UserCreation userCreation = new UserCreation();
    Delete delete = new Delete();
    ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);


    @Before
    public void goSetup(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        userCreation.createUser(email, name, password);

    }
    @DisplayName("Click to cabinet and check transition")
    @Test
    public void toCabinetTransition() {
        goToCabinet();
        checkCabinetTransition();
    }

    @Step("Click to cabinet")
    public void goToCabinet() {
        constructorPageBurger.cabinetTransition();
    }

    @Step("Check transition")
    public void checkCabinetTransition() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPageBurger.getCabinetText()));
        assertTrue("Переход не удался", element.isDisplayed());
    }


    @DisplayName("Click to constructor from cabinet and check transition")
    @Test
    public void toConstructorTransition() {

        goToConstructor();
        checkConstructorTransition();

    }

    @Step("Click to constructor")
    public void goToConstructor() {
        constructorPageBurger.constructorTransition();
    }

    @Step("Check transition")
    public void checkConstructorTransition() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPageBurger.getOrderButton()));
        assertTrue("Переход не удался", element.isDisplayed());
    }


    @DisplayName("Click to logo from cabinet and check transition")
    @Test
    public void toLogoTransition() {

        goToLogo();
        checkLogoTransition();

    }

    @Step("Click to logo")
    public void goToLogo() {
        constructorPageBurger.logoTransition();
    }

    @Step("Check transition")
    public void checkLogoTransition() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPageBurger.getOrderButton()));
        assertTrue("Переход не удался", element.isDisplayed());
    }

    @DisplayName("Click to exit button in cabinet and check")
    @Test
    public void exitButtonTest() {

        goToCabinetAndClickButton();
        checkExitButton();

    }

    @Step("Click to cabinet and exit button")
    public void goToCabinetAndClickButton() {
        constructorPageBurger.cabinetExitButtonClick();
    }

    @Step("Check button")
    public void checkExitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPageBurger.getLoginButton()));
        assertTrue("Переход не удался", element.isDisplayed());
    }
    @DisplayName("Click to sauce section in the constructor and check the transition")
    @Test
    public void sauceTransitionTest() {
        WebElement targetElement = driver.findElement(constructorPageBurger.getSauceImage());
        Point initialLocation = targetElement.getLocation();
        int initialYPosition = initialLocation.y;

        //Клик на элемент(раздел соусы)
        constructorPageBurger.sauceTransition();

        Point updatedLocation = targetElement.getLocation();
        int updatedYPosition = updatedLocation.y;

        assertNotEquals(initialYPosition, updatedYPosition);

    }
    @DisplayName("Click to bun section in the constructor and check the transition")
    @Test
    public void bunTransitionTest() {
        WebElement targetElement = driver.findElement(constructorPageBurger.getBunImage());
        Point initialLocation = targetElement.getLocation();
        int initialYPosition = initialLocation.y;

        constructorPageBurger.bunTransition();

        Point updatedLocation = targetElement.getLocation();
        int updatedYPosition = updatedLocation.y;

        assertNotEquals(initialYPosition, updatedYPosition);

    }
    @DisplayName("Click to filling section in the constructor and check the transition")
    @Test
    public void fillingTransitionTest() {
        WebElement targetElement = driver.findElement(constructorPageBurger.getFillingImage());
        Point initialLocation = targetElement.getLocation();
        int initialYPosition = initialLocation.y;

        constructorPageBurger.fillingsTransition();

        Point updatedLocation = targetElement.getLocation();
        int updatedYPosition = updatedLocation.y;

        assertNotEquals(initialYPosition, updatedYPosition);
    }


    @After
    public void tearDown() {
        delete.deleteUser(email, password);
        driver.quit();
    }
}

