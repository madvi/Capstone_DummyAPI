package Users.Create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {

    private String firstName;
    private String lastName;
    private String email;

    public CreateUserRequestBody(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;

    }

    //@Builder annotation will be used instead of creating constructor to construct the variables
   /* public CreateUserRequestBody(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }*/
    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;

        public Builder() {
            this.firstName = "Vinutha";
            this.lastName = "Mahadev";
            this.email = String.format( "%s@gmail.com", UUID.randomUUID());
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public CreateUserRequestBody build(){
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);
            return createUserRequestBody;
        }
    }
}
