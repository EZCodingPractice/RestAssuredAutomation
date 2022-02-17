package tests;

import data.DataForTest;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DataDrivenDemo1 extends DataForTest {


    @Test(dataProvider = "DataForPost")
    public void post_test(String name, int subjectId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("subjectId", subjectId);

        baseURI = "http://localhost:3000";

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject)
                .when().post("/users")
                .then().statusCode(201)
                .log().all();
    }

    @Test(dataProvider = "DataForDelete")
    public void deleteTest(Integer userId) {
        baseURI = "http://localhost:3000";

        given().delete(baseURI + "/users/" + userId)
                .then().statusCode(200)
                .log().all();
    }

}
