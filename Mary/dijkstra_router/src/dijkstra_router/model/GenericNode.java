package dijkstra_router.model;

import java.util.ArrayList;
import java.util.List;

public class GenericNode {

    private List<GenericEdge> edges = new ArrayList<GenericEdge>();

    public void setEdges(List<GenericEdge> edges) {
        //this.edges = edges;
        this.edges.clear();
    }
    private String key;
    private String value;
    private String oldValue;

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
    private double distance = Double.POSITIVE_INFINITY;
    public GenericNode previous;
    private boolean herbe = false;
    private boolean actif = false;

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

    public GenericNode(String key, String value) {
	this.key = key;
	this.value = value;
        this.oldValue = value;
    }

    public String getKey() {
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
