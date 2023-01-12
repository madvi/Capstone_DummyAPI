
import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserResponse;
import Users.UserClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void shouldCreateUser(){

        String email = String.format( "%s@gmail.com", UUID.randomUUID());
        String firstName = "Vinutha";
        String lastName = "Mahadev";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(firstName,lastName,email);

        CreateUserResponse createUserResponse =  userClient.createUser(requestBody);
        createUserResponse.assertUser(requestBody);



    }


}
