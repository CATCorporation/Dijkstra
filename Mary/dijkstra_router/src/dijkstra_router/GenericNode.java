package dijkstra_router;

import java.util.ArrayList;
import java.util.List;


public class GenericNode{
	
	private List<GenericEdge> edges = new ArrayList<GenericEdge>();
	private String key;
	private String value;
        private double distance = Double.POSITIVE_INFINITY;
        public GenericNode previous;
    
        public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
