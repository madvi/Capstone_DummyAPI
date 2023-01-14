package Users.Post;

import Users.Create.CreatePostRequestBody;
import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreatePostResponse;
import Users.UserClient;
import Users.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class CreatePostTests {
    UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreatePost(){

        //1.Arrange
        /*String owner = "63be862670aabb0ba84cf7a3";
        String image = "https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI";
        String text =  "A beauty of a mountain";
        List<String> tags = new ArrayList<>();
        tags.add("Mountain");
        tags.add("Clouds");
        tags.add("Sky");

        //CreatePostRequestBody requestBody = new CreatePostRequestBody(owner,image,text,tags);
        CreatePostRequestBody requestBody = CreatePostRequestBody.builder().owner(owner).image(image)
                .text(text).tags(tags).build();*/

        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        CreatePostResponse createPostResponse = usersService.createPost(requestBody);

        //3.Assert
        createPostResponse.assertPost(requestBody);


    }

}
