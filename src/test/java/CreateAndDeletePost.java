import Users.Create.CreatePostRequestBody;
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
        String owner = "63be862670aabb0ba84cf7a3";
        String image = "https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI";
        String text = "A beauty of a mountain";
        List<String> tags = new ArrayList<>();
        tags.add("Mountain");
        tags.add("Clouds");
        tags.add("Sky");

        CreatePostRequestBody requestBody = new CreatePostRequestBody(owner, image, text, tags);

        //2.Act
        String id = usersService.createPost(requestBody).getId();

        //3.Assert
        usersService.deletePostByID(id).assertPostDelete(id);

    }
}