/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaCaratulas;

import Image.ImageComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class CargarInformacion {

  private JTree jTree1;
  private JTable tablaFinal;
  private Image.ImageComponent icomp;
  private JComboBox combo;
  private JScrollPane scrollImagen;

  public CargarInformacion() {
  }

  public CargarInformacion(JTree jTree1, JTable tablaFinal, ImageComponent icomp, JComboBox combo, JScrollPane scrollImagen) {
    this.jTree1 = jTree1;
    this.tablaFinal = tablaFinal;
    this.icomp = icomp;
    this.combo = combo;
    this.scrollImagen = scrollImagen;
    cargarInformacion();
  }


  private void cargarInformacion() {
    TreePath selPath = jTree1.getSelectionPath();
    if (selPath != null)
      {
      try
        {
        String ruta = (selPath.toString());
        DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (nodoSeleccionado.toString().endsWith(".tif"))
          {
          Tif tif = (Tif) nodoSeleccionado.getUserObject();
          String imagen = tif.getRuta();
          if (imagen != null)
            {
            setImage(imagen);
            TablaMetadada tabla = new TablaMetadada(tablaFinal, tif.getMetadata());
            }
          }
        } catch (Exception ex)
        {
        Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
        }

      } else
      {
      System.out.println("seleccione una hoja");
      }
  }

  private void setImage(String imagen) throws Exception {
    icomp.cargarImagen(imagen, combo, scrollImagen);
    scrollImagen.getViewport().add(icomp);
  }
}
