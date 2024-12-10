package pageobject;
//
import api.Delete;
import api.UserCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static testdata.UserData.email;
import static testdata.UserData.password;
import static testdata.UserData.name;

public class ConstructorPageBurger {
    private WebDriver driver;

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void input(By locator, String text){
        driver.findElement(locator).sendKeys(text);

    }
    private By headerLoginButton = By.xpath(".//p[contains(text(), 'Личный Кабинет')]");

    private By cabinetText = By.xpath(".//p[contains(text(), 'В этом разделе вы можете изменить свои персональные данные')]");

    private By burgerLogo = By.className("AppHeader_header__logo__2D0X2");

    private By constructorHeaderButton = By.xpath(".//p[contains(text(), 'Конструктор')]");

    private By exitButton = By.xpath("//button[contains(text(), 'Выход')]");

    private By loginButton = By.xpath(".//button[contains(text(), 'Войти')]");

    private By orderButton = By.xpath("//button[contains(text(), 'Оформить заказ')]");

    private By constructorSauceSection = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[1]//div[2]");

    private By constructorBunSection = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[1]//div[1]");

    private By constructorFillingSection = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[1]//div[3]");

    private By allBuns = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[2]//ul[1]");

    private By allSauces = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[2]//ul[2]");

    private By allFillings = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[2]//ul[3]");

    private By loginEmailField = By.name("name");

    private By loginPasswordField = By.name("Пароль");

    private By sauceImage = By.xpath(".//img[@alt='Соус Spicy-X']");

    private By bunImage = By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']");

    private By fillingImage = By.xpath(".//img[@alt='Сыр с астероидной плесенью']");





    public ConstructorPageBurger(WebDriver driver) {
        this.driver = driver;
    }


    public void cabinetTransition() {

        clickElement(headerLoginButton);

        input(loginEmailField, email);
        input(loginPasswordField, password);
        clickElement(loginButton);

        clickElement(headerLoginButton);


    }

    public void constructorTransition() {



        clickElement(headerLoginButton);

        input(loginEmailField, email);
        input(loginPasswordField, password);
        clickElement(loginButton);

        clickElement(headerLoginButton);
        clickElement(constructorHeaderButton);



    }

    public void logoTransition() {



        clickElement(headerLoginButton);

        input(loginEmailField, email);
        input(loginPasswordField, password);
        clickElement(loginButton);

        clickElement(headerLoginButton);
        clickElement(burgerLogo);



    }

    public void cabinetExitButtonClick() {



        clickElement(headerLoginButton);

        input(loginEmailField, email);
        input(loginPasswordField, password);
        clickElement(loginButton);

        clickElement(headerLoginButton);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cabinetText));
        clickElement(exitButton);



    }

    public void sauceTransition() {

        clickElement(constructorSauceSection);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(allSauces));

    }

    public void bunTransition() {

        clickElement(constructorSauceSection);
        clickElement(constructorBunSection);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(allBuns));




    }

    public void fillingsTransition() {

        clickElement(constructorFillingSection);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(allFillings));
        assertTrue("Переход не удался", element.isDisplayed());


    }

    public By getFillingImage() {
        return fillingImage;
    }


    public By getBunImage() {
        return bunImage;
    }


    public By getSauceImage() {
        return sauceImage;
    }


    public By getLoginButton() {
        return loginButton;
    }


    public By getAllSauces() {
        return allSauces;
    }


    public By getCabinetText() {
        return cabinetText;
    }

    public By getOrderButton() {
        return orderButton;
    }
}







