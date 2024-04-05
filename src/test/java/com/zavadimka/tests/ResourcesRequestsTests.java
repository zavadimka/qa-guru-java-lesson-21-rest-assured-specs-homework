package com.zavadimka.tests;

import com.zavadimka.models.resources.SingleResourceResponseModel;
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
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("resources_requests")})
public class ResourcesRequestsTests extends TestBase {

    @Test
    @DisplayName("### REST Api REST Assured Resources requests: Get Single Resource test")
    void getSingleResourceResponseShouldHaveStatus200() {

        SingleResourceResponseModel response = step("Make Get request to URL", () ->
                given()
                        .spec(baseRequestSpec)
                    .when()
                        .get("/unknown/2")
                    .then()
                        .spec(singleResourceResponseSpecWithStatusCode200)
                        .extract().as(SingleResourceResponseModel.class)
        );

        step("Response checks", () -> {
            assertThat(response.getData().getId()).isEqualTo(2);
            assertThat(response.getSupport().getUrl()).isEqualTo("https://reqres.in/#support-heading");
        });
    }
}
