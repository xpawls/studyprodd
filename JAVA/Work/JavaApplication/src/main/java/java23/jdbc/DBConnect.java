package java23.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ConnectionFeatureNotAvailableException;

public class DBConnect {
    public static java.sql.Connection connectionMySQL(){
        String url = "jdbc:mysql://localhost:3306/book_db";
        String user = "root";
        String password = "1234";
        java.sql.Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //drive 적재
            conn = java.sql.DriverManager.getConnection(url, user, password);// DB연결
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return conn;
    }
    public static java.sql.Connection makeConnection(){
        return connectionMySQL(); // Oracle 과 연결할 때
    }
}
