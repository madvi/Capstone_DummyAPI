package users.post;

import users.BlogService;
import users.create.CreatePostRequestBody;
import users.create.response.CreatePostResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreatePostTests {
    BlogService blogService;

    @BeforeClass
    public void beforeClass() {
        blogService = new BlogService();
    }

    @Test
    public void shouldCreatePost(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        CreatePostResponse createPostResponse = blogService.createPost(requestBody);

        //3.Assert
        createPostResponse.assertPost(requestBody);


    }

}
