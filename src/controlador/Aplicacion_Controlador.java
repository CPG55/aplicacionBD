package controlador;

import java.util.Scanner;
import javax.swing.JFrame;
import vista.Marco_Aplicacion;
import modelo.EjecutaConsulta;

/**
 * @author Carlos Pérez González. 1º DAM.
 * Clase iniciadora de la aplicación.
 */

public class Aplicacion_Controlador {

    public static void main(String[] args) {
        
        EjecutaConsulta basedatos = new EjecutaConsulta();
        Scanner intro = new Scanner(System.in);
        
        //Crear objeto JFrame
        JFrame miMarcoAplicacion = new Marco_Aplicacion();
        //Definir cierre.
        miMarcoAplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Hacerlo visible.
        miMarcoAplicacion.setVisible(true);
        
        
        //MENU        
        int opcion;

        do {
            System.out.println("BASE DE DATOS OPOSITORES Y CENTROS");
            System.out.println("==================================");
            System.out.println("1. Insertar un nuevo opositor desde teclado.");
            System.out.println("2. Eliminar un opositor introduciendo su DNI.");
            System.out.println("3. Modificar el número de plazas disponibles de un Centro.");
            System.out.println("4. Mostrar por pantalla la lista de opositores ordenados por DNI.");
            System.out.println("5. Mostrar por pantalla la lista de centros.");
            System.out.println("6. Salir");
            System.out.println("Introduce opcion: ");

            opcion = intro.nextInt();

            switch (opcion) {
                case 1:
                    basedatos.insertarOpositor();                    
                    break;
                case 2:                   
                    basedatos.eliminarOpositor();                    
                    break;
                case 3:                    
                    basedatos.actualizarPlazasCentro();                    
                    break;
                case 4:
                    basedatos.consultarOpositores();                    
                    break;
                case 5:
                    basedatos.consultaCentros();
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción incorrecta\n");
                    break;
            }
        } while (opcion != 6);    
        
    }
}
