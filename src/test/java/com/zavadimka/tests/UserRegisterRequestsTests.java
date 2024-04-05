package com.zavadimka.tests;

import com.zavadimka.models.register.RegisterUnsuccessfulBodyModel;
import com.zavadimka.models.register.RegisterUnsuccessfulResponseModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.zavadimka.specs.ReqresInApiSpecification.baseRequestSpec;
import static com.zavadimka.specs.ReqresInApiSpecification.registerUnsuccessfulResponseSpecWithStatusCode400;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Dmitry Zavada")
@Feature("REST Api REST Assured tests")
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("register_requests")})
public class UserRegisterRequestsTests extends TestBase {

    @Test
    @DisplayName("### REST Api REST Assured User Register requests: Post Register - Unsuccessful test")
    void postRegisterUnsuccessfulResponseShouldHaveStatus400() {

        RegisterUnsuccessfulBodyModel userData = new RegisterUnsuccessfulBodyModel();
        userData.setEmail("sydney@fife");

        RegisterUnsuccessfulResponseModel response = step("Make Post request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                        .body(userData)
                    .when()
                        .post("/register")
                    .then()
                        .spec(registerUnsuccessfulResponseSpecWithStatusCode400)
                        .extract().as(RegisterUnsuccessfulResponseModel.class)
                );

        step("Response checks", () ->
                assertThat(response.getError()).isEqualTo("Missing password")
        );
    }
}
