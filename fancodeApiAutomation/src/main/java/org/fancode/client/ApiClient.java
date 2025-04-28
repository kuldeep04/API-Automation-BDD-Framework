package org.fancode.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.fancode.config.ApiEndpoints;
import org.fancode.utilities.configUtils.PropertiesUtils;
import java.io.IOException;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ApiClient extends BaseApiClient {

    public ApiClient() throws IOException {
        PropertiesUtils propertiesUtils = new PropertiesUtils();
        RestAssured.baseURI = propertiesUtils.getProperty("baseUrl");
        initSpecifications();
    }

    public <T> T get(String endpoint, Class<T> responseType) {
        return given()
                .spec(requestSpec)
                .when()
                .get(String.valueOf(endpoint))
                .then()
                .spec(responseSpec)
                .extract()
                .as(responseType);
    }

    public Response getRawResponse(ApiEndpoints endpoint) {
        return given()
                .spec(requestSpec)
                .when()
                .get(String.valueOf(endpoint))
                .then()
                .extract()
                .response();
    }

    public <T> T get(String endpoint, Map<String, String> headers, Class<T> responseClass) {
        return given()
                .headers(headers)
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .as(responseClass);
    }
}
