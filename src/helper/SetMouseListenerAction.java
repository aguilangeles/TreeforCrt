/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Image.ImageComponent;
import VentanaCaratulas.CargarInformacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SetMouseListenerAction {

  private ImageComponent imageComponent;
  private JScrollPane scrollImage;
  private JComboBox combo;
  private JTree arbol;
  private JTable jTable2;

  public SetMouseListenerAction() {
  }

  public SetMouseListenerAction( ImageComponent imageComponent,
          JScrollPane scrollImage, JComboBox combo, JTree arbol, JTable jTable2
         ) {
    this.imageComponent = imageComponent;
    this.scrollImage = scrollImage;
    this.combo = combo;
    this.arbol = arbol;
    this.jTable2 = jTable2;
    addMSL();
  }

  private void addMSL() {
    MouseListener ml = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        llamarInfo();
      }
    };
    arbol.addMouseListener(ml);
  }

  private void llamarInfo() {

     new CargarInformacion(arbol, jTable2, imageComponent, combo, scrollImage);
  }
}
