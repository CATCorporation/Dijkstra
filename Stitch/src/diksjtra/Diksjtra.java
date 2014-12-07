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
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 626
 */
public class Diksjtra {

    public static Node calculchemin(Node source, Chaine path)
    {
        source.setMinDistance(0);
        Chaine file = new Chaine( new ComparatorDistance());
        
      	file.push(source);
	Node res = null;
        path.push(source);
        while (res == null) {
	    Node u = file.pop();            
            file.print();
            
            for (Edge e : u.getLien())
            {
                
                Node v = e.cible;
                path.push(v);
                //System.out.println(" trouve " + e.cible.getId() + "    coordonee " + v.getId());
                double poid = e.poid;
                double distanceTotal = u.getMinDistance() + poid;
                
		if (distanceTotal < v.getMinDistance()) {
		    file.remove(e);
		    v.setMinDistance(distanceTotal); 
		    v.setPrevious(u);
		    file.push(v);
                    
		}
                if(v.getName().equals("Sortie")){
                    System.out.println(" trouve " + e.cible.getId());
                    res = v;
                    break;
                }
            }         
        }
        return res;
    }

    public static List<Node> plusCourtChemin(Node target)
    {
        List<Node> path = new ArrayList<Node>();
        for (Node point = target; point != null; point = point.getPrevious())
            path.add(point);
        Collections.reverse(path);
        return path;
    }
    /*
    public static void main(String[] args)
    {
        
        /*Graph g = new Graph();
        g.initGraph("C:\\Developpement\\Workspace\\Java\\Dijkstra\\Stitch\\src\\traitement\\map.txt");
        for(Node n : g.getNodes()){
            System.out.println(n.name);
        }
        
        Node v0 = new Node("Paris", "Paris");
	Node v1 = new Node("Lyon", "Lyon");
	Node v2 = new Node("Grenoble", "Grenoble");
	Node v3 = new Node("Valence", "Valence");
	Node v4 = new Node("Gap", "Gap");
        Node v5 = new Node("Marseille", "Marseille");

	v0.lien = new Edge[]{    new Edge(v1, 7),
                                        new Edge(v2, 9),
                                        new Edge(v3, 14) };
        
	v1.lien = new Edge[]{    
                                        new Edge(v2, 10),
                                        new Edge(v4, 15) };
        
	v2.lien = new Edge[]{    new Edge(v0, 9),
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
                                        new Edge(v3, 9)};
        
	Node[] listNode = { v1, v2, v3, v4, v5};
        calculchemin(v1);
        for (Node v : listNode)
	{
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    List<Node> path = plusCourtChemin(v);
	    System.out.println("Path: " + path);
	}
        
    }*/
}
