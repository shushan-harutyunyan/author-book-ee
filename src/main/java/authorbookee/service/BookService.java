package authorbookee.service;

import authorbookee.db.DBConnectionProvider;
import authorbookee.model.Author;
import authorbookee.model.Book;
import authorbookee.util.DateUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
   private AuthorService authorService = new AuthorService();
    public void add(Book book) {
        String sql = """
        INSERT INTO book (title, price, qty, author_id, created_at, image_name)
        VALUES ('%s', '%f', '%d', '%s', '%d', '%s');
        """.formatted(
                book.getTitle(),
                book.getPrice(),
                book.getQty(),
                book.getAuthor().getId(),
                DateUtil.fromDateToSqlDateTimeString(book.getCreatedAt()),
                book.getUser().getId(),
                book.getImageName()
        );
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                int id = generatedKeys.getInt(1);
                book.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook (String bookId){

    }

    public void print() {

    }
    public Book getBookById(String bookId){

        return null;
    }

    public void searchByName(String input){

    }
    public void searchByPrice(double min, double max){

    }

    public void searchByAuthor(Author a) {

    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * from book";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                book.setImageName(resultSet.getString("image_name"));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
