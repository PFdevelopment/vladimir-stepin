package Services;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class GetAllAvailableServices extends FunctionalTest {
    public void getAllAvailableServices() {
        // Retrieve the body of the response
        Response response = RestAssured.given().when().log().all().get("services");

        // Checks the response code
        response.then().statusCode(200);

        // Checks that the response contains name
        response.then().assertThat().body("data.name", CoreMatchers.hasItem("Best Buy Mobile"));
    }
}
