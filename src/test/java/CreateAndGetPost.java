import users.create.CreatePostRequestBody;
import users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAndGetPost {

    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }
    @Test
    public void shouldCreatePostAndGetPostById(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        String id = usersService.createPost(requestBody).getId();

        //3.Assert
        usersService.getPostById(id).assertPost(requestBody);


    }
}
