/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Dijstra {
    
    public static void findeBestWay(Graph g, GenericNode start, GenericNode dest){
        GenericEdge temp = null;
        GenericNode current = start;
        LinkedPriorityQueue queue = new LinkedPriorityQueue(new ComparatorDistance());
        while(current != dest){
            for(GenericEdge edge : (List<GenericEdge>) current.getEdges()){
                queue.add(edge);
            }
            //System.out.println(current.getKey());
            temp = (GenericEdge) queue.remove();
            for(GenericEdge edge : (List<GenericEdge>) current.getEdges()){
                edge.getAttribute().addValue(temp.getAttribute().getValue());
                edge.push(temp);
            }
            current = temp.getOther(current);
            
            System.out.println("----------------");
        }
        for(GenericEdge e : temp.getPile()){
                System.out.println(e);
            }
        
        
        
    }
    
    public static void findeBestWay2(Graph g, GenericNode start, GenericNode dest){
        ArrayList<GenericNode> listNodes = g.getNodes();
        GenericNode other, current = start;
        
        int i = 0;
        LinkedPriorityQueue queue = new LinkedPriorityQueue(new ComparatorDistance());
        while(current != dest){
            System.out.println("Je suis à " + current);
            for(GenericEdge edge : (List<GenericEdge>) current.getEdges()){
                queue.add(edge);
            }
            GenericEdge temp = (GenericEdge) queue.remove();
            System.out.println("Je prend l'axe " + temp);
           while((other = temp.getOther(current)) == null){
               
               current = listNodes.get(listNodes.size()-1); 
               listNodes.remove(listNodes.size()-1);
               
           }
           System.out.println("Je suis arrivé à " + other);
            for(GenericEdge edge : (List<GenericEdge>) other.getEdges()){
                if(edge != temp)
                    edge.getAttribute().addValue(temp.getAttribute().getValue());
                //System.out.println("Maintenant je peux aller à  : " + edge + " pour " + edge.getAttribute().getValue());
            }
            
            listNodes.add(current);
            current.getEdges().remove(temp);
            current = temp.getOther(current);
            current.getEdges().remove(temp);
            
        }
    }
    
}