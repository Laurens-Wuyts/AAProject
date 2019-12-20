/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectclient;
import beans.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.NamingException;

/**
 *
 * @author r0614393
 */
public class Main {
    @EJB private static DBBean2Remote dbbean;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            GUI g = new GUI();
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
