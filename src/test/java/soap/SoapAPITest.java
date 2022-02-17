package soap;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * To get request body from a file
 * Step 1: Create a file with xml extension
 * Step 2: Copy the request body and save file
 * Step 3: Get the file in the Code
 * Step 4: Add code to check file exists
 * Step 5: Add Expected condition | Response Validation
 */

public class SoapAPITest {

    @Test
    public void soap_api_test() throws IOException {
        File file = new File("src/test/resources/add.xml");
        if(file.exists()) {
            System.out.println("Exists");
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "http://www.dneonline.com";


        given().contentType("text/xml")
                .accept(ContentType.XML)
                .body(requestBody)
                .when().post("/calculator.asmx")
                .then().statusCode(200)
                .log().all()
                .and().body("//*:AddResult.text()", equalTo("7"));
    }
}
