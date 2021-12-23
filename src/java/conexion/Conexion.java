/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Corei3
 */
public class Conexion {
    public static Conexion instancia; //singleton
    private Connection cnn;
    
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revisiones?zeroDateTimeBehavior=convertToNull", "root", "");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revisiones 260420180538?zeroDateTimeBehavior=convertToNull", "root", "");
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static Conexion saberEstado(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion(){
        instancia  = null;
    }    
    
}
