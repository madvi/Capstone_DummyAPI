package users;

import io.restassured.response.Response;
import users.create.CreatePostRequestBody;
import users.create.response.CreatePostResponse;
import users.create.response.GetDeletedPostResponse;
import users.post.getPost.DeletePostResponse;
import users.post.getPost.GetPostResponse;

public class BlogService {
    public  CreatePostResponse createPost(CreatePostRequestBody body) {
        Response response = new BlogClient().postCreate(body);
        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.statusCode());

        return createPostResponse;
    }

    public GetPostResponse getPostById(String id){

        Response response = new BlogClient().getPost(id);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);

        return getPostResponse;
    }

    public DeletePostResponse deletePostByID(String id){

        Response response = new BlogClient().deletePost(id);
        int statusCode = response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);

        return deletePostResponse;
    }

    public GetDeletedPostResponse getDeletePost(String id){

        Response response = new BlogClient().getDelete(id);
        int statusCode = response.statusCode();
        GetDeletedPostResponse getDeletedPostResponse = response.as(GetDeletedPostResponse.class);
        getDeletedPostResponse.setStatusCode(statusCode);

        return getDeletedPostResponse;
    }
}
