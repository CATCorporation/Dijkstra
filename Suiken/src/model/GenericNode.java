package model;

import java.util.ArrayList;
import java.util.List;

public class GenericNode{

	private String key = null;
	private Object value = null;
	
	private List<GenericEdge> listEdge = null; 
	
	public GenericNode(String key) {
		this.key = key;
		listEdge = new ArrayList<GenericEdge>();
	}

	public List<GenericEdge> getEdges() {
		return listEdge;
	}

	public String getId() {
		return key;
	}

	public Object getValue() {
		return value;
	}
	
	public String toString() {
		return key.toString();
	}

}
