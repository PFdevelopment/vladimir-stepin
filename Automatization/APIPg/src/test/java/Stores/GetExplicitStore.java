package Stores;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class GetExplicitStore extends FunctionalTest {
    public void getExplicitStore() {
        Response response = RestAssured.given().pathParam("id", 8944).when().log().all().get("stores/{id}");

        response.then().statusCode(200);
    }
}
