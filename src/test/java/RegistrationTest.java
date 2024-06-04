import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static models.Constants.*;

public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @DisplayName("Успешная регистрация")
    @Test
    public void registration() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        RegisterPage registerPage = new RegisterPage(driverRule.getDriver());

        mainPage.clickSignInButton();
        loginPage.clickRegisterLink();
        registerPage.sendRegistrationFields(NAME, EMAIL, PASSWORD);
        registerPage.clickRegisterButton();
        Assert.assertTrue(loginPage.checkTitle());
    }

    @DisplayName("Ошибка регистрации. Пароль меньше шести символов")
    @Test
    public void registrationIncorrectPassword() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        RegisterPage registerPage = new RegisterPage(driverRule.getDriver());

        mainPage.clickSignInButton();
        loginPage.clickRegisterLink();
        registerPage.sendRegistrationFields(NAME, EMAIL, "qwe");
        registerPage.clickRegisterButton();

        Assert.assertTrue(registerPage.checkInvalidPassword());
    }
}
