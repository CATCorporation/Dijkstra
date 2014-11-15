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
/*
    public String toString() {
        
        Node tmp = firstElement;
        String result = "";
        while (tmp != null) {
            result += tmp.name + " ";
            tmp = tmp.previous;
        }
        return result;
    }   

    public int search(String value) {       
        int i = 1;
        Node tmp = firstElement;
        for (int j = 0 ; j < tmp.lien.length; j++) { 
            if (tmp.lien[i].cible.name.equals(value)) {
                return i;
            }
            tmp = tmp.previous;
            i++;
        }
        return -1;
    }
    
    public void print(){
        GenericNode tmp = firstElement; 
        
        while(tmp != null){
            System.out.println(" print :" +tmp.name);
            tmp = tmp.previous;
        }
            
    }*/
}
