package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Carlos Pérez González. 1º DAM.
 * 
 */

public class Conexion {

    //Inicializar una variable para contener la conexión de retorno.
    Connection miConexion = null;

    public Connection dameConexion() {
        
        try {
            // Conectar.
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/oposicion", "root", "");

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            //e.printStackTrace();
        }

        return miConexion;

    }


    
}
