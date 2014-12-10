/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_router.model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Dijstra {

    public static void findeBestWay(Graph g, GenericNode start, GenericNode dest) {
	GenericEdge temp = null;
	GenericNode current = start;
	LinkedPriorityQueue queue = new LinkedPriorityQueue(new ComparatorDistance());
	while (current != dest) {
	    for (GenericEdge edge : (List<GenericEdge>) current.getEdges()) {
		queue.add(edge);
	    }
	    //System.out.println(current.getKey());
	    temp = (GenericEdge) queue.remove();
	    for (GenericEdge edge : (List<GenericEdge>) current.getEdges()) {
		edge.getAttribute().addValue(temp.getAttribute().getValue());
		edge.push(temp);
	    }
	    current = temp.getOther(current);

	    System.out.println("----------------");
	}
	for (GenericEdge e : temp.getPile()) {
	    System.out.println(e);
	}
    }

    public static GenericNode findeBestWay2(Graph g, GenericNode start) {
	@SuppressWarnings("Convert2Diamond")
	HashMap<GenericEdge, GenericNode> log;
	log = new HashMap<GenericEdge, GenericNode>();
	GenericNode res = null, other, current = start;
	current.setDistance(0);
	int i = 0;
        LinkedPriorityQueue queue2 = new LinkedPriorityQueue(new ComparatorDistance());
	PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
        while (res == null) {
	    for (GenericEdge edge : (List<GenericEdge>) current.getEdges()) {
		edge.setAttribute((int) current.getDistance());
		queue2.add(edge);
                queue.push(new Element(edge));
		log.put(edge, current);
	    }
            if(queue.size() == 0)
                return current;
            
            GenericEdge temp = (GenericEdge) queue.pop().getValue();
	    while ((other = temp.getOther(current)) == null) {

		current = log.get(temp);
	    }

	    if (other.getDistance() > (current.getDistance() + temp.getAttribute().getValue())) {
		if (other.isActif() == false) {
		    other.setDistance(temp.getAttribute().getValue() + current.getDistance());
		    other.previous = current;
		}
	    }
	    current.getEdges().remove(temp);
	    current = temp.getOther(current);
	    current.getEdges().remove(temp);
	    if (current.getValue().equals("Sortie")) {
		res = current;
	    }
	     //System.out.println("i :" + i);
	    i++;

	}
	return res;
    }

}
