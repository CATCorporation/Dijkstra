/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diksjtra;

import diksjtra.source.Node;
import java.util.Comparator;

/**
 *
 * @author 626
 */
public class ComparatorDistance implements Comparator<Node>{


    @Override
    public int compare(Node o1, Node o2) {
            if(o1.getMinDistance() < o2.getMinDistance()){
                return -1;
            }
            if(o2.getMinDistance() > o2.getMinDistance()){
                return 1;
            }
            return 0;
        }    
}
