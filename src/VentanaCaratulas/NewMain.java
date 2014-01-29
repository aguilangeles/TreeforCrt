/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaCaratulas;

/**
 *
 * @author MUTNPROD003
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OutPutFile().setVisible(true);
            }
        });
    }

}
