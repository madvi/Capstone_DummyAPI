package Users;

import Users.Create.CreateUserRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public static Response createUser(CreateUserRequestBody body) {
        return given()
                .header("app-id", "63849396d9cf2f44805f4cd2")
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");
    }
}
