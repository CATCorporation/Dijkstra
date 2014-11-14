/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
       Graph graph = new Graph();

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
       graph.initGraph("C:\\Developpement\\Workspace\\Java\\Dijkstra\\Mary\\dijkstra_router\\src\\dijkstra_router\\map.txt");
       //graph.initEdge();
       int i = 0;
       GenericNode depart = graph.getNode("5:16");
       GenericNode arriveOne = graph.getNode("5:2"), arriveTwo = graph.getNode("43:1"), arrive = null;
       temp : while(depart != arriveOne && depart != arriveTwo){
            graph.initEdge();
            
            //System.out.println("a");
            //System.out.println("Je part de " + depart);
            arrive = Dijstra.findeBestWay2(graph, depart, arriveOne, arriveTwo);
            while(arrive.previous != depart){
                 arrive = arrive.previous;
                 //System.out.println("Depart " + depart);
            }
            depart = arrive;
            System.out.println("Je doit partir en " + depart.getDistance());
            if(i++ == 4){
                //break temp;
            }
       }
        System.out.println("Je suis arrivé");
       
      
       
    }
    
}
