/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diksjtra;

import diksjtra.source.Edge;
import diksjtra.source.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 626
 */
public class Diksjtra {

    public static void calculchemin(Node source)
    {
        source.minDistance = 0.0;
        LinkedList<Node> file = new LinkedList<Node>();
      	file.add(source);
	
        while (!file.isEmpty()) {
	    Node u = file.pop();            
            
           
            for (Edge e : u.lien)
            {
                Node v = e.cible;
                double poid = e.poid;
                double distanceTotal = u.minDistance + poid;
                
		if (distanceTotal < v.minDistance) {
		    file.remove(v);
		    v.minDistance = distanceTotal ;
		    v.previous = u;
		    file.push(v);
		}
            }
        }
    }

    public static List<Node> plusCourtChemin(Node target)
    {
        List<Node> path = new ArrayList<Node>();
        for (Node point = target; point != null; point = point.previous)
            path.add(point);
        Collections.reverse(path);
        return path;
    }
    
    public static void main(String[] args)
    {
        
        /*Graph g = new Graph();
        g.initGraph("C:\\Developpement\\Workspace\\Java\\Dijkstra\\Stitch\\src\\traitement\\map.txt");
        for(Node n : g.getNodes()){
            System.out.println(n.name);
        }*/
        
        Node v0 = new Node("Paris", "Paris");
	Node v1 = new Node("Lyon", "Lyon");
	Node v2 = new Node("Grenoble", "Grenoble");
	Node v3 = new Node("Valence", "Valence");
	Node v4 = new Node("Gap", "Gap");
        //Node v5 = new Node("Marseille", "Marseille");

	v0.lien = new Edge[]{    new Edge(v1, 7),
                                        new Edge(v0, 9),
                                        new Edge(v3, 14) };
        
	v1.lien = new Edge[]{    new Edge(v0, 7),
                                        new Edge(v2, 10),
                                        new Edge(v4, 15) };
        
	/*v2.lien = new Edge[]{    new Edge(v0, 9),
                                        new Edge(v1, 10),
                                        new Edge(v3, 2),
                                        new Edge(v4, 11)};
        
	v3.lien = new Edge[]{    new Edge(v0, 14),
                                        new Edge(v2, 2),
                                        new Edge(v5, 9)};
        
	v4.lien = new Edge[]{    new Edge(v1, 15),
                                        new Edge(v2, 11),
                                        new Edge(v5, 6) };
        
        v5.lien = new Edge[]{    new Edge(v4, 6),
                                        new Edge(v3, 9)};*/
        
	Node[] listNode = { v0, v1};
        calculchemin(v0);
        for (Node v : listNode)
	{
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    List<Node> path = plusCourtChemin(v);
	    System.out.println("Path: " + path);
	}
        
    }
}
