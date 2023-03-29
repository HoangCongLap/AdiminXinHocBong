package xinhocbong.database;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    public static Connection conn = null;

    static {
        conn = connectdb();
    }

    public static Connection connectdb() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingapp?autoReconnect=true&useSSL=false", "root", "11112222");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xhb?autoReconnect=true&useSSL=false", "root", "11112222");
//            JOptionPane.showConfirmDialog(null, "ConnectionEstablished");
            return conn;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return null;
        }
    }

}
