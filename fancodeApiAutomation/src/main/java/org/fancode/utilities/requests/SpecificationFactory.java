package org.fancode.utilities.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class SpecificationFactory {

    public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification getDefaultResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectResponseTime(lessThan(4L), TimeUnit.SECONDS)
                .build();
    }

    public static ResponseSpecification getCustomResponseSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .expectContentType("application/json")
                .build();
    }
}
