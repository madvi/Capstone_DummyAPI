package Users.Create;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreatePostRequestBody {

    private String owner;
    private String image;
    private String text;
    private List<String> tags;

    public CreatePostRequestBody(String owner, String image, String text, List<String> tags) {
        this.owner = owner;
        this.image = image;
        this.text = text;
        this.tags = tags;
    }
}
