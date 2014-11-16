/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router.model;

/**
 *
 * @author Lucas
 */
public class Mouse {
    
    private String name = "souris";
    
    public Mouse(String number ){
        name = name+"_"+number;
    }
    public String getName() {
        return name;
    }
    
}
