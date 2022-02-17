package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LocalAPITesting {

    @Test
    public void get_test() {
        baseURI = "http://localhost:3000";

        given().accept(ContentType.JSON)
                .param("name", "Tesla")
                .get(baseURI + "/users")
                .then().statusCode(200)
                .log().body();
    }

    @Test
    public void post_test() {
        baseURI = "http://localhost:3000";

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Alan");
        jsonObj.put("subjectId", 2);

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObj)
                .when().post(baseURI + "/users")
                .then().statusCode(201)
                .log().all();
    }

    @Test
    public void put_test() {
        baseURI = "http://localhost:3000";

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Einstein");
        jsonObj.put("subjectId", 2);

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObj)
                .when().put(baseURI + "/users/2")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void patch_test() {
        baseURI = "http://localhost:3000";

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Leonard");
        jsonObj.put("subjectId", 4);

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObj)
                .when().patch(baseURI + "/users/7")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void delete_test() {
        baseURI = "http://localhost:3000";

        given().delete(baseURI + "/users/6")
                .then().statusCode(200)
                .log().all();
    }
}
