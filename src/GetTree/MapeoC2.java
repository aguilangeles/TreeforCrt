/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTree;

import Entidades.XmlMapeo;
import Mapeo.xml.MapeoList;
import Mapeo.xml.ReporteXMLMapeo;
import Mapeo.xml.XmlMapeoParser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrador
 */
public class MapeoC2  {

  private List<String> listaReporteC2;
  private List<String> imagenC2;
  private String ruta;
  private int papeles;
  private ReporteXMLMapeo reporteMapeo = null;

  public MapeoC2(String ruta) throws IOException, SAXException {
    this.ruta = ruta;
    setValorC2();
  }

  private void setValorC2() throws IOException, SAXException {

      String remplazoMapeoxCaratula = ruta.replace("Carat.xml", "Mapeo.xml");
      XmlMapeoParser mapeoParser = new XmlMapeoParser(remplazoMapeoxCaratula);
      NodeList xmlMapeoNodeChildren = mapeoParser.getXmlMapeoNode().getChildNodes();
      XmlMapeo xmlMapeo = new XmlMapeo(mapeoParser.getXmlMapeoNode().getChildNodes());
      xmlMapeo.setMapeoLists(mapeoParser.getMapeoLists());
      for (int e = 0; e < mapeoParser.getMapeoLists().getLength(); e++)
        {
        Node mapeoListNode = mapeoParser.getMapeoLists().item(e);
        NodeList mapeoChildren = mapeoListNode.getChildNodes();
        MapeoList mapeoList = new MapeoList(mapeoChildren);//
        //por cada iteracion un reporte de su contenido

        reporteMapeo = mapeoParser.getReporte();

        papeles = xmlMapeo.cantidadPapeles();
        listaReporteC2 = reporteMapeo.getMapeoGetC2List();
        imagenC2 = reporteMapeo.getImagenC2();
        }

  }

  public ReporteXMLMapeo getReporteMapeo() {
    return reporteMapeo;
  }

  public List<String> getListaReporteC2() {
    return listaReporteC2;
  }

  public List<String> getImagenC2() {
    return imagenC2;
  }

  public int getPapeles() {
    return papeles;
  }
}
