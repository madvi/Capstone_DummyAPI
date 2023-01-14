package Users.Create.Response;

import Users.Create.CreatePostRequestBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GetDeletedPostResponse {
    @Setter
    private int statusCode;

    private String error;

    public void assertDeletePost(int expectedStatusCode, String expectedMessage) {
        //Assert.assertEquals(this.getError(),error);
        Assert.assertEquals(statusCode,expectedStatusCode);
        Assert.assertEquals(error,expectedMessage);

    }
}
