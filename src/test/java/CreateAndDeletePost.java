import Users.Create.CreatePostRequestBody;
import Users.Create.CreateUserRequestBody;
import Users.UserClient;
import Users.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;



public class CreateAndDeletePost {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateAndDeletePost() {

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        String id = usersService.createPost(requestBody).getId();

        //3.Assert
        usersService.deletePostByID(id).assertPostDelete(id);

    }
}