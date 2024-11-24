/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author Rico Hermawan
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class classKoneksi {
    Connection kon;
    public static Connection BukaKoneksi() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/inventarisbarang","root","");
            return kon;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;                    
        }
        
    }
    
}
