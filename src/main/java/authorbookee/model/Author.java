package authorbookee.model;

import lombok.*;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    int id;
    private String name;
    private String surname;
    private String phone;
    private Date dateOfBirth;
    private Gender gender;

    public Author(String name, String surname, String phone, String dob, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirth = new Date(Long.parseLong(dob));
        this.gender = gender;
    }
    public Author(int id, String name, String surname, String phone, String dob, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirth = new Date(Long.parseLong(dob));
        this.gender = gender;
    }
    public void print(){
        System.out.println(this);
    }
}