package Services;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class DeleteService extends FunctionalTest {
    public void deleteService() {
        String fileName = "service_id.txt";
        String id = ReadWrite.read(fileName);

        Response response = RestAssured.given().pathParam("id", id).when().log().all().delete("services/{id}");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("Updated Service"));
    }
}
