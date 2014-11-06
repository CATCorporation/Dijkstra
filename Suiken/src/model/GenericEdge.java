package model;

import java.util.HashMap;
import java.util.Map;

public class GenericEdge{
	
	private GenericNode node1 = null;
	private GenericNode node2 = null;
	private Map<String,Object> attributes = new HashMap<String,Object>();
	
	public GenericEdge(GenericNode node1, GenericNode node2, Object o) {
		this.node1 = node1;
		this.node2 = node2;
		
		node1.getEdges().add(this);
		node2.getEdges().add(this);
		
		attributes.put("cost", o);
	}

	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	public GenericNode getOther(GenericNode node) {
		if(node1 == node) return node2;
		if(node2 == node) return node1;
		return null;
	}

	public void setAttribute(String string, Object o) {
		attributes.put(string,o);
	}

}
