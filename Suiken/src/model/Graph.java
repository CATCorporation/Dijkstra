package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	protected HashMap<String, GenericNode> map = new HashMap<String, GenericNode>();
	private String path = "./ressources/map.txt";
	private ArrayList<GenericNode> starts = new ArrayList<>();

	public Graph() {

	}

	public void initGraph() {

		BufferedReader file;
		String line;
		String name, id;
		int y = 0;
		try {
			// Ca c'est pour lire le fichier
			file = new BufferedReader(new FileReader(path));
			// Initialisation des edges en fonction de ce qu'il y a dans le
			// fichier map.txt
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
						GenericNode start = new GenericNode(id, name);
						this.registerNode(start);
						starts.add(start);
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

	public HashMap<String, GenericNode> getMap() {
		return map;
	}

	public void setMap(HashMap<String, GenericNode> map) {
		this.map = map;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<GenericNode> getStarts() {
		return starts;
	}

	public void setStarts(ArrayList<GenericNode> starts) {
		this.starts = starts;
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

						// Ca c'est pour mettre les distances/ en fonction du type de case
						updateEdges(horNode, verNode, leftNode, botNode, node); 
					}
				}
				y++;
			}
			x++;
		}
	}

	private void updateEdges(GenericNode horNode, GenericNode verNode,
			GenericNode leftNode, GenericNode botNode, GenericNode node) {

		updateEdge(node, horNode);
		updateEdge(node, verNode);
		updateEdge(node, leftNode);
		updateEdge(node, botNode);

	}

	private void updateEdge(GenericNode node, GenericNode otherNode) {

		if (otherNode != null) {
			if (!otherNode.getValue().equals("wall")) {
				if (otherNode.getValue().equals("grass")) {
					new GenericEdge(node, otherNode, new Distance(2));
				} else {
					new GenericEdge(node, otherNode, new Distance(1));
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
