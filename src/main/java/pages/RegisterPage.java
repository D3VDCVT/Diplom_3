package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    //Поле Имя
    private final By nameField = By.xpath(".//fieldset[1]//input[@class='text input__textfield text_type_main-default']");
    //Поле Email
    private final By emailField = By.xpath(".//fieldset[2]//input[@class='text input__textfield text_type_main-default']");
    //Поле Пароль
    private final By passwordField = By.xpath(".//fieldset[3]//input[@class='text input__textfield text_type_main-default']");
    //Кнопка Зарегистрироваться
    private final By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    // ссылка Войти
    private final By signInButton = By.xpath(".//a[@class='Auth_link__1fOlj']");

    //Подсказка Некорректный пароль
    private final By invalidPassword = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поля при регистрации")
    public void sendRegistrationFields(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Нажать на ссылку Войти в окне регистрации")
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public boolean checkInvalidPassword() {new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(invalidPassword));
        return driver.findElement(invalidPassword).isDisplayed();
    }
}
