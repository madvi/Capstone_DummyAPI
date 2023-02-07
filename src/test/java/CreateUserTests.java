
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;
import users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateUser(){

        //1.Arrange

        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();

        //2.Act
        CreateUserResponse createUserResponse =  usersService.createUser(requestBody);

        //3.Assert
        createUserResponse.assertUser(requestBody);
    }


}
