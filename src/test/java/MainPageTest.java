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

public class MainPageTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @DisplayName("Переход по клику на Личный кабинет")
    @Test
    public void moveToProfilePage() {
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
    }

    @DisplayName("Переход к разделу Булки")
    @Test
    public void switchConstructorBun() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.clickSauce();
        mainPage.clickBun();
        String expected = "Булки";
        String actual = mainPage.getSelectedSectionText();
        Assert.assertEquals(expected, actual);
    }

    @DisplayName("Переход к разделу Соусы")
    @Test
    public void switchConstructorSauce() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.clickSauce();
        String expected = "Соусы";
        String actual = mainPage.getSelectedSectionText();
        Assert.assertEquals(expected, actual);
    }

    @DisplayName("Переход к разделу Начинки")
    @Test
    public void switchConstructorFilling() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.clickFilling();
        String expected = "Начинки";
        String actual = mainPage.getSelectedSectionText();
        Assert.assertEquals(expected, actual);
    }
}
