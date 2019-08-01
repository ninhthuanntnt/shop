/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBUtil {
    public static Connection openConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String info = "user=root&password=Thuanthuc123";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shopdb?" + info);

        return con;
    }
}
