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

		// L'arrayList va repr�senter la position de chaque souris � la fin de l'algo
		PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
		GenericNode currentNode = depart;
		GenericNode lastNode;

		GenericEdge currentEdge = null;
		GenericEdge lastEdge = null;
		
		try {

			while (!currentNode.getValue().equals("end")) {

				// J'ajoute tout les edges d'un node dans la queue
				for (GenericEdge e : (ArrayList<GenericEdge>) currentNode.getEdges()) {

					queue.push(new Element(e));

				}

				// Je retire l'edge avec la plus petite distance pour en faire un chemin
				currentEdge = queue.pop().getValue();
				
				System.out.println("edge �prendre : " + currentEdge.toString());
				System.out.println("taille avant " + currentEdge.getAttribute().getValue());
				
				// Ici je cherche le noeud pr�c�dent s'il y en a un
				if(currentEdge.getOther(depart) != null){
					// le noeud d'apr�s le d�part
					currentNode = currentEdge.getOther(depart);
				}else{
					// le noeud avec une chaine d�j� cr��e
					lastNode = currentEdge.getNodeWithPrevious();
					currentNode = currentEdge.getOther(lastNode);
					for(GenericEdge e : lastNode.getEdges()){
						if(e.getOther(currentNode) != null) lastEdge = e;
					}
				}
				currentNode.setPrevious(currentEdge.getOther(currentNode));

				// Mise � jour de la distance
				/*if (currentEdge.getOther(depart) == null) {
					
					currentNode.addDistance(lastEdge);
					
				}*/
				
				System.out.println("taille apr�s " + currentEdge.getAttribute().getValue());
				
				currentNode.getEdges().remove(currentEdge);
				
			}
			return currentNode;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

}
