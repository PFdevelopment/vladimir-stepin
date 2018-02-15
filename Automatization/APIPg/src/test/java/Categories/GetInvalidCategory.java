package Categories;

import Settings.FunctionalTest;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class GetInvalidCategory extends FunctionalTest {
   public void test_getInvalidCategory() {
       // Reassign the id to the wrong one
       String id = "bla34";

       // Getting the response(error 404)
       Response response = RestAssured.given().when().log().all().get("/" + id);

       // Checking that the server returned 404 error
       response.then().statusCode(404);
   }
}
