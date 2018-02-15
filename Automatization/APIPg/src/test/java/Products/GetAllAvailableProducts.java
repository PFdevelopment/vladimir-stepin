package Products;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class GetAllAvailableProducts extends FunctionalTest {

    // Displays all available categories and checks the status of response
    public void test_getAllAvailableProducts() {
        // Retrieve the body of the response
        Response response = RestAssured.given().when().log().all().get("products");

        // Checks the response code
        response.then().statusCode(200);

        // Checks that the response contains name
        response.then().assertThat().body("data.id", CoreMatchers.hasItem(48530));

    }
}
