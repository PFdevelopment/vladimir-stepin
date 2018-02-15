package Stores;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import UtilityClasses.ReadWrite.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;


public class DeleteStore extends FunctionalTest {
    public void deleteStore() {
        String fileName = "store_id.txt";

        String id = ReadWrite.read(fileName);

        Response response = RestAssured.given().pathParam("id", id).when().log().all().delete("stores/{id}");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("Updated Store"));
    }
}
