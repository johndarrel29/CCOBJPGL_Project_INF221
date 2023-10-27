package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    
    public static Connection DBConnect(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/momentum", "root", "");
            System.out.println("connected na yung database");
    
            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}