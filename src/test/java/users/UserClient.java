package users;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import users.create.CreatePostRequestBody;
import users.create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private RequestSpecification metaData() {
        return given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON);
    }

    public Response create(CreateUserRequestBody body) {
        Response response = metaData()
                .body(body)
                .when()
                .filter(new AllureRestAssured())
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return response;
    }


    public Response getAllUser() {
        Response response = metaData()
                .when()
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;
    }

    public Response getUserByAccount() {
        Response response = metaData()
                .param("created", 1)
                .when()
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/user");
        response.then()
                .log().body();
        return response;
    }

    public Response deleteUser(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                    .delete("https://dummyapi.io/data/v1/user/{id}");

        response
                .then()
                .log().body();

        return response;
    }

    public Response getDeleteUser(String id) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
                .when()
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/user/{id}");
        response.then()
                .log().body();
        return response;
    }


}
