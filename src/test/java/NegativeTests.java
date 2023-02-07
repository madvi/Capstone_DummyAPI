import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.create.response.CreateUserResponse;

public class NegativeTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldNotAllowToCreateUserWithUsedEmail(){

        //1.Arrange
       // CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("fdf@gmail.com").build();
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        usersService.createUser(requestBody);

        //2.Act
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(requestBody);

        //3.Assert
        errorResponse.assertUser(400);

    }
}
