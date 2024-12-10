package pageobject;
//
import api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static testdata.UserData.*;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegisterPageBurger extends BaseUrl {

    private  WebDriver driver;



    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void input(By locator, String text){
        driver.findElement(locator).sendKeys(text);

    }

    private By constructorLoginButton = By.xpath(".//button[contains(text(), 'Войти в аккаунт')] ");

    private By loginButton = By.xpath(".//button[contains(text(), 'Войти')]");

    private By loginPageRegisterLink = By.xpath(".//a[contains(text(), 'Зарегистрироваться')]");

    private By registerNameField = By.xpath(".//div[@class='Auth_login__3hAey']//form//fieldset[1]//input");

    private By registerEmailField = By.xpath(".//div[@class='Auth_login__3hAey']//form//fieldset[2]//input");

    private By registerPasswordField = By.xpath(".//div[@class='Auth_login__3hAey']//form//fieldset[3]//input");

    private By registerButton = By.xpath(".//button[contains(text(), 'Зарегистрироваться')]");

    private By wrongPasswordMessage = By.xpath("//p[contains(text(), 'Некорректный пароль')]");




    public RegisterPageBurger(WebDriver driver) {
        this.driver = driver;
    }


   public void successRegister() {

    clickElement(constructorLoginButton);

    clickElement(loginPageRegisterLink);

    input(registerNameField, name);
    input(registerEmailField, email);
    input(registerPasswordField, password);
    clickElement(registerButton);



   }


   public void badRegister() {

       clickElement(constructorLoginButton);

       clickElement(loginPageRegisterLink);

       input(registerNameField, name);
       input(registerEmailField, email);
       input(registerPasswordField, wrongPassword);
       clickElement(registerButton);

   }




















    public By getLoginButton() {
        return loginButton;
    }

    public By getWrongPasswordMessage() {
        return wrongPasswordMessage;
    }

}
