package dijkstra_router;

import java.util.ArrayList;
import java.util.List;


public class GenericNode{
	
	private List<GenericEdge> edges = new ArrayList<GenericEdge>();
	private String key;
	private Object value;
	
	public GenericNode(String key){
		this.key = key;	
	}
	
	public GenericNode(String key, Object value){
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

	public Object getId() {
		// TODO Auto-generated method stub
		return (Object) key;
	}

	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}

    @Override
    public String toString() {
        return key;
    }
}
