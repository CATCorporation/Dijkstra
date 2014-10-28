package dijkstra_router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Graph{

	private HashMap<String, GenericNode> map = new HashMap<String, GenericNode>();
	
	public Graph(){
		
	}
        
	public GenericNode getNode(Object key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}
        
        public ArrayList<GenericNode> getNodes(){
            ArrayList<GenericNode> nodes = new ArrayList<GenericNode>();
            for(String s : map.keySet()){
                nodes.add(map.get(s));
            }
            
            return nodes;
        }
        
	public void registerNode(GenericNode node) {
		// TODO Auto-generated method stub
		map.put((String) node.getId(), node);
	}

	public void unregisterNode(Object key) {
		// TODO Auto-generated method stub
		map.remove(key);
		
	}

}
