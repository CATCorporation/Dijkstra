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
public class ComparatorDistance implements Comparator<GenericEdge>{


    @Override
    public int compare(GenericEdge o1, GenericEdge o2) {
        if(o1.getAttribute().getValue() < o2.getAttribute().getValue()){
            return -1;
        }
        if(o2.getAttribute().getValue() > o2.getAttribute().getValue()){
            return 1;
        }
        return 0;
    }
    
    
}
