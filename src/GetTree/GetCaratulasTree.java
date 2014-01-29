/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTree;

import GetTree.MapeoC1;
import Entidades.Caratula;
import Entidades.Metadato;
import Caratula.xml.CaratulaParser;
import Caratula.xml.ReporteXMlCaratula;
import VentanaCaratulas.GetChildren;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrador
 */
public class GetCaratulasTree extends JFrame {

  private DefaultMutableTreeNode root;
  private String rutaProcesada;
//  private String rootIDC;
  private static MapeoC1 mapeoC1;
  private static MapeoC2 mapeoC2;
  private static MapeoC4 mapeoC4;
  private static int subTipo;
  private static String getStatusFromCaratulas;
  private static String tipoDoc;
  private static MapeoC3 mapeoC3;

  public GetCaratulasTree(String rutaProcesada, DefaultMutableTreeNode root) {
    this.rutaProcesada = rutaProcesada;
    this.root = root;
    construirArbol();
  }



  private void construirArbol() {
    String rootIDC = null;
    try
      {
      CaratulaParser caratulaParser = new CaratulaParser(rutaProcesada);
      mapeoC1 = new MapeoC1(rutaProcesada);
      mapeoC2 = new MapeoC2(rutaProcesada);
      mapeoC3 = new MapeoC3(rutaProcesada);
      mapeoC4 = new MapeoC4(rutaProcesada);
      ReporteXMlCaratula reporteCaratula = caratulaParser.getReporte();
      NamedNodeMap caratulaNodeMap = caratulaParser.getCaratulas();
      for (int a = 0; a < caratulaNodeMap.getLength(); a++)
        {
        Node caratulaNode = caratulaNodeMap.item(a);
        NodeList caratulaChildren = caratulaNode.getChildNodes();
        Caratula caratula = new Caratula(caratulaChildren);
        Metadato metadato = caratula.getMetadato();
        rootIDC = caratula.getIdIDC();
        getStatusFromCaratulas = caratula.getStatus();
        tipoDoc = caratula.getDocType();
        subTipo = caratula.getSubTypeCode();
        }
      DefaultMutableTreeNode idcStatus = new DefaultMutableTreeNode(rootIDC, true);
      root.add(idcStatus);
      if (!mapeoC4.getImagenC4().isEmpty())
        {
        construirNivelCuatro(idcStatus, reporteCaratula);
        } else if (!mapeoC3.getImagenC3().isEmpty())
        {
        construirNivelTres(idcStatus, reporteCaratula);
        } else if (!mapeoC2.getImagenC2().isEmpty())
        {
        constuirNivelDos(idcStatus, reporteCaratula);
        } else if (!mapeoC1.getImageFromCrt().isEmpty())
        {
        constuirPriverNivel(idcStatus, reporteCaratula);
        }

      } catch (SAXException ex)
      {
      System.out.println(ex.getMessage());
      } catch (IOException ex)
      {
      System.out.println(ex.getMessage());
      }
  }

  private void construirNivelCuatro(DefaultMutableTreeNode idcStatus, ReporteXMlCaratula reporteCaratula) {
    DefaultMutableTreeNode tituloNivel4 = new DefaultMutableTreeNode("C4", true);
    idcStatus.add(tituloNivel4);//
    //
    GetChildren mCuatro = new GetChildren(tituloNivel4,
            reporteCaratula, getStatusFromCaratulas, tipoDoc, subTipo,
            mapeoC4.getImagenC4(), mapeoC4.getListaReporteC4(), 0);
    construirNivelTres(tituloNivel4, reporteCaratula);
  }

  private void construirNivelTres(DefaultMutableTreeNode idcStatus, ReporteXMlCaratula reporteCaratula) {
    DefaultMutableTreeNode tituloNivel3 = new DefaultMutableTreeNode("C3", true);
    idcStatus.add(tituloNivel3);
    GetChildren nTres = new GetChildren(tituloNivel3,
            reporteCaratula, getStatusFromCaratulas, tipoDoc, subTipo,
            mapeoC3.getImagenC3(), mapeoC3.getListaReporteC3(), 0);
    constuirNivelDos(tituloNivel3, reporteCaratula);
  }

  private void constuirNivelDos(DefaultMutableTreeNode idcStatus, ReporteXMlCaratula reporteCaratula) {
    DefaultMutableTreeNode tituloNivel2 = new DefaultMutableTreeNode("C2", true);
    idcStatus.add(tituloNivel2);
    //
    GetChildren nDos = new GetChildren(tituloNivel2,
            reporteCaratula, getStatusFromCaratulas, tipoDoc, subTipo,
            mapeoC2.getImagenC2(), mapeoC2.getListaReporteC2(), mapeoC2.getPapeles());
    constuirPriverNivel(tituloNivel2, reporteCaratula);
  }

  private void constuirPriverNivel(DefaultMutableTreeNode idcStatus, ReporteXMlCaratula reporteCaratula) {
    DefaultMutableTreeNode tituloNivel1 = new DefaultMutableTreeNode("C1", true);
    idcStatus.add(tituloNivel1);

    GetChildren nUno = new GetChildren(tituloNivel1,
            reporteCaratula, getStatusFromCaratulas, tipoDoc, subTipo,
            mapeoC1.getImageFromCrt(), mapeoC1.getReporteCrtList(), mapeoC1.getCantidadPapeles());

  }
}
