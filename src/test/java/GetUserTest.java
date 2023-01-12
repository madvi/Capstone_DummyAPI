import Users.GetAllByAccount.GetAllUserResponseByMyAccount;
import Users.UserClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest {
    UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void shouldGetAllUsers(){
        userClient.getUser()
             .then()
                .log().body()
                .statusCode(200)
                .body("data.id", Matchers.notNullValue());

    }

    @Test
    public void shouldGetUsersCreatedByYourAccount(){
        GetAllUserResponseByMyAccount getAllUserResponseByMyAccount = userClient.getUsersByAccount();
        Assert.assertEquals(getAllUserResponseByMyAccount.getStatusCode(),200);
    }

}
