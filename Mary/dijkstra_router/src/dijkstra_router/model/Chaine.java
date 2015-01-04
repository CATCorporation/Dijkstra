/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_router.model;

import java.util.ArrayList;


/**
 *
 * @author 626
 */

public class Chaine extends ArrayList<GenericNode>{
     
    GenericNode firstElement;
    boolean reversed;
    
    public Chaine ()    {
        firstElement = null;
        reversed = false;
    }

    public void push(GenericNode element) {
       add(element);
    }

    public GenericNode pop() {        
        GenericNode e = get(size() - 1);
        remove(size() - 1);
        return e;
    }
}
