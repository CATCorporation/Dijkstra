/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_router.controller;

import dijkstra_router.view.Fenetre;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lucas
 */
public class Dijkstra_router {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

	Runnable r = new Runnable() {
	    @Override
	    public void run() {
		Fenetre monUI = new Fenetre();
		monUI.pack();
		// centrage sur l'écran
		monUI.setLocationRelativeTo(null);
		monUI.setVisible(true);

	    }
	};
	SwingUtilities.invokeLater(r);
		/*Graph graph = new Graph();
		 graph.initGraph("./ressources/map.txt");
		 //graph.initEdge();
		 int i = 0;
		 GenericNode depart = graph.getNode("5:16");
		 GenericNode arriveOne = graph.getNode("5:2"), arriveTwo = graph.getNode("43:1"), arrive = null;
		 arriveOne.setValue("Sortie");
		 arriveTwo.setValue("Sortie");
		 temp:
		 while (depart != arriveOne && depart != arriveTwo) {
		 graph.initEdge();

		 //System.out.println("a");
		 //System.out.println("Je part de " + depart);
		 arrive = Dijstra.findeBestWay2(graph, depart);
		 while (arrive.previous != depart) {
		 arrive = arrive.previous;
		 //System.out.println("Depart " + depart);
		 }
		 depart = arrive;
		 System.out.println("Je doit partir en " + depart);
		 if (i++ == 4) {
		 //break temp;
		 }
		 }
		 System.out.println("Je suis arrivé");*/
    }

}
