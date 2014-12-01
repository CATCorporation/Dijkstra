/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Suiken
 */
public class Dijkstra {

    public static GenericNode findBestWay(Graph graph, GenericNode depart) {

	ArrayList<GenericNode> result = new ArrayList<GenericNode>();
	PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
	GenericNode currentNode = depart;
	currentNode.setDistance(0);
	GenericEdge currentEdge = null;
	GenericEdge lastEdge;
//	L'arrayList va représenter la position de chaque souris à la fin de l'algo
	try {

	    while (!currentNode.getValue().equals("D")) {

//		J'ajoue tout les edges d'un node dans la queue
		for (GenericEdge e : (ArrayList<GenericEdge>) currentNode.getEdges()) {

		    queue.push(new Element(e));

		}
		
//		Je retire l'edge avec la plus petite distance pour en faire un chemin
		lastEdge = currentEdge;
		currentEdge = queue.pop().getValue();
		//System.out.println("taille avant " + currentEdge.getAttribute().getValue());
		System.out.println("edge à prendre : " + currentEdge.toString());
		currentNode = currentEdge.getOther(currentNode);
		currentNode.setPrevious(currentEdge.getOther(currentNode));
		if(currentEdge.getOther(depart) == null){
		    currentEdge.setAttribute(currentEdge.getAttribute().getValue() + lastEdge.getAttribute().getValue());
		}
		System.out.println("taille après " + currentEdge.getAttribute().getValue());
	    }
	    return currentNode;
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	return null;

    }

}
