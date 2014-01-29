/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Meta.xml;

import Entidades.Campo;
import Entidades.Image;
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
public class ReporteXMLMetas {

private List<Meta> metas = new ArrayList<>();
private List <String> nombresCampos;
private List<String> statuses;

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public ReporteXMLMetas() {
    }

    public ReporteXMLMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public ReporteXMLMetas(NamedNodeMap metaNodes) {
        for(int i=0;i<metaNodes.getLength();i++){
            Node metaNode = metaNodes.item(i);
            NodeList metaChildren = metaNode.getChildNodes();
            Meta meta = new Meta(metaChildren);
            metas.add(meta);
        }
        setDistinctCampos();
        setDistinctStatuses();
    }
    public int getCampoStatus(String estado) {
        int ret = 0;
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreStatus = campo.getStatus();
                    if (nombreStatus.equalsIgnoreCase(estado)) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
    public List<String> getStatuses() {
        List<String > ret =null;
        String separacion ="";
        int size = statuses.size();
        switch(size){
            case 0:
                ret = new ArrayList<>();
                separacion="null";
                statuses.add(separacion);
                ret = statuses;
                break;
            case 2:
                ret = new ArrayList<>();
                separacion="null";
                statuses.add(separacion);
                ret = statuses;
                break;
            case 3 :
                ret = new ArrayList<>();
                separacion="null";
                statuses.add(separacion);
                ret = statuses;
                break;
            default:
                ret = new ArrayList<>();
                ret =statuses;
        }
        return ret;
    }

    public int getCantidadCampos() {
        int ret = 0;
        Iterator<Meta> i = metas.iterator();
        while(i.hasNext()){
            Meta meta = i.next();
            Image image = meta.getImage();
            if(image !=null) {
                ret += image.getCantidadDeCampos();
            }
        }
        return ret;
    }

    public List<String> getNombresCampos() {
        return nombresCampos;
    }

    private void setDistinctCampos() {
      this.nombresCampos = new ArrayList();
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreCampo = campo.getName();
                    if (!this.nombresCampos.contains(nombreCampo)) {
                        this.nombresCampos.add(nombreCampo);
                    }
                }
            }else{
                String vacio = ",,,,,";
                this.nombresCampos.add(vacio);

            }
        }
    }

    public List<Campo> getCamposByName(String nombre){
        List <Campo> campos = new ArrayList();
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                Campo campo = image.getCampoByName(nombre);
                if(campo!=null)campos.add(campo);
            }
        }
        return campos;
    }


    public int getCantidadValidMeta() {
        int ret = 0;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            boolean valido = meta.isMetaValid();
            if (valido) {
                ret++;
            }
        }
        return ret;
    }
    public int getCantidadInvalidMeta() {
        int ret = 0;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            boolean invalido = meta.isMetaInvalid();
            if (invalido) {
                ret++;
            }
        }
        return ret;
    }
    public List<Campo> getCamposByNameAndStatus(String nombre,String status){

        List <Campo> campos = new ArrayList();
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                Campo campo = image.getCampoByName(nombre);
                if(campo!=null&& campo.getStatus().equalsIgnoreCase(status))campos.add(campo);
            }
        }
        return campos;
    }

    public int getCampoStatusValid() {
        int ret = 0;
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreStatus = campo.getStatus();
                    if (nombreStatus.equalsIgnoreCase("Valid")) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
    public int getCampoStatusInValid() {
        int ret = 0;
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreStatus = campo.getStatus();
                    if (nombreStatus.equalsIgnoreCase("Invalid")) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    public int getCampoStatusInValidDB() {
        int ret = 0;
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreStatus = campo.getStatus();
                    if (nombreStatus.equalsIgnoreCase("InvalidDB")) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    private void setDistinctStatuses() {
        this.statuses = new ArrayList();
        String nombreStatus="";
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                     nombreStatus = campo.getStatus();
                    if (!this.statuses.contains(nombreStatus)) {
                        this.statuses.add(nombreStatus);
                    }
                }
            }
        }
    }

}
