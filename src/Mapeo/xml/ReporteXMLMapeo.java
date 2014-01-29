/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrador
 */
public class ReporteXMLMapeo {

  private List<MapeoList> getmapeosList = new ArrayList<>();
  private List<String> nombresFaces = new ArrayList<>();
  private List<String> mapeoGetC1List = new ArrayList<>();
  private List<String> mapeoGetC2List = new ArrayList<>();
  private List<String> mapeoGetC3List = new ArrayList<>();
  private List<String> mapeoGetC4List = new ArrayList<>();
  private List<String> imagenC1 = new ArrayList<>();
  private List<String> imagenC2 = new ArrayList<>();
  private List<String> imagenC3 = new ArrayList<>();
  private List<String> imagenC4 = new ArrayList<>();

  public ReporteXMLMapeo(NamedNodeMap mapeoLists) {
    for (int i = 0; i < mapeoLists.getLength(); i++)
      {
      Node mapeoListNode = mapeoLists.item(i);
      NodeList mapeoChildren = mapeoListNode.getChildNodes();
      MapeoList mapeoList = new MapeoList(mapeoChildren);
      getmapeosList.add(mapeoList);
      }
    setDistinctFace();
    getValoresCaratulas();
  }

  private void getValoresCaratulas() {
    Iterator<MapeoList> it = getmapeosList.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      boolean isCaratula = mapeoList.getCarat();
      if (isCaratula)
        {
        String c1 = mapeoList.getC1();
        String c2 = mapeoList.getC2();
        String c3 = mapeoList.getC3();
        String c4 = mapeoList.getC4();
        //busca los contenidos que no esten vacios
        if (!c1.equals(""))
          {
          mapeoGetC1List.add(c1);
          imagenC1.add(mapeoList.getFileName());
          } else if (!c2.equals(""))
          {
          mapeoGetC2List.add(c2);
          imagenC2.add(mapeoList.getFileName());
          } else if (!c3.equals(""))
          {
          mapeoGetC3List.add(c3);
          imagenC3.add(mapeoList.getFileName());
          } else if (!c4.equals(""))
          {
          mapeoGetC4List.add(c4);
          imagenC4.add(mapeoList.getFileName());
          }
        }
      }
  }

  public List<String> getImagenC1() {
    return imagenC1;
  }

  public List<String> getImagenC2() {
    return imagenC2;
  }

  public List<String> getImagenC3() {
    return imagenC3;
  }

  public List<String> getImagenC4() {
    return imagenC4;
  }

  public List<String> getMapeoGetC1List() {
    return mapeoGetC1List;
  }

  public List<String> getMapeoGetC2List() {
    return mapeoGetC2List;
  }

  public List<String> getMapeoGetC3List() {
    return mapeoGetC3List;
  }

  public List<String> getMapeoGetC4List() {
    return mapeoGetC4List;
  }

  private void setDistinctFace() {
    Iterator<MapeoList> it = this.getmapeosList.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      String nombreFace = mapeoList.getFace();
      if (!this.nombresFaces.contains(nombreFace))
        {
        this.nombresFaces.add(nombreFace);
        }
      }
  }
}
