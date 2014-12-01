package dijkstra_router.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    protected HashMap<String, GenericNode> map = new HashMap<String, GenericNode>();

    public Graph() {

    }

    public void initGraph(String path) {

	BufferedReader file;
	String line;
	String name, id;
	int y = 0;
	try {
	    // Ca c'est pour lire le fichier
	    file = new BufferedReader(new FileReader(path));
	    // Initialisation des edges en fonction de ce qu'il y a dans le fichier map.txt
	    while ((line = file.readLine()) != null) {
		for (int i = 0; i < line.length(); i++) {
		    id = (i + ":" + y);
		    if (line.charAt(i) == ' ') {
			name = "void";
			this.registerNode(new GenericNode(id, name));
		    } else if (line.charAt(i) == 'G') {
			name = "grass";
			this.registerNode(new GenericNode(id, name));
		    } else if (line.charAt(i) == 'A') {
			name = "end";
			this.registerNode(new GenericNode(id, name));
		    } else if (line.charAt(i) == 'D') {
			name = "start";
			this.registerNode(new GenericNode(id, name));
		    } else {
			name = "wall";
			this.registerNode(new GenericNode(id, name));
		    }
		}
		y++;
	    }
	    file.close();
	} catch (NullPointerException a) {
	    System.out.println("Erreur : pointeur null");
	} catch (IOException a) {
	    System.out.println("Problème d'IO  en lecture");
	}

    }

    public void initEdge() {
	int x = 0, maxX = 48;
	int y;

	GenericNode node, verNode, horNode, botNode, leftNode;

	while (x < maxX) {
	    y = 0;
	    while (y < 18) {
		node = this.getNode(x + ":" + y);
		if (node != null) {
		    if (!node.getValue().equals("wall")) {

			horNode = this.getNode((x - 1) + ":" + y);
			verNode = this.getNode(x + ":" + (y - 1));
			leftNode = this.getNode((x + 1) + ":" + y);
			botNode = this.getNode(x + ":" + (y + 1));

			//updateEdges(horNode, verNode, leftNode, botNode); //Ca c'est pour mettre les distances en fonction du type de case
		    }
		}
		y++;
	    }

	    x++;
	}
    }

    private void updateEdges(GenericNode horNode, GenericNode verNode, GenericNode leftNode, GenericNode botNode) {

	updateEdge(horNode);
	updateEdge(verNode);
	updateEdge(leftNode);
	updateEdge(botNode);

    }

    private void updateEdge(GenericNode node) {

	if (node != null) {
	    if (!node.getValue().equals("wall")) {
		if (node.getValue().equals("grass")) {
		    new GenericEdge(node, node, new Distance(2));
		} else {
		    new GenericEdge(node, node, new Distance(1));
		}
	    }
	}

    }

    public GenericNode getNode(String key) {
	// TODO Auto-generated method stub
	return map.get(key);
    }

    public ArrayList<GenericNode> getNodes() {
	ArrayList<GenericNode> nodes = new ArrayList<GenericNode>();
	for (String s : map.keySet()) {
	    nodes.add(map.get(s));
	}

	return nodes;
    }

    public void registerNode(GenericNode node) {
	// TODO Auto-generated method stub
	map.put(node.getKey(), node);
    }

    public void unregisterNode(String key) {
	// TODO Auto-generated method stub
	map.remove(key);
    }

    public void checkEntry() {
	GenericNode nodes = null;
	for (String s : map.keySet()) {
	    nodes = map.get(s);
	    nodes.setDistance(Double.POSITIVE_INFINITY);

	}
    }

}
