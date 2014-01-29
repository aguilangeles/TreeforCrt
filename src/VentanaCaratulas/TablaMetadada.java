/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaCaratulas;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author maria
 */
public class TablaMetadada extends JFrame {

    private JTable tablaMetada;
    private String metadata;

    public TablaMetadada(JTable tablaMetada, String metadata) {
        this.tablaMetada = tablaMetada;
        this.metadata = metadata;
        cargarTabla();
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = modeloDeTabla();
        TableColumn columna = tablaMetada.getColumn("Nombre");
        columna.setPreferredWidth(50);
        tablaMetada.setModel(modeloTabla);
    }

    public DefaultTableModel modeloDeTabla() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modelo.addColumn("Nombre");
        modelo.addColumn("Valor");
        cargarInfo(modelo, metadata);
        return modelo;
    }

    private void cargarInfo(DefaultTableModel modelo, String metadata) {
        String[] filas = metadata.split(" , ");
        for (int o = 0; o < filas.length; o++) {
            String fila = filas[o];
            String[] columnas = fila.split("= ");
            modelo.addRow(columnas);
        }

    }

}
