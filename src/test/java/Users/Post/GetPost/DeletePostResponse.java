package Users.Post.GetPost;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class DeletePostResponse {

    @Setter
    private int statusCode;

    private String id;

    public void assertPostDelete(String id) {
        Assert.assertEquals(this.getId(),id);
    }
}
