package users.create.response;

import users.create.CreatePostRequestBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

@Getter
public class CreatePostResponse {

    @Setter
    private int statusCode;

    private String id;
    private String image;
    private String likes;
    private String link;
    private String text;
    private String publishDate;
    private String updatedDate;
    private List<String> tags;
    private Map<String,String> owner;

    public void assertPost(CreatePostRequestBody requestBody) {
        Assert.assertEquals(this.getStatusCode(),200);
        Assert.assertNotNull(this.getId());
       /* Assert.assertEquals(this.getImage(),requestBody.getImage());
        Assert.assertEquals(this.getText(),requestBody.getText());
        Assert.assertEquals(this.getOwner(),requestBody.getOwner());
        Assert.assertEquals(this.getUpdatedDate(),requestBody.getTags());*/

    }
}
