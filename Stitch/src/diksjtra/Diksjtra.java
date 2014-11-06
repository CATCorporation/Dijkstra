/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diksjtra;

import diksjtra.source.Chaine;
import diksjtra.source.Edge;
import diksjtra.source.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author 626
 */
public class Diksjtra {

    public static void calculchemin(Node source)
    {
        source.minDistance = 0.0;
        Chaine vertexQueue = new Chaine();
      	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Node u = vertexQueue.poll();
            System.out.println("push  "+ u);
            // Visit each edge Node u u
            for (Edge e : u.adjacencies)
            {
                Node v = e.target;
                
                System.out.println("node v  "+ v);
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                
                System.out.println(distanceThroughU +"  "+ v.minDistance);
                
		if (distanceThroughU < v.minDistance) {
                    System.out.println("trouver "+ v);
		    vertexQueue.remove(v);
		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    vertexQueue.add(v);
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
    /*
    public static void main(String[] args)
    {
        Node v0 = new Node("Paris");
	Node v1 = new Node("Lyon");
	Node v2 = new Node("Grenoble");
	Node v3 = new Node("Valence");
	Node v4 = new Node("Gap");
        Node v5 = new Node("Marseille");

	v0.adjacencies = new Edge[]{    new Edge(v1, 7),
                                        new Edge(v2, 9),
                                        new Edge(v3, 14) };
        
	v1.adjacencies = new Edge[]{    new Edge(v0, 7),
                                        new Edge(v2, 10),
                                        new Edge(v4, 15) };
        
	v2.adjacencies = new Edge[]{    new Edge(v0, 9),
                                        new Edge(v1, 10),
                                        new Edge(v3, 2),
                                        new Edge(v4, 11)};
        
	v3.adjacencies = new Edge[]{    new Edge(v0, 14),
                                        new Edge(v2, 2),
                                        new Edge(v5, 9)};
        
	v4.adjacencies = new Edge[]{    new Edge(v1, 15),
                                        new Edge(v2, 11),
                                        new Edge(v5, 6) };
        
        v5.adjacencies = new Edge[]{    new Edge(v4, 6),
                                        new Edge(v3, 9)};
        
	Node[] listNode = { v0, v1, v2, v3, v4, v5};
        calculchemin(v0);
        for (Node v : listNode)
	{
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    List<Node> path = plusCourtChemin(v);
	    System.out.println("Path: " + path);
	}
    }*/
}
