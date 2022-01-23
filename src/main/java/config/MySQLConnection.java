package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            //driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/baitap2_hangkhong", "thien", "thien123456789");
            // here baitap2_hangkhong is database name, root is username and password
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return con;
    }
}