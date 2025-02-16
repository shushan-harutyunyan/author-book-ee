package authorbookee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;

}