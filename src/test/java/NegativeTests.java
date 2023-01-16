import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldNotAllowToCreateUserWithUsedEmail(){

        //1.Arrange
        /*String firstName = "Vinutha";
        String lastName = "Mahadev";
        String email = "fdf@gmail.com";

       // CreateUserRequestBody requestBody = new CreateUserRequestBody(firstName,lastName,email);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().email(email).firstName(firstName)
                .lastName(lastName).build();*/
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("fdf@gmail.com").build();

        //2.Act
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(requestBody);

        //3.Assert
        errorResponse.assertUser(400);

    }
}
