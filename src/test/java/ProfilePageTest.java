import api.UserApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static models.Constants.*;

public class ProfilePageTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @DisplayName("Переход из личного кабинета в конструктор")
    @Test
    public void moveToConstructor() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        ProfilePage profilePage = new ProfilePage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickProfileButton();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());

        mainPage.clickProfileButton();
        Assert.assertTrue(profilePage.checkProfileButton());

        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.checkTitle());
    }

    @DisplayName("Переход по клику на логотип Stellar Burgers")
    @Test
    public void moveToLogo() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        ProfilePage profilePage = new ProfilePage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickProfileButton();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());

        mainPage.clickProfileButton();
        Assert.assertTrue(profilePage.checkProfileButton());

        profilePage.clickStellarBurgers();
        Assert.assertTrue(mainPage.checkTitle());
    }

    @DisplayName("Выход из аккаунта")
    @Test
    public void checkSignOutButton() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        ProfilePage profilePage = new ProfilePage(driverRule.getDriver());

        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response createUser = userApi.createUser(user);
        Assert.assertEquals(200, createUser.statusCode());

        mainPage.clickProfileButton();
        loginPage.setEmailField(EMAIL);
        loginPage.setPasswordField(PASSWORD);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkTitle());

        mainPage.clickProfileButton();
        Assert.assertTrue(profilePage.checkProfileButton());

        profilePage.clickSignOut();
        loginPage.checkTitle();
    }
}
