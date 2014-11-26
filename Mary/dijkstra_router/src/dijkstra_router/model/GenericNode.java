package dijkstra_router.model;

import java.util.ArrayList;
import java.util.List;


public class GenericNode{
	
    private List<GenericEdge> edges = new ArrayList<GenericEdge>();
    private String key;
    private String value;
    private double distance = Double.POSITIVE_INFINITY;
    public GenericNode previous;
    private int libre = 0;
    private boolean active = false;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getLibre() {
        return libre;
    }

    public void setLibre(int libre) {
        this.libre = libre;
    }
    
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if(this.distance == Double.POSITIVE_INFINITY){
            this.distance = 0;
        }
        this.distance += distance;
    }

    public void setValue(String value) {
        this.value = value;
    }
	
	public GenericNode(String key){
		this.key = key;	
	}
	
	public GenericNode(String key, String value){
		this.key = key;
		this.value = value;
	}
        
        public String getKey(){
            return key;
        }
	
	public List getEdges() {
		// TODO Auto-generated method stub
		return edges;
	}



	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

    @Override
    public String toString() {
        return key;
    }
}
