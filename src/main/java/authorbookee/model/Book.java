package authorbookee.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private String id;
    private String title;
    private Author author;
    private double price;
    private int qty;
    private Date createdAt;


}
