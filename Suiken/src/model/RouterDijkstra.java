/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IRouteResult;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Suiken
 */
public class RouterDijkstra{

	Comparator<GenericEdge> comparator;
	Graph graph;
	
    public void setGraph(Graph graph) {
    	this.graph = graph;
    }

    public Graph getGraph() {
    	return this.graph;
    }

    public void setComparator(Comparator comparator) {
		comparator = this.comparator;
    }

    public IRouteResult route(GenericNode from, GenericNode to) {
//	ways est une file qui contiendra tous les chemins possibles tandis que way est une pile qui contiendra un de ces mêmes chemins
	PriorityQueue ways = new PriorityQueue();
	Stack way = new Stack();
	
//    	On y met le premier maillon
	way.push(new Element(from));
    	
//	Parcours des chemins
	while(!ways.empty()){
	    Stack tmpWay;
	    tmpWay = (Stack) (ways.pop().getValue());
	    if(tmpWay.empty()){
		
	    }
	}
	GenericNode nodeTmp = from;
    	
    	List<GenericEdge> edges = nodeTmp.getEdges();
    	GenericEdge edgeMin = from.getEdges().get(0);
    	for(int i = 1; i < edges.size(); i++){
    		if(comparator.compare(edges.get(i), edgeMin) < 0)
		    edgeMin = edges.get(i);
    	}
    	way.push(new Element(edgeMin.getOther(nodeTmp)));
    	
    	return null;
    }
    
}