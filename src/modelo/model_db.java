package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class model_db {
    
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password ="";
    private final String url = "jdbc:mysql://127.0.0.1:3306/automotor";
    Connection connect;
        
    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
    
    

    
    
    


}
