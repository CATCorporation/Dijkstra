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
public class Node implements Comparable<Node> {
    
    private String id, name;    
    private Edge[] lien;
    private double minDistance = Double.POSITIVE_INFINITY;
    private Node previous;
    private boolean actif = false;
    private boolean herbe = false;
    private String position;
    private boolean pop = false;

    public boolean isPop() {
        return pop;
    }

    public void setPop(boolean pop) {
        this.pop = pop;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public boolean isHerbe() {
        return herbe;
    }

    public void setHerbe(boolean herbe) {
        this.herbe = herbe;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Edge[] getLien() {
        return lien;
    }

    public void setLien(Edge[] lien) {
        this.lien = lien;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
   
    
    public Node(String id, String name){ 
        this.name = name; 
        this.id = id;
	lien = new Edge[0];
    }
    public String toString(){ 
        return name; 
    }
    public int compareTo(Node other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    public  void addLien (Node source, Edge e){
        
        Edge [] tab; 
        int taille = 0;
       if(source.lien != null) 
           taille = source.lien.length+1;
       else
           taille = 1;
       
        tab = new Edge[taille];
        
        int i;
        if( taille > 1){
            for ( i = 0; i < taille-1; i++)
                tab[i] = source.lien[i];
            tab[i] = e;
        }
        else
            tab[0] = e;
        source.lien = tab;        
    }
    public  void clearLien(Node source){
        source.lien = null;
    }
}
