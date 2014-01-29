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
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrador
 */
public class MapeoC4 {

  private List<String> listaReporteC4;
  private DefaultMutableTreeNode segundoNivel;
  private String ruta;
  private String status;
  private List<String> imagenC4;

  public MapeoC4(String ruta) throws IOException, SAXException {
    this.ruta = ruta;
    getValorC4();
  }

  private void getValorC4() throws IOException, SAXException {
    ReporteXMLMapeo reporteMapeo = null;
    String remplazoMapeoxCaratula = ruta.replace("Carat.xml", "Mapeo.xml");
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
      listaReporteC4 = reporteMapeo.getMapeoGetC4List();
      imagenC4 = reporteMapeo.getImagenC4();
      }
  }

  public List<String> getListaReporteC4() {
    return listaReporteC4;
  }

  public List<String> getImagenC4() {
    return imagenC4;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return imagenC4.toString();
  }
}
