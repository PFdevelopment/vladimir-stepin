package Stores;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import UtilityClasses.Store;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import UtilityClasses.ReadWrite.*;

public class UpdateStore extends FunctionalTest {

    public void updateStore() {
        // Getting id
        String fileName = "store_id.txt";
        String id = ReadWrite.read(fileName);

        // Preparing data for update
        Store store = new Store();

        store.setName("Updated Store");
        store.setType("Music");
        store.setAddress("123 Fake St.");
        store.setAddress2("");
        store.setCity("Old York");
        store.setState("NY");
        store.setZip("10004");
        store.setLat(44.99);
        store.setLng(-93.44);
        store.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");


        Response response = RestAssured.given().pathParam("id", id).contentType(ContentType.JSON).body(store).when().log().all().put("stores/{id}");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("Updated Store"));

    }
}
