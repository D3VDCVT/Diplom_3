package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    //кнопка Войти в аккаунт
    private final By signInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    //кнопка Личный кабинет
    private final By profileButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    //h1 "Соберите бургер"
    private final By titleMainPage = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10' and text()='Соберите бургер']");

    //Раздел Булки
    private final By bun = By.xpath(".//span[text()='Булки']");

    //Раздел Соусы
    private final By sauce = By.xpath(".//span[text()='Соусы']");

    //Раздел Начинки
    private final By filling = By.xpath(".//span[text()='Начинки']");

    //Выбранный раздел Конструктора
    private final By selectedConstructorSection = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(titleMainPage));
        return driver.findElement(titleMainPage).isDisplayed();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }

    @Step("Нажать на раздел Булки")
    public void clickBun() {
        driver.findElement(bun).click();
    }

    @Step("Нажать на раздел Соусы")
    public void clickSauce() {
        driver.findElement(sauce).click();
    }

    @Step("Нажать на раздел Начинки")
    public void clickFilling() {
        driver.findElement(filling).click();
    }

    public String getSelectedSectionText() {
       return driver.findElement(selectedConstructorSection).getText();
    }
}
