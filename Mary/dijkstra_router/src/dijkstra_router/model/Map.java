/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_router.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 626
 */
public class Map {

    //fonction de lecture
    public String lire(String path) {
	BufferedReader lect;
	String tmp = "";
	try {
	    lect = new BufferedReader(new FileReader(path));
	    while (lect.ready() == true) {
		tmp += lect.readLine() + "\n";
	    }
	    lect.close();
	}//try
	catch (NullPointerException a) {
	    System.out.println("Erreur : pointeur null");
	} catch (IOException a) {
	    System.out.println("Problème d'IO  en lecture");
	}
	return tmp;
    }
}
