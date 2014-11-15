/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    
    public static GenericNode findeBestWay2(Graph g, GenericNode start){
        HashMap<GenericEdge, GenericNode> log = new HashMap<GenericEdge, GenericNode>();
        GenericNode res = null, other, current = start;
        current.setDistance(0);
        
        LinkedPriorityQueue queue = new LinkedPriorityQueue(new ComparatorDistance());
        while(res == null){            
            for(GenericEdge edge : (List<GenericEdge>) current.getEdges()){
                if(edge.getOther(current).getMouse() == null){
                    edge.setAttribute((int) current.getDistance());
                    queue.add(edge);
                    log.put(edge, current);
                }
            }
            GenericEdge temp = (GenericEdge) queue.remove();
            while((other = temp.getOther(current)) == null){               
               
                   current = log.get(temp);
            }
           
            if( other.getDistance() > ( current.getDistance() +temp.getAttribute().getValue() ))  {                 
                other.setDistance(temp.getAttribute().getValue()+current.getDistance());
                //System.out.println(" bonnnnnnnnnnn --> "+other + " valeur " + other.getDistance());
                other.previous = current;
           }
            current.getEdges().remove(temp);
            current = temp.getOther(current);
            current.getEdges().remove(temp);
            if(current.getValue().equals("13:6"))
                System.out.println("5 trouvé");
            if(current.getValue().equals("Sortie")){
                res = current;
            }
            //System.out.println("?");
            
        }
        
        return res;
    }
    
}