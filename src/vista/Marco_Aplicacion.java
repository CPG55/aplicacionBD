package vista;

import javax.swing.*;
import java.awt.*;

/**
 * @author Carlos Pérez González. 1º DAM.
 * Clases que construyen la Interfaz Gráfica.
 */

public class Marco_Aplicacion extends JFrame {

    //Constructor de la ventana de la aplicacion.
    public Marco_Aplicacion() {

        //Titulo, posicionamiento en pantalla, tamaño y Layout (distribucion).
        setTitle("Aplicación BDD Oposición");
        setBounds(550, 150, 900, 550);
        setLayout(new BorderLayout());

        //Crear zona de menu.
        LaminaBotonesMenu miMenu = new LaminaBotonesMenu();
        //Añadir menu al marco.
        add(miMenu , BorderLayout.CENTER);
        
        //Crear zona de texto.
        LaminaTexto miTexto = new LaminaTexto();
        //Añadir zona de resultados al marco.
        add(miTexto , BorderLayout.WEST);
    }
}

class LaminaBotonesMenu extends JPanel {

    //Constructor del panel derecho con botones.
    public LaminaBotonesMenu() {        
        
        //Tipo de Layout.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Crear un borde para la lamina.Así queda más bonito (y veo como es el JPanel creado).
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                                                   "Menú de la Aplicación"));
              
        
        //Crear botones.
        JButton botonInsertar = new JButton ("Insertar Opositor.");
        JButton botonEliminar = new JButton ("Eliminar Opositor.");
        JButton botonModificaPlazas = new JButton ("Modificar Plazas Centro");
        JButton botonConsultaOpositores = new JButton ("Listar Opositores");
        JButton botonConsultaCentros = new JButton ("Listar Centros");
        JButton botonSalir = new JButton ("Salir de la Aplicación");
        
        //Tamaño de botones, seguro que hay una forma mejor que esto. La hay, usar otro layout, gridlayout.
        botonInsertar.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonInsertar.getMinimumSize().height));
        botonEliminar.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonEliminar.getMinimumSize().height));
        botonModificaPlazas.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonModificaPlazas.getMinimumSize().height));
        botonConsultaOpositores.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonConsultaOpositores.getMinimumSize().height));
        botonConsultaCentros.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonConsultaCentros.getMinimumSize().height));
        botonSalir.setMaximumSize(new Dimension(Integer.MAX_VALUE, botonSalir.getMinimumSize().height));
      
        
        //Añadir Botones a la lamina.
        add(botonInsertar);
        add(botonEliminar);
        add(botonModificaPlazas);
        add(botonConsultaOpositores);
        add(botonConsultaCentros);
        add(Box.createVerticalGlue()); //Espaciar botones.
        add(botonSalir);
        
        //Poner los botones a la escucha. Objeto que recibe evento.
        Eventos_Botones miEventoBoton = new Eventos_Botones();
        //Añadir Listeners para botones.
        botonInsertar.addActionListener(miEventoBoton);
        botonEliminar.addActionListener(miEventoBoton);
        botonModificaPlazas.addActionListener(miEventoBoton);
        botonConsultaOpositores.addActionListener(miEventoBoton);
        botonConsultaCentros.addActionListener(miEventoBoton);
        botonSalir.addActionListener(miEventoBoton);
    }
}


class LaminaTexto extends JPanel {
    //Constructor del panel izquierdo, zona de resultados con scroll.
    public LaminaTexto() {
        
        //Crear un borde para la lamina.
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                                                   "Resultados de las consultas:"));
        
        //Zona de texto. Con tamaño fijo y scroll.
        JTextArea miAreaDeTexto = new JTextArea(30,50);
        JScrollPane miAreaDeTextoConScroll = new JScrollPane(miAreaDeTexto);      
        //Añadir el area creada a la lamina.
        add(miAreaDeTextoConScroll);    
    }
}