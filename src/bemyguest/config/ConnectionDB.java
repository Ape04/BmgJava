/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    static public Connection connection;
 String url = "jdbc:mysql://localhost:3306/sprintweb";
            String user = "root";
            String pwd = "";
            
    
    public ConnectionDB() {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Connection getConnexion(){
    if(connection == null){
    
    new ConnectionDB();
    return connection;
    }else{
        return connection;
    }
    }

}
