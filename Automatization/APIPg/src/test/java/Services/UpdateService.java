package Services;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import UtilityClasses.Service;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class UpdateService extends FunctionalTest {
    public void updateService() {
        Service service = new Service();

        service.setName("Updated Service");

        String fileName = "service_id.txt";
        String id = ReadWrite.read(fileName);

        Response response = RestAssured.given().pathParam("id", id).contentType(ContentType.JSON).body(service).when().log().all().put("services/{id}");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("Updated Service"));
    }
}
