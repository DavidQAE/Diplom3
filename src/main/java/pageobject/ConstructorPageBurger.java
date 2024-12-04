package pageobject;
//
import api.Delete;
import api.UserCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ConstructorPageBurger {
    private WebDriver driver;
    Delete delete = new Delete();
    UserCreation userCreation = new UserCreation();

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





    public ConstructorPageBurger(WebDriver driver) {
        this.driver = driver;
    }


    public void cabinetTransition() {

        userCreation.createUser();

        clickElement(headerLoginButton);

        input(loginEmailField, "TestDave5@mail.ru");
        input(loginPasswordField, "Tester1234323");
        clickElement(loginButton);

        clickElement(headerLoginButton);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cabinetText));
        assertTrue("Переход не удался", element.isDisplayed());

        delete.deleteUser();
    }

    public void constructorTransition() {

        userCreation.createUser();

        clickElement(headerLoginButton);

        input(loginEmailField, "TestDave5@mail.ru");
        input(loginPasswordField, "Tester1234323");
        clickElement(loginButton);

        clickElement(headerLoginButton);
        clickElement(constructorHeaderButton);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        assertTrue("Переход не удался", element.isDisplayed());

        delete.deleteUser();
    }

    public void logoTransition() {

        userCreation.createUser();

        clickElement(headerLoginButton);

        input(loginEmailField, "TestDave5@mail.ru");
        input(loginPasswordField, "Tester1234323");
        clickElement(loginButton);

        clickElement(headerLoginButton);
        clickElement(burgerLogo);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        assertTrue("Переход не удался", element.isDisplayed());

        delete.deleteUser();
    }

    public void cabinetExitButtonClick() {

        userCreation.createUser();

        clickElement(headerLoginButton);

        input(loginEmailField, "TestDave5@mail.ru");
        input(loginPasswordField, "Tester1234323");
        clickElement(loginButton);

        clickElement(headerLoginButton);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cabinetText));
        clickElement(exitButton);

        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        WebElement element = wait2.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        assertTrue("Кнопка выход не работает", element.isDisplayed());

        delete.deleteUser();
    }

    public void sauceTransition() {

        clickElement(constructorSauceSection);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(allSauces));
        assertTrue("Переход не удался", element.isDisplayed());



    }

    public void bunTransition() {

        clickElement(constructorSauceSection);
        clickElement(constructorBunSection);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(allBuns));
        assertTrue("Переход не удался", element.isDisplayed());



    }

    public void fillingsTransition() {

        clickElement(constructorFillingSection);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(allFillings));
        assertTrue("Переход не удался", element.isDisplayed());


    }

}
