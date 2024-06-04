package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    //кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");

    //логотип Stellar Burgers
    private final By stellarBurgersLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    //кнопка Выход
    private final By signOutButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");

    private final By profileButton = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип")
    public void clickStellarBurgers() {
        driver.findElement(stellarBurgersLogo).click();
    }

    @Step("Нажать на кнопку выход Выход")
    public void clickSignOut() {
        driver.findElement(signOutButton).click();
    }

    public boolean checkProfileButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(profileButton));
        return driver.findElement(profileButton).isDisplayed();
    }

}
