/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaCaratulas;

import Caratula.xml.ReporteXMlCaratula;
import VentanaCaratulas.Tif;
import helper.ConstruirRutaImagen;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Construye los hijos a partir del contenido de metadato
 * 
 * @author MUTNPROD003
 */
public class GetChildren {

  private ReporteXMlCaratula reporteCaratula;
  private DefaultMutableTreeNode nivel;
  private String status;
  private String tipo;
  private int subtipo;

  public GetChildren(DefaultMutableTreeNode nivel2, ReporteXMlCaratula reporteCaratula,
          String status, String tipo, int subtipo, List<String> imagenes, List<String> reportes, int qPapeles) {
    this.nivel = nivel2;
    this.reporteCaratula = reporteCaratula;
    this.status = status;
    this.tipo = tipo;
    this.subtipo = subtipo;
    getImage(imagenes, qPapeles, reportes);
  }
  private void getImage(List<String> lista, int papeles, List<String> lista2) {
    DefaultMutableTreeNode imagen;
    if (lista != null)
      {
      for (int i = 0; i < lista.size(); i++)
        {
        String fileName = lista.get(i);
        String metadato = getCaratula(i, papeles,lista2);
        ConstruirRutaImagen nuevaRuta = new ConstruirRutaImagen(fileName, nivel.getPath());
        Tif tif = new Tif(nuevaRuta.getOtraRuta(), fileName, metadato);
        imagen = new DefaultMutableTreeNode(tif, true);
        nivel.add(imagen);
        }
      }
  }

  private String getCaratula(int itemListaImagen, int qPapeles,List<String> lista) {
    String as = "Estado= " + status
            + " , Papeles= " + qPapeles + " "
            + getMetadatoFromCrt(lista, lista.get(itemListaImagen)).trim();
    return as.substring(0, as.length() - 1);
  }

  private String getMetadatoFromCrt(List<String> lista, String caratula) {
    String ret = "";
    List<String> caratulasC1 = reporteCaratula.getStatusCrt(lista);
    for (int i = 0; i < caratulasC1.size(); i++)
      {
      String metadato = caratulasC1.get(i);
      if (metadato.contains(caratula))
        {
        ret = reporteCaratula.getTipoYSubTipo() + " , " + metadato;
        }
      }
    return ret;
  }
}
