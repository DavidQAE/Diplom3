import api.BaseUrl;
import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.RegisterPageBurger;
//
public class RegisterPageBurgerTest extends BaseUrl {
    private WebDriver driver = WebDriverCreator.createWebDriver();

    @Before
    public void goSetup(){
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @DisplayName("Try to register and check")
    @Test
    public void testSuccessRegister() {
        RegisterPageBurger registerPageBurger = new RegisterPageBurger(driver);
        registerPageBurger.successRegister();
    }
    @DisplayName("Try to register with wrong password and check")
    @Test
    public void testBadRegister() {
        RegisterPageBurger registerPageBurger = new RegisterPageBurger(driver);
        registerPageBurger.badRegister();

    }

   @After
    public void tearDown() {
        driver.quit();
   }




}