package Stores;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import UtilityClasses.Store;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import UtilityClasses.ReadWrite.*;

public class CreateStore extends FunctionalTest {
    public void createStore() {
        Store store = new Store();
        store.setName("New Store");
        store.setType("Music");
        store.setAddress("123 Fake St.");
        store.setAddress2("");
        store.setCity("New York");
        store.setState("NY");
        store.setZip("10001");
        store.setLat(44.99);
        store.setLng(-93.44);
        store.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = RestAssured.given().when().log().all().contentType(ContentType.JSON).body(store).post("stores");

        ResponseBody responseBody = response.getBody();

        String textOfBody = responseBody.asString();

        String fileName = "store_id.txt";

        ReadWrite.write(fileName, textOfBody);

        //System.out.println(textOfBody);
        //System.out.println(currentId);

        response.then().statusCode(201);

        response.then().body(Matchers.containsString("New Store"));
    }
}
