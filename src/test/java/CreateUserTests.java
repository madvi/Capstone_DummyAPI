
import Users.Create.CreatePostRequestBody;
import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserResponse;
import Users.UserClient;
import Users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.UUID;

public class CreateUserTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateUser(){

        //1.Arrange
       /* String email = String.format( "%s@gmail.com", UUID.randomUUID());
        String firstName = "Vinutha";
        String lastName = "Mahadev";

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(firstName,lastName,email);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().email(email).firstName(firstName)
                .lastName(lastName).build();*/
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();

        //2.Act
        CreateUserResponse createUserResponse =  usersService.createUser(requestBody);

        //3.Assert
        createUserResponse.assertUser(requestBody);
    }


}
