/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diksjtra.source;

import java.util.ArrayList;
import java.util.Comparator;


/**
 *
 * @author 626
 */

public class Chaine extends ArrayList<Node> {
     
    Node firstElement;
    boolean reversed;
    private Comparator c;

   
    public Chaine (Comparator c)    {
        firstElement = null;
        reversed = false;
        this.c =c;
    }
    

    public void push(Node element) {
        int i = 0;
            if(this.isEmpty()){
                this.add(element);
            }else{
                while( i < this.size()){
                    if(c.compare(element, this.get(i)) < 0){
                        break;
                    }
                    i++;
                }
                this.add(i, element);
            }
    }
    public void remove(Node d,Edge e){
        Edge [] liste = new Edge [d.getLien().length-1];
        int j = 0;
        for(int i = 0; i < d.getLien().length; i++){
            if(!liste[i].equals(e)){
                liste[j] = d.getLien()[i];
                j++;
            }
        }
       d.setLien(liste);
    }
    
    public Node pop() {        
        Node e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    public void print(){
        Node tmp = firstElement; 
        
        while(tmp != null){
            System.out.println(" print :" +tmp.getName());
            tmp = tmp.getPrevious();
        }
            
    }

   
}
