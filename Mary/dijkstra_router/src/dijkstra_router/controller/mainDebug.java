/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra_router.controller;

import dijkstra_router.model.Dijstra;
import dijkstra_router.model.GenericNode;
import dijkstra_router.model.Graph;

/**
 *
 * @author Lucas
 */
public class mainDebug {
    
    public static void main(String[] args) {
        
        Graph graph = new Graph();
        graph.initGraph("./ressources/map.txt");
        GenericNode depart = graph.getNode("5:16");
       GenericNode arriveOne = graph.getNode("5:2"), arriveTwo = graph.getNode("43:1"), arrive = null;
       arriveOne.setValue("Sortie");
       arriveTwo.setValue("Sortie");
       temp : while(depart != arriveOne && depart != arriveTwo){
            graph.initEdge();
            
            //System.out.println("a");
            //System.out.println("Je part de " + depart);
           arrive = Dijstra.findeBestWay2(graph, depart);
            while(arrive.previous != depart){
                 arrive = arrive.previous;
                 //System.out.println("Depart " + depart);
            }
            depart = arrive;
            System.out.println("Je doit partir en " + depart);


       }
    }
}
