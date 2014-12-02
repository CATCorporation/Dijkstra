/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Suiken
 */
public class Dijkstra {

	public static GenericNode findBestWay(Graph graph, GenericNode depart) {

		// L'arrayList va représenter la position de chaque souris à la fin de l'algo
		PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
		GenericNode currentNode = depart;
		GenericNode lastNode = null;

		GenericEdge currentEdge = null;
		GenericEdge lastEdge = null;
		
		EdgeList edgeUsed = new EdgeList();
		
		try {

			while (!currentNode.getValue().equals("end")) {

				// J'ajoute tout les edges d'un node dans la queue
				for (GenericEdge e : (ArrayList<GenericEdge>) currentNode.getEdges()) {

					queue.push(new Element(e));

				}

				// Je retire l'edge avec la plus petite distance pour en faire un chemin
				currentEdge = queue.pop().getValue();
				
				// Ici je cherche le noeud précédent s'il y en a un
				if(currentEdge.getOther(depart) != null){
					// le noeud d'après le départ
					currentNode = currentEdge.getOther(depart);
				}else{
					// le noeud avec une chaine déjà créée
					lastNode = currentEdge.getNodeWithPrevious();
					currentNode = currentEdge.getOther(lastNode);
					for(GenericEdge e : lastNode.getEdges()){
						if(e.getOther(currentNode) != null) lastEdge = e;
					}
				}
				if(!edgeUsed.contains(lastEdge) || !edgeUsed.contains(currentEdge)){
					currentNode.setPrevious(currentEdge.getOther(currentNode));
				}

				// Mise à jour de la distance
				if (currentEdge.getOther(depart) == null && !edgeUsed.contains(lastEdge) && !edgeUsed.contains(currentEdge)) {
					
					currentNode.addDistance(lastEdge);
					edgeUsed.add(currentEdge);
					
					
				}
				if(!edgeUsed.contains(currentEdge)){
					edgeUsed.add(currentEdge);
				}
				
				currentNode.getEdges().remove(currentEdge);
				if(lastNode != null){
					lastNode.getEdges().remove(currentEdge);
				}
				
			}
			return currentNode;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	public static ArrayList<Mouse> findBestWays(Graph graph, ArrayList<Mouse> mice){
		for(Mouse m : mice){
			m.setFinishFound(findBestWay(graph, m.getPosition()));
			//System.out.println(findBestWay(graph, m.getPosition()).toString());
		}
		return mice;
	}

}
