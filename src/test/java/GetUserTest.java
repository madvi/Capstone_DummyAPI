import users.get.GetAllUserResponseByMyAccount;
import users.get.GetAllUsers;
import users.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldGetUsers(){
        GetAllUsers getAllUsers = usersService.getUser();
        Assert.assertEquals(getAllUsers.getStatusCode(),200);
    }

    @Test
    public void shouldGetUsersCreatedByYourAccount(){
        GetAllUserResponseByMyAccount getAllUserResponseByMyAccount = usersService.getUsersByAccount();
        Assert.assertEquals(getAllUserResponseByMyAccount.getStatusCode(),200);
    }

}
