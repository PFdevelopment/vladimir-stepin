package Products;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class GetExplicitProduct extends FunctionalTest {
    public void getExplicitProduct() {
        String fileName = "product_id.txt";
        String id = ReadWrite.read(fileName);

        // Retrieve the body of the response
        Response response = RestAssured.given().when().log().all().get("products/" + id);

        response.then().assertThat().body(CoreMatchers.containsString("New Product"));

        // Checks status of the response
        response.then().statusCode(200);
    }
}
