/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import VentanaCaratulas.IDCXCaratula;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author MUTNPROD003
 */
public class ConstruirRutaImagen {

  private TreePath rutaCompleta;
  private Object nodo;
  private String rutasSinTif;

  public ConstruirRutaImagen(TreePath rutaCompleta, Object nodo) {
    this.rutaCompleta = rutaCompleta;
    this.nodo = nodo;
  }

  public ConstruirRutaImagen(Object nodo, TreeNode[] treeNode) {
    this.nodo = nodo;
    String ruta = "";
    for (int y = 0; y < 2; y++)
      {
      ruta += treeNode[y] + File.separator;

      }
    ruta += "Imagenes" + File.separator;

    this.rutasSinTif = ruta;
  }

  public String getOtraRuta() {
    return this.rutasSinTif + this.nodo;
  }

  public String getRutaImagen() {
    String ret = "";
    for (int i = 0; i < 2; i++)
      {
        {
        ret += rutaCompleta.getPathComponent(i).toString() + File.separator;
        }
      ret += "Imagenes" + File.separator;
      ret += nodo.toString();
      }
    return ret;
  }
}
