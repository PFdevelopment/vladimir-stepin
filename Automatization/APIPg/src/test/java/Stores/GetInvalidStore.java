package Stores;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetInvalidStore extends FunctionalTest {
    public void getInvalidStore() {
        // Reassign the id to the wrong one
        String id = "bla34";

        // Getting the response(error 404)
        Response response = RestAssured.given().when().log().all().get("stores/" + id);

        // Checking that the server returned 404 error
        response.then().statusCode(404);
    }
}
