package Services;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import UtilityClasses.Service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class CreateService extends FunctionalTest {
    public void createService() {
        Service service = new Service();
        service.setName("New Service");

        Response response = RestAssured.given().contentType(ContentType.JSON).body(service).when().log().all().post("services");

        ResponseBody responseBody = response.getBody();

        String textOfBody = responseBody.asString();

        String fileName = "service_id.txt";

        ReadWrite.write(fileName, textOfBody);

        response.then().statusCode(201);

        response.then().assertThat().body(CoreMatchers.containsString("New Service"));
    }
}
