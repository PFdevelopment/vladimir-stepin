package HealthCheck;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;

public class HealthCheck extends FunctionalTest {
    public void healthCheck() {
        Response response = RestAssured.given().when().log().all().get("healthcheck");

        response.then().statusCode(200);
        response.then().assertThat().body("readonly", CoreMatchers.is(false));
    }
}
