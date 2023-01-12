import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserErrorResponse;
import Users.UserClient;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class NegativeTests {
    UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){

        String firstName = "Vinutha";
        String lastName = "Mahadev";
        String email = "fdf@gmail.com";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(firstName,lastName,email);

        CreateUserErrorResponse errorResponse = userClient.createUserExpectingError(requestBody);
        Assert.assertEquals(errorResponse.getStatusCode(),400);
        Assert.assertEquals(errorResponse.getError(),"BODY_NOT_VALID");
        Assert.assertEquals(errorResponse.getData().getEmail(),"Email already used");


    }
}
