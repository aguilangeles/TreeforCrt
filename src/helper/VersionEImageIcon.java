/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author aguilangeles@gmail.com
 */
public final class VersionEImageIcon extends JFrame {

  public static final String VERSION = "TreeCrt 1.0.02";

  public VersionEImageIcon() {
  }

  public VersionEImageIcon(JFrame frame) {
    // cambia la version y la imagen
    setImagenIcon(frame);
    frame.setTitle(VERSION);
  }

  public VersionEImageIcon(JFrame frame, String mensaje) {
    //cambia la version y permite un mensaje, y la vimagen
    setImagenIcon(frame);
    frame.setTitle(mensaje + " " + VERSION);
  }

  public Color newColor() {
    Color color = new Color(245, 235, 255);//ok
    return color;
  }

  public void setImagenIcon(JFrame frame) {
    String rutaImagen = "Logos\\nuevo logo sin letras UTN.png";
    ImageIcon im = new ImageIcon(rutaImagen);
    setIconImage(im.getImage());
    frame.setIconImage(im.getImage());
  }
}
