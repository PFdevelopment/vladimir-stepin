package Categories;

import Settings.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

public class GetExplicitCategory extends FunctionalTest {
    public String checkStr =  "Gift Ideas";

    public void test_getExplicitCategory() {
        // Retrieve the body of the response
        Response response = RestAssured.given().when().log().all().get("categories/" + id);
        ResponseBody responseBody = response.getBody();

        response.then().assertThat().body(CoreMatchers.containsString(checkStr));

        // Checks status of the response
        response.then().statusCode(200);

    }
}
