/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class DirectorioOrdenadoOSN {

  private Map<Integer, String> mapa;
  private SortedMap mapaSorted;
  private SortedMap nombreSorted;

  public DirectorioOrdenadoOSN(String ruta) throws UnsupportedEncodingException {
    directorio(ruta);
  }

  private SortedMap directorio(String ruta) {
    mapaSorted = new TreeMap();
    nombreSorted = new TreeMap();
    int id = 0;
    File folder = new File(ruta);
    FileFilter filefilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    if (folder.exists())
      {
      File[] listOfFiles = folder.listFiles(filefilter);
      for (File f : listOfFiles)
        {
        try
          {
          String nombreSede = f.getName();
          String procesar = ruta + "/" + URLEncoder.encode(nombreSede, "UTF-8") + "/" + "Carat.xml";
          String[] spl = nombreSede.split("#");
          String finCadena = spl[3];
          if (f.getName().contains("OSN"))
            {
            id = Integer.parseInt(finCadena);
            } else if (nombreSede.contains("GND"))
            {
            String sinSl = finCadena.substring(2);
            id = Integer.parseInt(sinSl);
            }
          mapaSorted.put(id, procesar);
          nombreSorted.put(id, nombreSede);
          } catch (UnsupportedEncodingException ex)
          {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Enconding", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    return (SortedMap) mapa;
  }

  public SortedMap getNombreSorted() {
    return nombreSorted;
  }

  public void setNombreSorted(SortedMap nombreSorted) {
    this.nombreSorted = nombreSorted;
  }

  public SortedMap getMapaS() {
    return mapaSorted;
  }
}
