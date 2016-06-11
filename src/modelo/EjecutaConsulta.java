package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Carlos Pérez González. 1º DAM.
 * Clase que gestiona las acciones sobre la base de datos.
 */

public class EjecutaConsulta {
    
    private Statement conexionBD() {
        Statement miStatement = null;
        try {
            // 1. Crear conexion.
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/oposicion", "root", "");

            // 2. Crear Objeto Statement para realizar consultas.
            miStatement = miConexion.createStatement();

            // 3. Crear Resulset.
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            //e.printStackTrace();
        }
        return miStatement;
    }

    public void insertarOpositor() {
        
        //Pedir nuevos datos.
        String nif = JOptionPane.showInputDialog("Introduzca NUEVO NIF: ");
        String nombre = JOptionPane.showInputDialog("Introduzca NUEVO Nombre: ");                    
        String apellidos = JOptionPane.showInputDialog("Introduzca NUEVOS Apellidos: ");                    
        float nota = Float.parseFloat(JOptionPane.showInputDialog("Introduzca NUEVA Nota: "));
        String pref1 = JOptionPane.showInputDialog("Introduzca Preferencia de Centro:");
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Confirma los datos?");
        
        if (confirmar == JOptionPane.YES_OPTION) {
            //Ejecutar conexión y sentencia MySQL.
            try {
                Statement miStatement = conexionBD();
                miStatement.execute("INSERT INTO oposicion.opositores"
                        + " (nif, nombre, apellidos, nota) VALUES ('" + nif + "','"
                        + nombre + "','" + apellidos + "'," + nota + ")");

                JOptionPane.showMessageDialog(null, "Se ha insertado con éxito!!!");

            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.toString());
            }
        } else {            
            JOptionPane.showMessageDialog(null,"Operación cancelada" );
        }
        
    }

    public void eliminarOpositor() {
        
        //Pedir NIF Opositor para eliminar.
        String nif = JOptionPane.showInputDialog("Introducir NIF a eliminar: ");
        
        //Ejecutar conexión y sentencia MySQL.
        try {
            Statement miStatement = conexionBD();
            miStatement.execute("DELETE FROM OPOSITORES WHERE nif='" + nif + "';");
            
         //   JOptionPane.showMessageDialog(null, "Se ha eliminado con éxito!!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado nada." + 
                                                "\nSQL Exception: " + e.toString());
            
        }
    }

    public void actualizarPlazasCentro() {

        //Pedir codigo CENTRO y PLAZAS a ACTUALIZAR.
        String cod_centro = JOptionPane.showInputDialog("Introduzca codigo del centro");       
        int plazasCentro = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número de plazas"));
       
        //Ejecutar conexión y sentencia MySQL.
        try {
            Statement miStatement = conexionBD();
            miStatement.execute("UPDATE oposicion.centros SET plazas=" + plazasCentro + " WHERE cod_centro=" + cod_centro + ";");
            
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            
        }
    }

    public void consultaCentros() {

        try {
            Statement miStatement = conexionBD();
            // 3. Crear Resulset.
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM oposicion.centros");

            // 4. Recorrer ResultSet.            
            while (miResultSet.next()) {
                String nombre = miResultSet.getString(2);
                String localidad = miResultSet.getString(3);
                String provincia = miResultSet.getString(4);
                int plazas = miResultSet.getInt(5);
                System.out.println(nombre + " " + localidad + " " + provincia + " " + plazas);
            }
            //Cerrar ResulSet.
            miResultSet.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }
    }

    public void consultarOpositores() {

        try {
            Statement miStatement = conexionBD();
            // 3. Crear Resulset.
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM oposicion.opositores ORDER BY nif");

            // 4. Recorrer ResultSet.     
            while (miResultSet.next()) {
                String nif = miResultSet.getString(1);
                String nombre = miResultSet.getString(2);
                String apellidos = miResultSet.getString(3);
                float nota = miResultSet.getFloat(4);

                System.out.println(nif + " " + nombre + " " + apellidos + " " + nota);
            }

            //Cerrar ResulSet.
            miResultSet.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            //e.printStackTrace();
        }
    }
    /*
    public ResultSet consultarListaOpositores() {
        
        Conexion con = con.dameConexion();
        
        try {
            Statement miStatement = conexionBD();
            // 3. Crear Resulset.
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM oposicion.opositores ORDER BY nif");

            // 4. Recorrer ResultSet.     
            while (miResultSet.next()) {
                String nif = miResultSet.getString(1);
                String nombre = miResultSet.getString(2);
                String apellidos = miResultSet.getString(3);
                float nota = miResultSet.getFloat(4);

                System.out.println(nif + " " + nombre + " " + apellidos + " " + nota);
                
            }

            //Cerrar ResulSet.
            miResultSet.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            //e.printStackTrace();
        }
        
        
    }*/    
}
