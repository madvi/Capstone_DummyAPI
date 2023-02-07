package users.post;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.BlogService;
import users.create.CreatePostRequestBody;

public class CreateAndGetPost {

    BlogService blogService;

    @BeforeClass
    public void beforeClass() {
        blogService = new BlogService();
    }
    @Test
    public void shouldCreatePostAndGetPostById(){

        //1.Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //2.Act
        String id = blogService.createPost(requestBody).getId();

        //3.Assert
        blogService.getPostById(id).assertPost(requestBody);


    }
}
