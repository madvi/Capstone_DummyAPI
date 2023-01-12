package Users.Post;

import Users.Create.CreatePostRequestBody;
import Users.Create.Response.CreatePostResponse;
import Users.UserClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class CreatePostTests {
    UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void shouldCreatePost(){

        String owner = "63be862670aabb0ba84cf7a3";
        String image = "https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI";
        String text =  "A beauty of a mountain";
        List<String> tags = new ArrayList<>();
        tags.add("Mountain");
        tags.add("Clouds");
        tags.add("Sky");

        CreatePostRequestBody requestBody = new CreatePostRequestBody(owner,image,text,tags);

        CreatePostResponse createPostResponse = userClient.createPost(requestBody);
        createPostResponse.assertPost(requestBody);


    }

}
