/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DGR;
import Modelo.*;
import Vista.*;
import Control.*;


/**
 *
 * @author Damian
 */
public class inicioApp {
    
    

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        Login VistaL = new Login();
        Select VistaC = new Select();
        personaDAO modeloC = new personaDAO();
        ControladorCRUD controlC = new ControladorCRUD(VistaC, modeloC, VistaL);
        
        VistaL.setVisible(true);
        //VistaC.setVisible(false);
        VistaL.setLocationRelativeTo(null);
        
        
        
                
        
        // TODO code application logic here
    }
}
