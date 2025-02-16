package authorbookee.service;

import authorbookee.db.DBConnectionProvider;
import authorbookee.model.Author;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
//    public void add(Book book) {
//        try {
//            Statement statement = connection.createStatement();
//            String sql = """
//                    INSERT INTO user(title, author, price, qty, created_at)
//                  VALUES('%s','%s','%d','%d','%s');""".formatted(book.get());
//            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if(generatedKeys.next()){
//                int id = generatedKeys.getInt(1);
//                book.setId(id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
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

    public List<authorbookee.model.Book> getAllBooks() {
        return null;
    }
}
