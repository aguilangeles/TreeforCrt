/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author educacionit
 */
public class ExcepcionesEnXml extends Exception {

    private String id;
    private String nivelDeError;
    private String mensajeError;

    public ExcepcionesEnXml(String id, String nivelDeError, String mensajeError) {
        this.id = id;
        this.mensajeError = mensajeError;
        this.nivelDeError = nivelDeError;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getNivelDeError() {
        return nivelDeError;
    }

    public void setNivelDeError(String nivelDeError) {
        this.nivelDeError = nivelDeError;
    }


}
