package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestExamples {

    @Test
    public void test1() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Content type: " + response.getContentType());
        System.out.println("Body: " + response.getBody().asString());
        System.out.println("Time taken: " + response.getTime());

        System.out.println("Header: " + response.getHeader("content-type"));
        System.out.println();
        response.prettyPrint();

        int statusCode = response.getStatusCode();
        assertThat(statusCode, equalTo(200));

//        Map<String, Object> map = given().accept(ContentType.JSON)
//                .when().get("https://reqres.in/api/users?page=2")
//                .then().contentType("application/json")
//                .and().extract().body().as(Map.class);
//
//        System.out.println(map);
    }

    @Test
    public void test2() {
        given().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200);
    }
}
