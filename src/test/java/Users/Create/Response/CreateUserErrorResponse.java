package Users.Create.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class CreateUserErrorResponse {

    @Setter
    private int statusCode;
    private String error;
    //private String data;



   @JsonProperty("data")
    private Data data;

    @Getter
    public static class Data {

        private String email;
        private String firstName;
        private String lastName;
    }
}
