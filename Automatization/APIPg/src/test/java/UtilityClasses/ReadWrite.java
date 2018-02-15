package UtilityClasses;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.Reporter;

import java.io.*;
import java.util.Scanner;

public class ReadWrite {
    private StringWriter writer;
    private PrintStream captor;

    public static String read(String fileName) {
        // Getting id
        String id = "";
        try {
            Scanner sc = new Scanner(new File(fileName));
            id = sc.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static void write(String fileName, String textOfBody) {

        JsonPath jp = new JsonPath(textOfBody);
        try {
            String currentId = jp.getString("id");
            File newTextFile = new File(fileName);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(currentId);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
}
