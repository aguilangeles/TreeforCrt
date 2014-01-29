/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Si la imagen no existe, llama a esta clase para escribir en el log y mostrar
 * una imagen recursiva
 *
 * @author aguilangeles@gmail.com
 */
public class GetFileNotFoundEx {

  public GetFileNotFoundEx() {
  }

  public GetFileNotFoundEx(String mensajeException, String descripcion) {
    escribirLog(mensajeException, descripcion);
  }

  private void escribirLog(String mensajeException, String descripcion) {
    String path = mensajeException.substring(0, mensajeException.length() - descripcion.length());
    JOptionPane.showMessageDialog(null, path, descripcion, JOptionPane.ERROR_MESSAGE);
  }

  public BufferedImage fileNotFoundImage() {
    BufferedImage image = null;
    try
      {
      image = (BufferedImage) ImageIO.read(new File("imagen-no-encontrada.jpg"));
      } catch (FileNotFoundException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Imagen recursiva no encontrada", JOptionPane.ERROR_MESSAGE);
      Logger.getLogger(GetFileNotFoundEx.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error GetFileNotFound ", JOptionPane.ERROR_MESSAGE);
      Logger.getLogger(GetFileNotFoundEx.class.getName()).log(Level.SEVERE, null, ex);
      }
    return image;
  }
}
