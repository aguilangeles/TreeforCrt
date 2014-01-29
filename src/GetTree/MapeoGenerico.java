/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTree;

import Entidades.XmlMapeo;
import Mapeo.xml.MapeoList;
import Mapeo.xml.ReporteXMLMapeo;
import Mapeo.xml.XmlMapeoParser;
import VentanaCaratulas.IDCXCaratula;
import VentanaCaratulas.IDCXCaratula;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class MapeoGenerico {

  protected List<String> imageFromCrt;
  protected int cantidadPapeles;
  protected String path;
  private ReporteXMLMapeo reporteMapeo = null;
  protected List<String> reporteCrtList;

  public MapeoGenerico(String ruta) {
    this.path = ruta;
  }

  protected void setvalueCrt() {
    try
      {
      String remplazoMapeoxCaratula = path.replace("Carat.xml", "Mapeo.xml");
      XmlMapeoParser mapeoParser = new XmlMapeoParser(remplazoMapeoxCaratula);
      NodeList xmlMapeoNodeChildren = mapeoParser.getXmlMapeoNode().getChildNodes();
      XmlMapeo xmlMapeo = new XmlMapeo(mapeoParser.getXmlMapeoNode().getChildNodes());
      xmlMapeo.setMapeoLists(mapeoParser.getMapeoLists());
      for (int e = 0; e < mapeoParser.getMapeoLists().getLength(); e++)
        {
        Node mapeoListNode = mapeoParser.getMapeoLists().item(e);
        NodeList mapeoChildren = mapeoListNode.getChildNodes();
        MapeoList mapeoList = new MapeoList(mapeoChildren);
        reporteMapeo = mapeoParser.getReporte();
        reporteCrtList = reporteMapeo.getMapeoGetC1List();
        cantidadPapeles = xmlMapeo.cantidadPapeles();
        imageFromCrt = reporteMapeo.getImagenC1();
        }
      } catch (IOException | SAXException ex)
      {
      Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public ReporteXMLMapeo getReporteMapeo() {
    return reporteMapeo;
  }


  public List<String> getImageFromCrt() {
    return imageFromCrt;
  }

  public int getCantidadPapeles() {
    return cantidadPapeles;
  }

  public String getPath() {
    return path;
  }

  public List<String> getReporteCrtList() {
    return reporteCrtList;
  }

  @Override
  public String toString() {
    return  imageFromCrt.toString();
  }

}
