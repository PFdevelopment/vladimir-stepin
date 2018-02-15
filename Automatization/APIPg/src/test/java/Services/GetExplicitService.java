package Services;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class GetExplicitService extends FunctionalTest {
    public void getExplicitService() {
        String fileName = "service_id.txt";
        String id = ReadWrite.read(fileName);

        // Retrieve the body of the response
        Response response = RestAssured.given().when().log().all().get("services/" + id);

        response.then().assertThat().body(CoreMatchers.containsString("New Service"));

        // Checks status of the response
        response.then().statusCode(200);
    }
}
