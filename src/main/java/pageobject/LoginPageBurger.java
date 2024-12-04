package pageobject;
//
import api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginPageBurger {

    private  WebDriver driver;
    Delete delete = new Delete();
UserCreation userCreation = new UserCreation();

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void input(By locator, String text){
        driver.findElement(locator).sendKeys(text);

    }

    private By constructorLoginButton = By.xpath(".//button[contains(text(), 'Войти в аккаунт')] ");

    private By loginEmailField = By.name("name");

    private By loginPasswordField = By.name("Пароль");

    private By loginButton = By.xpath(".//button[contains(text(), 'Войти')]");

    private By loginPasswordRecoverLink = By.xpath(".//a[contains(text(), 'Восстановить пароль')]");

    private By loginPageRegisterLink = By.xpath(".//a[contains(text(), 'Зарегистрироваться')]");

    private By headerLoginButton = By.xpath(".//p[contains(text(), 'Личный Кабинет')]");

    private By registerPageloginLink = By.xpath(".//a[contains(text(), 'Войти')]");

    private By recoverEmailField = By.xpath(".//label[contains(text(), 'Email')]");

    private By recoveryButton = By.xpath(".//button[contains(text(), 'Восстановить')]");

    private By recoveryPageloginLink = By.xpath(".//a[contains(text(), 'Войти')]");




    public LoginPageBurger(WebDriver driver) {
        this.driver = driver;
    }



   public void loginThroughHomePageButton() {

       userCreation.createUser();

       clickElement(constructorLoginButton);

       input(loginEmailField, "TestDave5@mail.ru");
       input(loginPasswordField, "Tester1234323");
       clickElement(loginButton);

       WebDriverWait wait = new WebDriverWait(driver, 5);
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оформить заказ')]")));
       assertTrue("Не удалось залогиниться", element.isDisplayed());

       delete.deleteUser();

   }


   public void loginThroughHeaderButton() {
        userCreation.createUser();

        clickElement(headerLoginButton);

       input(loginEmailField, "TestDave5@mail.ru");
       input(loginPasswordField, "Tester1234323");
       clickElement(loginButton);

       WebDriverWait wait = new WebDriverWait(driver, 5);
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оформить заказ')]")));
       assertTrue("Не удалось залогиниться", element.isDisplayed());

       delete.deleteUser();
   }


    public void loginThroughLink() {
        userCreation.createUser();

        clickElement(constructorLoginButton);
        clickElement(loginPageRegisterLink);
        clickElement(registerPageloginLink);

        input(loginEmailField, "TestDave5@mail.ru");
        input(loginPasswordField, "Tester1234323");
        clickElement(loginButton);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оформить заказ')]")));
        assertTrue("Не удалось залогиниться", element.isDisplayed());

        delete.deleteUser();
    }

    public void loginThroughRecoveryLink() {
        userCreation.createUser();

        clickElement(constructorLoginButton);
        clickElement(loginPasswordRecoverLink);
        clickElement(recoveryPageloginLink);

        input(loginEmailField, "TestDave5@mail.ru");
        input(loginPasswordField, "Tester1234323");
        clickElement(loginButton);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оформить заказ')]")));
        assertTrue("Не удалось залогиниться", element.isDisplayed());

        delete.deleteUser();
    }

}
