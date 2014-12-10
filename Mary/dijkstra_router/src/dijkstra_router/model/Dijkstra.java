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
 * @author Mary
 */
public class Dijkstra {


    /**
     * Enable find the shorter way at T instant
     * @param start Start node
     * @return next node to take the shorter way.
     */
    public static GenericNode findeBestWay(GenericNode start) {
	@SuppressWarnings("Convert2Diamond")
	HashMap<GenericEdge, GenericNode> log;
	log = new HashMap<GenericEdge, GenericNode>();
	GenericNode res = null, other, current = start;
	current.setDistance(0);
	PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
        while (res == null) {
	    for (GenericEdge edge : (List<GenericEdge>) current.getEdges()) {
		edge.setAttribute((int) current.getDistance());
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
	}
	return res;
    }

}
