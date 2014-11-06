/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

/**
 *
 * @author 626
 */
import javax.swing.SwingUtilities;

public class JFenetre {

      
      // Lancement du jeu 
      public static void main(String[] args) {          
           Runnable r = new Runnable ()
                   {
                       public void run()  {
                           Fenetre monUI=new Fenetre(); 
                            monUI.pack();
                            // centrage sur l'écran
                            monUI.setLocationRelativeTo(null);
                           monUI.setVisible(true);                         
                       }
                   };
                   SwingUtilities.invokeLater(r);
      }

} 