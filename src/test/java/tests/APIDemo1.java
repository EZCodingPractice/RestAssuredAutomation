package tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import static org.hamcrest.Matchers.*;

public class APIDemo1 {

    @Test
    public void get_demo() {
        given().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Tobias", "Michael"))
                .log().all();
    }

    @Test

    public void get_demo2() {
        given().header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200);
    }

    @Test
    public void post_demo1(){
        JSONObject jsonReq = new JSONObject();
        jsonReq.put("name", "john");
        jsonReq.put("job", "teacher");
        System.out.println(jsonReq);

        given().accept(ContentType.JSON)
                // .header("Content-Type", "application/json")
                // .contentType(ContentType.JSON)
                .body(jsonReq.toJSONString())
                .post("https://reqres.in/api/users")
                .then().statusCode(201)
                .log().all();
    }

    @Test
    public void put_demo1() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name","Dave");
        jsonObj.put("job", "Singer");
        System.out.println(jsonObj);

        given().accept(ContentType.JSON)
                .body(jsonObj.toJSONString())
                .when().put("https://reqres.in/api/users/5")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void patch_demo1() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name","Dave");
        jsonObj.put("job", "Dancer");
        System.out.println(jsonObj);

        given().accept(ContentType.JSON)
                .body(jsonObj.toJSONString())
                .when().patch("https://reqres.in/api/users/5")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void displayAll_demo1() {
        given().accept(ContentType.JSON)
                .when().get("https://reqres.in/api/users")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void delete_demo1() {
        when().delete("https://reqres.in/api/users/5")
                .then().statusCode(204)
                .log().all();
    }

}
