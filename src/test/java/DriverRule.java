import api.UserApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;
import org.junit.rules.ExternalResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static models.Constants.*;

public class DriverRule extends ExternalResource{
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
        driver.get(BASE_URL);
        RestAssured.baseURI = BASE_URL;
    }

    @Override
    protected void after() {
        driver.quit();

        User login = new User (EMAIL, PASSWORD);
        UserApi userApi = new UserApi();
        Response response = userApi.checkUser(login);
        int statusCode = response.then().extract().statusCode();
        if (statusCode == 200) {
            String token = response.then().extract().path("accessToken");
            userApi.deleteUser(token).asString();
        }
    }

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        }
        else {
            initChrome();
        }
    }
    private void initYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("driver.version")).setup();

        var options = new ChromeOptions();
        options.setBinary(System.getProperty("webdriver.yandex.bin"));

        driver = new ChromeDriver(options);
    }
    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
