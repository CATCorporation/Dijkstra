/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router;

import java.util.Comparator;

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
		GenericNode paris = new GenericNode("Paris");
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
		new GenericEdge(lyon, grenoble, new Distance(1));
		new GenericEdge(lyon, valence, new Distance(1));
		new GenericEdge(grenoble, valence, new Distance(1));
		new GenericEdge(grenoble, gap, new Distance(1));
		new GenericEdge(gap, marseille, new Distance(1));
		new GenericEdge(valence, marseille, new Distance(4));
                
                Dijstra.findeBestWay2(graph, paris, marseille);
    }
    
}
