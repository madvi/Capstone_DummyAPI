package Users;

import Users.Create.CreatePostRequestBody;
import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreatePostResponse;
import Users.Create.Response.CreateUserErrorResponse;
import Users.Create.Response.CreateUserResponse;
import Users.GetAllByAccount.GetAllUserResponseByMyAccount;
import Users.Post.GetPost.GetPostResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public static CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public static Response create(CreateUserRequestBody body) {
        Response response =  given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return response;

    }

    public static CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }

    public static Response getUser() {
        return given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .when()
                .get("https://dummyapi.io/data/v1/user");

    }
    public static GetAllUserResponseByMyAccount getUsersByAccount(){
        Response response = given()
                     .header("app-id", "63849396d9cf2f44805f4cd2")
                     .param("created", 1)
                .when()
                    .get("https://dummyapi.io/data/v1/user");
        response.then()
                    .log().body();

        int statusCode = response.statusCode();
       GetAllUserResponseByMyAccount getAllUserResponseByMyAccount =  response.as(GetAllUserResponseByMyAccount.class);
       getAllUserResponseByMyAccount.setStatusCode(statusCode);

        return getAllUserResponseByMyAccount;

    }

    public static CreatePostResponse createPost(CreatePostRequestBody body) {
        Response response = postCreate(body);
        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.statusCode());

        return createPostResponse;
    }

    public static Response postCreate(CreatePostRequestBody body) {
        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");

        response.then()
                .log().body();
        return response;
    }

    public GetPostResponse getPostById(String id){

        Response response = given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .pathParam("id", id)
             .when()
                .get("https://dummyapi.io/data/v1/post/{id}");

                //.statusCode(200)
        response.then()
                .log().body();

         int statusCode = response.statusCode();
         GetPostResponse getPostResponse = response.as(GetPostResponse.class);
         getPostResponse.setStatusCode(statusCode);

        return getPostResponse;
    }


}
