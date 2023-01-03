import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest {

    @Test
    public void shouldGetAllUsers(){
        given()
                .header("app-id","63849396d9cf2f44805f4cd2")
             .when()
                .get("https://dummyapi.io/data/v1/user")
             .then()
                .log().body()
                .statusCode(200)
                .body("data.id", Matchers.notNullValue());

    }
}
