package users;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreatePostRequestBody;

import static io.restassured.RestAssured.given;

public class BlogClient {
    public Response postCreate(CreatePostRequestBody body) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                //filter(new AllureRestAssured())
                .when()
                .filter(new AllureRestAssured())
                .post("https://dummyapi.io/data/v1/post/create");

        response.then()
                .log().body();
        return response;
    }

    public  Response getPost(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }

    public  Response deletePost(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }

    public  Response getDelete(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/post/{id}");
        response.then()
                .log().body();
        return response;
    }

}
