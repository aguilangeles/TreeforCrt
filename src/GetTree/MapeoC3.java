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
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrador
 */
public class MapeoC3 {

  private List<String> listaReporteC3;
  private DefaultMutableTreeNode segundoNivel;
  private String ruta;
  private List<String> imagenC3;

  public MapeoC3(String ruta) throws IOException, SAXException {
    this.ruta = ruta;
    getValorC3();
  }

  public void getValorC3() throws IOException, SAXException {
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
      listaReporteC3 = reporteMapeo.getMapeoGetC3List();
      imagenC3 = reporteMapeo.getImagenC3();
      }
  }

  public List<String> getListaReporteC3() {
    return listaReporteC3;
  }

  public List<String> getImagenC3() {
    return imagenC3;
  }
}
