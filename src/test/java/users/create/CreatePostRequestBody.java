package users.create;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreatePostRequestBody {

    private String owner;
    private String image;
    private String text;
    private List<String> tags;


    public CreatePostRequestBody(Builder builder) {
        this.owner = builder.owner;
        this.image = builder.image;
        this.text = builder.text;
        this.tags = builder.tags;
    }

    public static class Builder{
        private String owner;
        private String image;
        private String text;
        private List<String> tags = new ArrayList<>();


        public Builder() {
            this.owner = "63be862670aabb0ba84cf7a3";//
            this.image = "https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI";
            this.text = "A beauty of a mountain";
            this.tags = getList();
        }

        public List<String> getList() {
            tags.add("Mountain");
            tags.add("Clouds");
            tags.add("Sky");
            return tags;
        }

        public Builder owner(String owner){
            this.owner = owner;
            return this;
        }
        public CreatePostRequestBody build(){
            CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody(this);
            return createPostRequestBody;
        }

    }
}
