package Hw7;

import java.sql.*;

public class BineetDB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String dbDirectory = "/Users/pengyiying/GoogleDrive/UCSC/Spring_2019/Java_Programming_Comprehensive/others/JavaProgrammingComprehensive/lib/BineetDB";
            System.setProperty("derby.system.home", dbDirectory);

            String url = "jdbc:derby:BineetDB";
            String username = "";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            for (Throwable t : e)
                t.printStackTrace();
            return null;
        }
    }
}