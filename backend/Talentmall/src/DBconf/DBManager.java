/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/20
        Info: DATBASE CONNECTION, CLOSE OBJECT
        version: CURRENT VERSION 3.0.0   make AZURE MYSQL SERVER PATH        ||  1.0.0 make class -> connect local DB  || 1.5.0 make connect || 2.0.0  make close
        Class: DBManager
        Time: 01:02 오전
        To change this template use File | Settings | File Templates.
        */
package DBconf;

import java.sql.*;

public class DBManager {

    public static final String databaseDriver = "com.mysql.cj.jdbc.Driver";
    public static final String databaseUrl = "jdbc:mysql://market-db-server.mysql.database.azure.com:3306/mydb?useSSL=true&requireSSL=false";
    public static final String databaseUser = "marketroot@market-db-server";
    public static final String databasePassword = "DBscore100";
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static Connection connection = null;

    public static void main(String[] args) {
        /* Connection TEST
        connect();

        // Close TEST
        close();
         */
    }


    public static Connection connect() { //DB CONNECT
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

    public static void close() { //DB USE AFTER CLOSE
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