import api.BaseUrl;
import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPageBurger;
import pageobject.RegisterPageBurger;
//
public class LoginPageTest extends BaseUrl {
    private WebDriver driver = WebDriverCreator.createWebDriver();

    @Before
    public void goSetup(){
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @DisplayName("Try to login while click to button in the home page")
    @Test
    public void testLoginThroughHomePageButton() {

        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        loginPageBurger.loginThroughHomePageButton();

    }
    @DisplayName("Try to login while click to button in the header")
    @Test
    public void testLoginThroughHeaderButton() {
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        loginPageBurger.loginThroughHeaderButton();
    }

    @DisplayName("Try to login while click to link in the register form")
    @Test
    public void testLoginThroughLink() {
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        loginPageBurger.loginThroughLink();
    }
    @DisplayName("Try to login while click to link in the recovery form")
    @Test
    public void testLoginThroughRecoveryLink() {
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        loginPageBurger.loginThroughRecoveryLink();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
