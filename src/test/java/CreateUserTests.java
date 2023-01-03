import Users.Create.CreateUserRequestBody;
import Users.UserClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void shouldCreateUser(){

        String email = String.format( "%s@gmail.com", UUID.randomUUID());
        String firstName = "Vinutha";
        String lastName = "Mahadev";

        /*String body = "{\n" +
                "    \"firstName\": \"Vinutha1\",\n" +
                "    \"lastName\": \"Mahadev\",\n" +
                "    \"email\": \"mahabhag.021@gmail.com\"\n" +
                "}";*/
        CreateUserRequestBody requestBody = new CreateUserRequestBody(firstName,lastName,email);

        new UserClient().createUser(requestBody)
            .then()
                .log().body()
                .statusCode(201);
                //.body("email", Matchers.equalTo("mahabhag.021@gmail.com"))
                //.body("data.id", Matchers.notNullValue());

    }


}
