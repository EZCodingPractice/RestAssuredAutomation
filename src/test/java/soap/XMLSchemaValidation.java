package soap;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

/**
 * How to validate XML response against Schema
 * Step 1: Create and Get XML Schema (XSD)
 * Step 2: Add XSD to classpath in the project - src/main/resources
 * Step 3: Add a new class
 * Step 4: Create a function > Annotate with @Test(TestNG)
 * Step 5: Add code to run a API request with Rest Assured
 * Step 6: Add code to validate XML response against XML Schema (XSD)
 *      assertThat().body(matchesXsdInClasspath("calculator.xsd"));
 */

public class XMLSchemaValidation {

    @Test
    public void validateXMLAgainstSchema() throws IOException {
        File schema_file = new File("src/test/resources/add.xml");
        if(schema_file.exists())
            System.out.println("File Exists");

        FileInputStream fileInputStream = new FileInputStream(schema_file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "http://www.dneonline.com";

        given().contentType("text/xml")
                .accept(ContentType.XML)
                .body(requestBody)
                .when().post("/calculator.asmx")
                .then().statusCode(200)
                .log().all()
                .and().body("//*:AddResult.text()", equalTo("7"))
                .and().assertThat().body(matchesXsdInClasspath("calculator.xsd"));
    }
}
