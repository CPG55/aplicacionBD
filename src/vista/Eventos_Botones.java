package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.Aplicacion_Controlador;

/**
 * @author Carlos Pérez González. 1º DAM.
 * Clase que gestiona las acciones de los botones.
 */

class Eventos_Botones implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Objeto que almacena la identificación del botón pulsado.
        Object botonPulsado = e.getSource();
        

        //Diferenciación de acciones a desencadenar.
        if (botonPulsado == "botonInsertar") {
             System.out.println("Estas pulsando un boton de insertar");
                        
        }
        
                          
        if (botonPulsado == "botonEliminar") {
           

        }
        
        if (botonPulsado == "botonModificaPlazas") {
            
            
        }
        
        
        if (botonPulsado == "botonConsultaOpositores") {
            
            
        }
        
        if (botonPulsado == "botonConsultaCentros") {
            
            
        }
        
        if (botonPulsado == "botonSalir") {
            
            System.out.println("Estas pulsando el boton salir");
            try {                
                System.exit ( 0 );
            } catch (Exception ex) {
                System.exit(0);
            }
        }
        
    }
}

