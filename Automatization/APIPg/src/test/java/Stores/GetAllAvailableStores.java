package Stores;

import Settings.FunctionalTest;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetAllAvailableStores extends FunctionalTest {
    public void getAllAvailableStores() {
        Response response = RestAssured.given().when().log().all().get("stores");

        // Checks status
        response.then().statusCode(200);
    }
}
