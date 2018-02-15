package Version;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;

public class CurrentVersion extends FunctionalTest {
    public void displayCurrentVersion() {
        Response response = RestAssured.given().when().log().all().get("version");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("1.1.0"));
    }
}
