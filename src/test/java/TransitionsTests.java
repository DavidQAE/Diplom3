import api.BaseUrl;
import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ConstructorPageBurger;
import pageobject.RegisterPageBurger;
//

public class TransitionsTests extends BaseUrl{
    private WebDriver driver = WebDriverCreator.createWebDriver();

    @Before
    public void goSetup(){
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @DisplayName("Click to cabinet and check transition")
    @Test
    public void toCabinetTransition() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.cabinetTransition();

    }
    @DisplayName("Click to constructor from cabinet and check transition")
    @Test
    public void toConstructorTransition() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.constructorTransition();

    }
    @DisplayName("Click to logo from cabinet and check transition")
    @Test
    public void toLogoTransition() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.logoTransition();

    }
    @DisplayName("Click to exit button in cabinet and check")
    @Test
    public void exitButtonTest() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.cabinetExitButtonClick();

    }
    @DisplayName("Click to sauce section in the constructor and check the transition")
    @Test
    public void sauceTransitionTest() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.sauceTransition();

    }
    @DisplayName("Click to bun section in the constructor and check the transition")
    @Test
    public void bunTransitionTest() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.bunTransition();

    }
    @DisplayName("Click to filling section in the constructor and check the transition")
    @Test
    public void fillingTransitionTest() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        constructorPageBurger.fillingsTransition();

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

