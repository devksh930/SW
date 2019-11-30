package DBconf;

import java.sql.*;

public class DBManager {

    public static final String databaseDriver = "com.mysql.cj.jdbc.Driver";
    public static final String databaseUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    public static final String databaseUser = "root";
    public static final String databasePassword = "1234";
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static Connection connection = null;

    public static void main(String[] args) {
        // Connection
        connect();

        // Close
        close();
    }

    public static Connection connect() {
        try {
            Class.forName(databaseDriver);
            connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
            if (connection != null) System.out.println("Connection Succeed");
            else System.out.println("Connection Failed");
        } catch (Exception e) {
            System.err.println("Connection Error! : " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Connection Closing Failed! : " + e.getMessage());
            e.printStackTrace();
        }
    }
}