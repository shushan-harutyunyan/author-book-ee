package authorbookee.model;
import lombok.*;

import java.util.Date;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
    private int id;
    private String title;
    private Author author;
    private double price;
    private int qty;
    private Date createdAt;
    private User user;
    private String imageName;

    public Book(String title, Author author, double price, int qty, Date createdAt, User user, String imageName) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
        this.createdAt = createdAt;
        this.user = user;
        this.imageName = imageName;
    }
}
