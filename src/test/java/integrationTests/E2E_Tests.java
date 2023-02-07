package integrationTests;

import users.BlogService;
import users.create.CreatePostRequestBody;
import users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.create.CreateUserRequestBody;

public class E2E_Tests {
    BlogService blogService;
    UsersService usersService;


    @BeforeClass
    public void beforeClass() {
        blogService = new BlogService();
        usersService = new UsersService();
    }

    @Test(description = "create user,post and delete the user and post by id")
    public void endToEndTests() {

        //1.Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();

        //2.Act
        String userId = usersService.createUser(requestBody).getId();
        CreatePostRequestBody postRequestBody = new CreatePostRequestBody.Builder().owner(userId).build();
        String id = blogService.createPost(postRequestBody).getId();

        //3. Assert
        blogService.deletePostByID(id).assertPostDelete(id);
        blogService.getDeletePost(id).assertDeletePost(404, "RESOURCE_NOT_FOUND");
        usersService.deleteUserByID(userId).assertUserDelete(userId);
        usersService.getDeletedUser(userId).assertDeletedUser(404, "RESOURCE_NOT_FOUND");


    }
}
