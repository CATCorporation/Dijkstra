/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router;

import java.util.ArrayList;
import java.util.Collections;
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
            //temp = (GenericEdge) queue.remove();
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
    
    public static void findeBestWay2(Graph g, GenericNode start, GenericNode dest) throws Exception{
        ArrayList<GenericNode> listNodes = g.getNodes();
        GenericNode other, previous = null, current = start;
        current.setDistance(0);
        int count = 0;
        int i = 0;
        LinkedPriorityQueue queue = new LinkedPriorityQueue(new ComparatorDistance());
        while(current != dest){
	    //GenericEdge edg = (GenericEdge) g.getNode("4:17").getEdges().get(0);
	    //System.out.println("lololol " + queue.getIndex(edg)); //+ edg.getAttribute().getValue());
	    count++;
	    System.out.println(count);
            //System.out.println("Je suis à " + current);
            for(GenericEdge edge : (List<GenericEdge>) current.getEdges()){
		System.out.println("edge de current : " + current.getEdges() + "    -    current : " + current);
                queue.add(edge);
            }
	    GenericEdge temp = null;
	    try{
		temp = (GenericEdge) queue.remove(); //peek();
	    }catch(Exception e){
		System.out.println(e.getMessage());
		throw new Exception(e);
	    }
	    System.out.println("taille queue : " + queue.size());
//            i = (listNodes.size()-1);
	    i = 0;
            while((other = temp.getOther(current)) == null){               
               
		//System.out.println("je veux prendre l'axe " + temp);
		current = listNodes.get(i);
		//System.out.println("en fait je repart de " + current);
		//listNodes.remove(i);
		i++;     
                
            }
	    System.out.println("Je prend l'axe " + other);

           //System.out.println("je suis senser arriver à : " + temp.getOther(current)); 
           //System.out.println("Je suis arrivé à " + other);
           if( other.getDistance() > ( current.getDistance() +temp.getAttribute().getValue() ))  {                 
                other.setDistance(temp.getAttribute().getValue()+current.getDistance());
                //System.out.println(" bonnnnnnnnnnn --> "+other + " valeur " + other.getDistance());
                other.previous = current;
           }
            //listNodes.add(current);
            current.getEdges().remove(temp);
            current = temp.getOther(current);
            current.getEdges().remove(temp);
            
        }
    }
    
   
    
}