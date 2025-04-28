package com.grok.api;

import com.grok.config.ConfigReader;
import com.grok.utils.LogManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private final String baseUrl;

    public ApiClient() {
        this.baseUrl = ConfigReader.getProperty("api.base.url");
    }

    public Response get(String endpoint) {
        LogManager.info("Sending GET request to: " + baseUrl + endpoint);
        return RestAssured.given()
                .baseUri(baseUrl)
                .when()
                .get(endpoint);
    }

    public Response post(String endpoint, Object body) {
        LogManager.info("Sending POST request to: " + baseUrl + endpoint);
        return RestAssured.given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);
    }
}