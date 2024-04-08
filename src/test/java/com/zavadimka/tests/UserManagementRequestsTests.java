package com.zavadimka.tests;

import com.zavadimka.models.management.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
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
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("management_requests")})
public class UserManagementRequestsTests extends TestBase {

    @Test
    @DisplayName("### REST Api REST Assured User Management requests: Post Create test")
    void postCreateResponseShouldHaveStatus201() {

        UserManagementBodyModel userData = new UserManagementBodyModel();
        userData.setName("morpheus");
        userData.setJob("leader");

        CreateResponseModel response = step("Make Post request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                        .body(userData)
                    .when()
                        .post("/users")
                    .then()
                        .spec(createResponseSpecWithStatusCode201)
                .extract().as(CreateResponseModel.class)
        );

        step("Response checks", () -> {
            assertThat(response.getName()).isEqualTo("morpheus");
            assertThat(response.getJob()).isEqualTo("leader");
        });
    }

    @Test
    @DisplayName("### REST Api REST Assured User Management requests: Put Update test")
    void putUpdateResponseShouldHaveStatus200() {

        UserManagementBodyModel userData = new UserManagementBodyModel();
        userData.setName("morpheus");
        userData.setJob("zion resident");

        UpdateResponseModel response = step("Make Put request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                        .body(userData)
                    .when()
                        .put("/users/2")
                    .then()
                        .spec(updateResponseSpecWithStatusCode200)
                .extract().as(UpdateResponseModel.class)
        );

        step("Response checks", () -> {
            assertThat(response.getName()).isEqualTo("morpheus");
            assertThat(response.getJob()).isEqualTo("zion resident");
        });
    }

    @Test
    @DisplayName("### REST Api REST Assured User Management requests: Delete test")
    void deleteResponseShouldHaveStatus204() {

        Response response = step("Make Delete request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                    .when()
                        .delete("/users/2")
                    .then()
                        .spec(deleteResponseSpecWithStatusCode204)
                        .extract().response()
        );
    }
}
