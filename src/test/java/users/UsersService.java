package users;

import users.create.CreatePostRequestBody;
import users.create.CreateUserRequestBody;
import users.create.response.CreatePostResponse;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.create.response.GetDeletedPostResponse;
import users.get.GetAllUserResponseByMyAccount;
import users.get.GetAllUsers;
import users.post.getPost.DeletePostResponse;
import users.post.getPost.GetPostResponse;
import io.restassured.response.Response;

public class UsersService {
    public static CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = new UserClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public static CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = new UserClient().create(body);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }

    public static GetAllUsers getUser() {
        Response response = new UserClient().getAllUser();
        int statusCode = response.statusCode();
        GetAllUsers getAllUsers = response.as(GetAllUsers.class);
        getAllUsers.setStatusCode(statusCode);

        return getAllUsers;

    }

    public static GetAllUserResponseByMyAccount getUsersByAccount(){
        Response response = new UserClient().getUserByAccount();
        int statusCode = response.statusCode();
        GetAllUserResponseByMyAccount getAllUserResponseByMyAccount =  response.as(GetAllUserResponseByMyAccount.class);
        getAllUserResponseByMyAccount.setStatusCode(statusCode);

        return getAllUserResponseByMyAccount;

    }

    public static CreatePostResponse createPost(CreatePostRequestBody body) {
        Response response = new UserClient().postCreate(body);
        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.statusCode());

        return createPostResponse;
    }

    public GetPostResponse getPostById(String id){

        Response response = new UserClient().getPost(id);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);

        return getPostResponse;
    }

    public DeletePostResponse deletePostByID(String id){

        Response response = new UserClient().deletePost(id);
        int statusCode = response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);

        return deletePostResponse;
    }

    public GetDeletedPostResponse getDeletePost(String id){

        Response response = new UserClient().getDelete(id);
        int statusCode = response.statusCode();
        GetDeletedPostResponse getDeletedPostResponse = response.as(GetDeletedPostResponse.class);
        getDeletedPostResponse.setStatusCode(statusCode);

        return getDeletedPostResponse;
    }
}
