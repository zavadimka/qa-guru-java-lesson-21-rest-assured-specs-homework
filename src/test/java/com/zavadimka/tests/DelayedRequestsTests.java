package com.zavadimka.tests;

import com.google.common.collect.Lists;
import com.zavadimka.models.ResponseUserModel;
import com.zavadimka.models.delayed.DelayedResponseModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.zavadimka.specs.ReqresInApiSpecification.baseRequestSpec;
import static com.zavadimka.specs.ReqresInApiSpecification.delayedResponseSpecWithStatusCode200;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


@Owner("Dmitry Zavada")
@Feature("REST Api REST Assured tests")
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("delayed_requests")})
public class DelayedRequestsTests extends TestBase {

    @Test
    @DisplayName("### REST Api REST Assured Delayed requests: Get Delayed Response test")
    void getDelayedResponseShouldHaveStatus200() {

        DelayedResponseModel response = step("Make Get request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                    .when()
                        .get("/users?delay=3")
                    .then()
                        .spec(delayedResponseSpecWithStatusCode200)
                        .extract().as(DelayedResponseModel.class)
        );

        step("Response checks", () -> {
            assertThat(response.getPage()).isEqualTo(1);
            assertThat(response.getPerPage()).isEqualTo(6);
            assertThat(response.getData()).hasSize(6);

            assertThat(Lists.transform(response.getData(), ResponseUserModel::getId)).contains(1, 2, 3, 4, 5, 6);
            assertThat(response.getData().get(0).getId()).isEqualTo(1);
            assertThat(response.getData().get(1).getFirstName()).isEqualTo("Janet");
            assertThat(response.getData().get(4).getEmail()).isEqualTo("charles.morris@reqres.in");
        });
    }
}
