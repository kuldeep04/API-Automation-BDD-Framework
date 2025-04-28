package org.fancode.client;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.fancode.utilities.requests.SpecificationFactory;

public class BaseApiClient {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    public BaseApiClient() {}

    protected void initSpecifications(){
        this.requestSpec = SpecificationFactory.getDefaultRequestSpec();
        this.responseSpec = SpecificationFactory.getDefaultResponseSpec();
    }
}
