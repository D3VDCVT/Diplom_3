package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    //h2 Вход
    private final By loginTitle = By.xpath(".//h2[text()='Вход']");
    // поле Email
    private final By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");

    // поле Пароль
    private final By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");

    //кнопка Войти
    private final By signInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //ссылка Зарегистрироваться
    private final By registerLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    //ссылка Восстановить пароль
    private final By forgotPassword = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле Email")
    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Нажать на кнопку Войти")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    @Step("Нажать на ссылку Восстановить пароль")
    public void clickForgotPassword() {
        driver.findElement(forgotPassword).click();
    }

    @Step("Нажать на ссылку Зарегистрироваться")
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public boolean checkTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loginTitle));
        return driver.findElement(loginTitle).isDisplayed();
    }

}
