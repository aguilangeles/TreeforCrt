/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaCaratulas;

import GetTree.GetCaratulasTree;
import helper.DirectorioOrdenadoOSN;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.SortedMap;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author MUTNPROD003
 */
public class Integrador extends SwingWorker<Void, Integer> {

  private IDCXCaratula principal;
  private OutPutFile out;
  private DefaultMutableTreeNode root;
  private String rutaInput;
  private JTextArea infoMeta;
  private File dir;
  private FileFilter fileFilter;

  public Integrador(DefaultMutableTreeNode root, String rutaInput) {
    this.root = root;
    this.rutaInput = rutaInput;
  }

  public Integrador(IDCXCaratula principal, OutPutFile out, DefaultMutableTreeNode root, String rutaInput, File dir, FileFilter fileFilter) {
    this.principal = principal;
    this.out = out;
    this.root = root;
    this.rutaInput = rutaInput;
    this.dir = dir;
    this.fileFilter = fileFilter;
  }

  public Integrador() {
  }

  @Override
  protected Void doInBackground() throws Exception {
    DirectorioOrdenadoOSN orden = new DirectorioOrdenadoOSN(rutaInput);
    SortedMap mapa = orden.getMapaS();
    Iterator it = mapa.keySet().iterator();
    while (it.hasNext())
      {
      Object key = it.next();
      String rutaProcesada = (String) mapa.get(key);
      GetCaratulasTree caratulaTree = new GetCaratulasTree(rutaProcesada, root);
      }
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      String mensaje = ("La construcción del Arbol ha finalizado\n"
              + "Aceptar para mostrar la Ventana Principal");
      JOptionPane.showMessageDialog(principal, mensaje);
      out.dispose();
      principal.setVisible(true);
      }
  }
}
