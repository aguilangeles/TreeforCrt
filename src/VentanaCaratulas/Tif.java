/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaCaratulas;

/**
 *
 * @author maria
 */
public class Tif {
    private String ruta;
    private String fileName;
    private String metadata;

    public Tif(String ruta, String fileName, String metadata) {
        this.ruta = ruta;
        this.fileName = fileName;
        this.metadata = metadata;
    }

    public String getRuta() {
        return ruta;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return fileName;
    }
    
}