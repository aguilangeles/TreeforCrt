/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratula.xml;

import Entidades.Campo;
import Entidades.Caratula;
import Entidades.Metadato;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class getCrtList {

  List<Caratula> caratulaList = new ArrayList<>();

  public getCrtList() {
  }

  protected void getCaratulaList(NamedNodeMap caratulasNodeMap) {
    for (int i = 0; i < caratulasNodeMap.getLength(); i++)
      {
      Node caratulaNode = caratulasNodeMap.item(i);
      NodeList caratulaChildren = caratulaNode.getChildNodes();
      Caratula caratula = new Caratula(caratulaChildren);
      caratulaList.add(caratula);
      }
  }

  private List<Caratula> getCaratulaList() {
    return caratulaList;
  }

  public void setCaratulaList(List<Caratula> caratulaList) {
    this.caratulaList = caratulaList;
  }

  public String getTipoYSubTipo() {
    String ret = "";
    Iterator<Caratula> it = getCaratulaList().iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("Boletas"))
        {
        ret = ", Tipo= " + caratula.getDocType()
                + " , SubTipo= " + caratula.getSubTypeCode();
        }
      }
    return ret;
  }

  public int getCantidadCampos() {
    int ret = 0;
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      Metadato metadato = caratula.getMetadato();
      ret = metadato.getCampos().getLength();
      }
    return ret;
  }

  public List<String> getStatusCrt(List<String> listaCaratulas) {
    List<String> lista = new ArrayList();
    Iterator<Caratula> it = getCaratulaList().iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      Metadato metadato = caratula.getMetadato();
      Campo campo = metadato.getCampoByName("Id");
      for (String sCrt : listaCaratulas)
        {
        if (campo.getValue().equalsIgnoreCase(sCrt) && campo != null)
          {
          String ret = metadato.toString();
          lista.add(ret);
          }
        }
      }
    return lista;
  }
}
