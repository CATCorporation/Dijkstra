/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_router.controller;

import dijkstra_router.model.Dijstra;
import dijkstra_router.model.GenericNode;
import dijkstra_router.model.Graph;
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
	// TODO code application logic here

	// Build node.
		/*GenericNode paris = new GenericNode("Paris");
	 GenericNode lyon = new GenericNode("Lyon");
	 GenericNode grenoble = new GenericNode("Grenoble");
	 GenericNode valence = new GenericNode("Valence");
	 GenericNode gap = new GenericNode("Gap");
	 GenericNode marseille = new GenericNode("Marseille");

	 graph.registerNode(paris);
	 graph.registerNode(lyon);
	 graph.registerNode(grenoble);
	 graph.registerNode(valence);
	 graph.registerNode(gap);
	 graph.registerNode(marseille);
		
	 // Build edges
	 new GenericEdge(paris, lyon, new Distance(1));
	 new GenericEdge(lyon, grenoble, new Distance(6));
	 new GenericEdge(lyon, valence, new Distance(1));
	 new GenericEdge(grenoble, valence, new Distance(1));
	 new GenericEdge(grenoble, gap, new Distance(1));
	 new GenericEdge(gap, marseille, new Distance(1));
	 new GenericEdge(valence, marseille, new Distance(6));
	 Chaine path = new Chaine();
	 Dijstra.findeBestWay2(graph, paris, marseille,path);
                
	 while(marseille.previous != null){
	 System.out.println(marseille);
	 marseille = marseille.previous;
	 }
	 //for(int i = 0; i < path.size(); i++)
	 //  System.out.println("Lieux : "+ path.get(i)+ " ditance : "+path.get(i).getDistance());
	 */
	Runnable r = new Runnable() {
	    @Override
	    public void run() {
		Graph graph = new Graph();

		Fenetre monUI = new Fenetre();
		monUI.pack();
		// centrage sur l'écran
		monUI.setLocationRelativeTo(null);
		monUI.setVisible(true);

		graph.initGraph("/Users/Suiken/Documents/Projets/Dijkstra/Mary/dijkstra_router/src/dijkstra_router/map.txt");
		int i = 0;
		GenericNode depart = graph.getNode("5:16");
		GenericNode arriveOne = graph.getNode("5:2"), arriveTwo = graph.getNode("43:1"), arrive = null;
		arriveOne.setValue("Sortie");
		arriveTwo.setValue("Sortie");

		while (depart != arriveOne && depart != arriveTwo) {
		    graph.initEdge();
		    
		    System.out.println(depart);
		    monUI.setMap(depart);
		    try{
			monUI.wait(10000);
		    }catch(Exception e){
			System.out.println(e.getMessage());
		    }
		    arrive = Dijstra.findeBestWay2(graph, depart);
		    while (arrive.previous.previous != null) {

			arrive = arrive.previous;

		    }

		    arrive.previous = null;
		    depart = arrive;

		}

	    }
	};
	SwingUtilities.invokeLater(r);

	//GenericNode souris = new GenericNode("7:17");
	//f.setMap(souris);
	/*Map m = new Map();
	 m.lire();*/
    }

}
