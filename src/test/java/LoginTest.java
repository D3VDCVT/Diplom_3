import api.UserApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import pages.*;

import static models.Constants.*;


public class LoginTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void mainPageLogin() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickSignInButton();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void profilePageLogin() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickProfileButton();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void registerPageLogin() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        RegisterPage registerPage = new RegisterPage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickSignInButton();
        loginPage.clickRegisterLink();
        registerPage.clickSignIn();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void forgotPasswordLogin() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickSignInButton();
        loginPage.clickForgotPassword();
        forgotPasswordPage.clickSignIn();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());
    }
}
