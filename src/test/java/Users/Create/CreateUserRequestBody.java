package Users.Create;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserRequestBody {

    private String firstName;
    private String lastName;
    private String email;

    public CreateUserRequestBody(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
