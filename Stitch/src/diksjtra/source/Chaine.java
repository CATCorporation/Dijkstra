/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diksjtra.source;

import java.util.PriorityQueue;

/**
 *
 * @author 626
 */
public class Chaine extends PriorityQueue<Node>{
   /* Node tete;
    
    public void Chaine(){
        tete = null;
    }
    @Override
    public void add (Node noeud){
        if( tete == null )
            tete = noeud;
        else{
            while (tete.previous != null)
                tete = tete.previous; 
            tete.previous = noeud;
        }
    }
    
    public Node push(){
        return tete; 
    }
    
    public void remove (Node v){
        System.out.println(" trouver noeud "+ v.toString());
       while( tete != null){
           if(tete.toString().equals(v.toString())){
                System.out.println(" trouver noeud "+ v.toString());
                Node sup = tete.previous;
                tete = null;
                tete = sup;
            }
           tete = tete.previous;
       }
                       
    }
    
    public boolean isEmpty(){
        if (tete == null )
            return true;
        return false;
    }*/
}
