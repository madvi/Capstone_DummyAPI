package Users.Post.GetPost;

import Users.Create.CreatePostRequestBody;
import Users.Create.CreateUserRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
public class GetPostResponse {


    @Setter
    private int statusCode;

    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String updatedDate;
    private String likes;

    private List<String> tags;

    public void assertPost(CreatePostRequestBody requestBody) {
        //Assert.assertEquals(owner,requestBody.getOwner().());
        Assert.assertEquals(image,requestBody.getImage());
        Assert.assertEquals(tags,requestBody.getTags());
        Assert.assertEquals(text,requestBody.getText());
    }



    @Getter
    public static class Owner {
        private String firstName;
        private String lastName;
        private String id;
    }
}
