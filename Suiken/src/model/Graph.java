package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph{

	private Map<String,GenericNode> nodes = new HashMap<String,GenericNode>();
	
	public GenericNode getNode(String key) {
		return nodes.get(key);
	}

	public void registerNode(GenericNode node) {
		nodes.put(node.getId(), node);	
	}

	public void unregisterNode(String key) {
		
		Iterator<Entry<String, GenericNode>> it = nodes.entrySet().iterator();
		
		Iterator<GenericEdge> it2;
		
		GenericNode tmp;

		while( it.hasNext() ) {
			
			tmp = it.next().getValue();
			
			it2 = tmp.getEdges().iterator();
			
			while(it2.hasNext()) {
				if(it2.next().getOther(tmp) == getNode(key)) {
					it2.remove();
				}
			}
		}
		
		nodes.remove(key);
	}

	public Collection<?> getNodes() {
		ArrayList<GenericNode> nodes = new ArrayList<GenericNode> ();
		
		Set<String> keys = this.nodes.keySet();
		
		for(String key : keys){
			nodes.add(this.nodes.get(key));
		}
		
		return (Collection<?>) keys;
	}
}
