package com.zavadimka.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.zavadimka.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReqresInApiSpecification {

    public static RequestSpecification baseRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().method()
            .log().uri()
            .log().headers()
            .log().body();

    public static ResponseSpecification listUsersResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/list_users_response_schema.json"))
            .build();

    public static ResponseSpecification singleUserNotFoundResponseSpecWithStatusCode404 = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/single_user_not_found_schema.json"))
            .build();

    public static ResponseSpecification singleResourceResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/single_resource_schema.json"))
            .build();

    public static ResponseSpecification createResponseSpecWithStatusCode201 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/create_schema.json"))
            .build();

    public static ResponseSpecification updateResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/update_schema.json"))
            .build();

    public static ResponseSpecification deleteResponseSpecWithStatusCode204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification registerUnsuccessfulResponseSpecWithStatusCode400 = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/register_unsuccessful_schema.json"))
            .build();


    public static ResponseSpecification delayedResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody(matchesJsonSchemaInClasspath("schemas/delayed_response_schema.json"))
            .build();
}
