/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router;

/**
 *
 * @author Lucas
 */
public class Distance {
    
    private int value;
    
    public Distance(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public void addValue(int add){
        value = add;
    }
}
