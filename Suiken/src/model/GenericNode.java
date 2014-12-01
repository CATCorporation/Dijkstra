package model;

import java.util.ArrayList;
import java.util.List;

public class GenericNode {

	private List<GenericEdge> edges = new ArrayList<GenericEdge>();
	private String key;
	private String value;
	private double distance = Double.POSITIVE_INFINITY;
	private GenericNode previous;
	private boolean herbe = false;
	private boolean actif = false;
	private boolean distanceModified = false;

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isHerbe() {
		return herbe;
	}

	public void setHerbe(boolean herbe) {
		this.herbe = herbe;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		if (this.distance == Double.POSITIVE_INFINITY) {
			this.distance = 0;
		}
		this.distance += distance;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public GenericNode(String key) {
		this.key = key;
	}

	public void setEdges(List<GenericEdge> edges) {
		this.edges = edges;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setPrevious(GenericNode previous) {
		this.previous = previous;
	}

	public List<GenericEdge> getEdges() {
		return edges;
	}

	public GenericNode getPrevious() {
		return previous;
	}

	public GenericNode(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public boolean checkIfGrass() {
		if (value.equals("grass")) {
			return true;
		}
		return false;
	}

	public void addDistance(GenericEdge edge) {
		if (!distanceModified) {
			distance += edge.getAttribute().getValue();
			for (GenericEdge e : edges) {
				e.setAttribute(e.getAttribute().getValue() + edge.getAttribute().getValue());
			}
			distanceModified = true;
		}

	}

	@Override
	public String toString() {
		return key;
	}
}
