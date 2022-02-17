package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * How to validate JSON Schema
 * Step 1: Create JSON Schema
 * Step 2: Add JSON Schema file in classpath (target/classes)
 * Step 3: Add Maven dependency for JSON Schema Validator
 * Step 4: Create a function to validate JSON response against schema
 * Step 5: Run & Validate
 */

public class JSONSchemaValidation {

    @Test
    public void get_demo() {
        given().header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Tobias", "Michael"))
                .log().all();
    }

    @Test
    public void schema_validation() {
        given().header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200).log().all();

    }


}
