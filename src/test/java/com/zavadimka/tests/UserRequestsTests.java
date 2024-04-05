package com.zavadimka.tests;

import com.google.common.collect.Lists;
import com.zavadimka.models.ResponseUserModel;
import com.zavadimka.models.users.ListUsersResponseModel;
import com.zavadimka.models.users.SingleUserNotFoundResponseModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.zavadimka.specs.ReqresInApiSpecification.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


@Owner("Dmitry Zavada")
@Feature("REST Api REST Assured tests")
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("user_requests")})
public class UserRequestsTests extends TestBase {

    @Test
    @DisplayName("### REST Api REST Assured User requests: Get List Users test")
    void getListUsersResponseShouldHaveStatus200() {

        ListUsersResponseModel response = step("Make Get request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                    .when()
                        .get("/users?page=2")
                    .then()
                        .spec(listUsersResponseSpecWithStatusCode200)
                        .extract().as(ListUsersResponseModel.class)
        );

        step("Response checks", () -> {
            assertThat(response.getPage()).isEqualTo(2);
            assertThat(Lists.transform(response.getData(), ResponseUserModel::getId)).contains(7, 8, 9, 10, 11, 12);
        });
    }

    @Test
    @DisplayName("### REST Api REST Assured User requests: Get Single User Not Found test")
    void getSingleUserNotFoundResponseShouldHaveStatus404() {

        SingleUserNotFoundResponseModel response = step("Make Get request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                    .when()
                        .get("/users/23")
                    .then()
                        .spec(singleUserNotFoundResponseSpecWithStatusCode404)
                        .extract().as(SingleUserNotFoundResponseModel.class)
        );
    }
}
