package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;
import static models.Constants.*;

public class UserApi {
    @Step("Send POST request create user to /api/auth/register")
    public Response createUser(User user) {
        return given()
                .header(HEADER_TYPE,HEADER_JSON)
                .body(user)
                .post(CREATE_USER);
    }

    @Step("Send POST request login user to /api/auth/login without extracting at class")
    public Response checkUser(User user) {
        return given()
                .header(HEADER_TYPE,HEADER_JSON)
                .body(user)
                .post(LOGIN_USER);
    }

    @Step("Send DELETE request user to /api/auth/user without extracting at class")
    public Response deleteUser (String token) {
        return given()
                .header(HEADER_TYPE,HEADER_JSON)
                .header(AUTHORIZATION, token)
                .delete(DELETE_USER);
    }
}
