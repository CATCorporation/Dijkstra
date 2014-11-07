/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diksjtra.source;


/**
 *
 * @author 626
 */
public class Chaine {
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
    */
    Node firstElement = null;
    boolean reversed = false;
    
    public boolean isEmpty(){
        if (firstElement == null )
            return true;
        return false;
    }
    
   

    public void push(Node element) {
        if (firstElement != null) {
            element.previous = firstElement;
            firstElement = element;
        } else {
            firstElement = element;
        }
    }

    public Node pop() {
        
        Node result;
        result = firstElement;
        firstElement = firstElement.previous;
        return result;
    }

    public void remove( Node tmp) {
        Node lien = firstElement;
        Node prev = lien;
        
        while(lien != null && lien != tmp){
            prev = lien;
            lien = lien.previous;
        }
        if(lien == tmp){
            prev.previous = lien.previous;
            lien = null;
        }
        
    }

    public String toString() {
        
        Node tmp = firstElement;
        String result = "";
        while (tmp != null) {
            result += tmp.name + " ";
            tmp = tmp.previous;
        }
        return result;
    }

   

    public boolean empty() {
        if (firstElement == null) {
            return true;
        } else {
            return false;
        }
    }

    public Node peek() {
        return firstElement;
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
        Node tmp = firstElement; 
        
        while(tmp != null){
            System.out.println(" print :" +tmp.name);
            tmp = tmp.previous;
        }
            
    }
}
