package authorbookee.model;
import lombok.*;

import java.util.Date;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
    private String id;
    private String title;
    private Author author;
    private double price;
    private int qty;
    private Date createdAt;


}
