package modelo;

import javax.swing.table.DefaultTableModel;

/**
 * @author Carlos Pérez González. 1º DAM.
 * Clases que construye la salida de los datos en el interfaz.
 */

public class PintarDatosTablas {
 
    public void pintarTablaOpositor() {

        DefaultTableModel modeloDeDatos = new DefaultTableModel(0, 0);
     //Hay que llenar la tabla
     
        String header[] = {
            "NIF",
            "Nombre",
            "Apellidos",
            "NotaFinal",
            "Centro asignado"
        };

        modeloDeDatos.setColumnIdentifiers(header);

    //    this.jTable1.setModel(modeloDeDatos);
        
        //Pinta cada linea de la tabla.
   /*     for (Candidato arrayCandidato : arrayCandidatos) {
            Vector<Object> data = new Vector<Object>();

            data.add(arrayCandidato.getDni());
            data.add(arrayCandidato.getNombre());
            data.add(arrayCandidato.getApellidos());
            data.add(arrayCandidato.getNotaMedia());
            data.add(arrayCandidato.getDestino());
            modeloDeDatos.addRow(data);
        }
        */

    }
    
    
}
