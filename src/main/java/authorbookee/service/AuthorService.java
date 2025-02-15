package authorbookee.service;

import authorbookee.db.DBConnectionProvider;
import authorbookee.model.Author;
import authorbookee.model.Gender;
import authorbookee.util.DateUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AuthorService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    public void add(Author author) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO author(name, surname, phone, dob, gender) VALUES('" + author.getName() + "','" + author.getSurname() + "','" + author.getPhone() + "','" + author.getDateOfBirth() + "','" + author.getGender() + "')";
            String sql = String.format(query, author.getName(), author.getSurname(), author.getPhone(), author.getDateOfBirth(), author.getGender().name());
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                int id = generatedKeys.getInt(1);
                author.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Author> getAllAuthors(){

        String sql = "SELECT * FROM author";
        Statement statement = null;
        List<Author> result = new ArrayList<>();
        try {
            statement = connection.createStatement();
            if (connection == null) {
                System.out.println("Database connection is not established.");
                throw new SQLException("Database connection is not established.");
            }
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String dob = resultSet.getString("dob");
                String gender = resultSet.getString("gender");
                Author author = null;
                try {
                    author = new Author(id, name, surname, phone, DateUtil.fromSqlStringToDate(dob), Gender.valueOf(gender));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                result.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Author getAuthorById(int id){
        String sql = "SELECT * FROM author WHERE ID = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String dob = resultSet.getString("dob");
                String gender = resultSet.getString("gender");
                Author author = new Author(name, surname, phone, dob, Gender.valueOf(gender));
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Author getAuthorByName(String authorName){

        return null;
    }
    public void deleteAuthorById(int id) {
        if (getAuthorById(id) == null) {
            System.out.println("does not exist");
            return;
        }
        String sql = "DELETE FROM author WHERE id = " + id;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("removed");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateAuthor (Author author){
        if (getAuthorById(author.getId()) == null){
            System.out.println("Author with " + author.getId() + " does not exist");
            return;
        }
        String query = "UPDATE author SET name = '%s', surname = '%s', phone = '%s', dob = '%d', gender='%s' WHERE id='%d'";
        String sql = String.format(query, author.getName(), author.getSurname(), author.getPhone(), author.getDateOfBirth(), author.getGender());
        System.out.println(sql);
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
