/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diksjtra.source;

/**
 *
 * @author 626
 */
public class Node implements Comparable<Node> {
    
    public final String id, name;
    public Edge[] lien;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;
    
    public Node(String id, String name){ 
        this.name = name; 
        this.id = id;
    }
    public String toString(){ 
        return name; 
    }
    public int compareTo(Node other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}
