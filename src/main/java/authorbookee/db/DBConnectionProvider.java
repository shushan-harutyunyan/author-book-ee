package authorbookee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static DBConnectionProvider dbConnectionProvider = null;
    private Connection connection;
    private final String DB_URL = "jdbc:mysql://localhost:3306/book_storage_db?allowPublicKeyRetrieval=true&useSSL=false";
    private final String DB_USER = "java";
    private final String DB_PASSWORD = "password";

    private DBConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ;

    public static DBConnectionProvider getInstance() {
        if (dbConnectionProvider == null) {
            dbConnectionProvider = new DBConnectionProvider();
        }
        return dbConnectionProvider;
    }

    public Connection getConnection(){
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

