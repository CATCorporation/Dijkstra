package controler;

import interfaces.IRouteResult;

import java.util.Comparator;

import model.GenericEdge;
import model.GenericNode;
import model.Graph;
import model.RouterDijkstra;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suiken
 */
public class Application {

    public static void main(String args[]) {

	//Pile
//        PriorityQueue pile = new PriorityQueue();
//        
//        System.out.println(pile.empty());
//
//        pile.push(new Element("1"));
//        pile.push(new Element("2"));
//        pile.push(new Element("3"));
//        pile.push(new Element("4"));
//        pile.push(new Element("5"));
//        pile.push(new Element("6"));
//        pile.push(new Element("7"));
//        pile.push(new Element("8"));
//        pile.push(new Element("9"));
//        pile.push(new Element("10"));
//        System.out.println(pile.empty());
//        System.out.println(pile.toString());
//
//        pile.push(new Element("11"));
//        System.out.println(pile);
//
//        pile.pop();
//
//        System.out.println(pile);
//
//        System.out.println(pile.peek().getValue());
//
//        System.out.println(pile.search("2"));


//	Dijkstra
	Graph graph = new Graph();

	// Build node.
	GenericNode paris = new GenericNode("Paris");
	GenericNode lyon = new GenericNode("Lyon");
	GenericNode grenoble = new GenericNode("Grenoble");
	GenericNode valence = new GenericNode("Valence");
	GenericNode gap = new GenericNode("Gap");
	GenericNode marseille = new GenericNode("Marseille");

	graph.registerNode(paris);
	graph.registerNode(lyon);
	graph.registerNode(grenoble);
	graph.registerNode(valence);
	graph.registerNode(gap);
	graph.registerNode(marseille);
	
	//System.out.println(graph.getNodes().toString());

	// Build edges
	new GenericEdge(paris, lyon, 400);
	new GenericEdge(lyon, grenoble, 100);
	new GenericEdge(lyon, valence, 100);
	new GenericEdge(grenoble, valence, 100);
	new GenericEdge(grenoble, gap, 100);
	new GenericEdge(gap, marseille, 150);
	new GenericEdge(valence, marseille, 250);

	RouterDijkstra router = new RouterDijkstra();
	router.setGraph(graph);
	router.setComparator(new Comparator<GenericEdge>(){
		
		@Override
		public int compare(GenericEdge o1, GenericEdge o2) {
			return 0;
		}
		
	});

	IRouteResult result = router.route(paris, marseille);
	System.out.println(result);

	graph.unregisterNode("Valence");

	result = router.route(paris, marseille);
	System.out.println(result);
    }
}
