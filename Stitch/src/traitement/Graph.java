package traitement;


import diksjtra.source.Edge;
import diksjtra.source.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Graph{

	protected HashMap<String, Node> map = new HashMap<String, Node>();
	
	public Graph(){
		
	}
        
        public void initGraph(String path){
            
            BufferedReader file ;
            String line;
            String name, id;
            int y = 0;
            try 
            {
                file = new BufferedReader(new FileReader(path)) ;
                while ((line = file.readLine()) != null) 
                {
                    for(int i = 0; i < line.length(); i++){

                        id = (i + ":" + y);
                        if(line.charAt(i) == ' '){
                            name = "void";
                            this.registerNode(new Node(id, name));
                        }else if(line.charAt(i) == 'G'){
                            name = "grass";
                            this.registerNode(new Node(id, name));
                        }else if(line.charAt(i) == 'A'){
                            name = "end";
                            this.registerNode(new Node(id, name));
                        }else if(line.charAt(i) == 'D'){
                            name = "start";
                            this.registerNode(new Node(id, name));
                        }else{
                            name = "wall";
                            this.registerNode(new Node(id, name));
                        }                            
                    }
                    y++;
                }
                file.close();
            }//try
            catch (NullPointerException a)
            {
                    System.out.println("Erreur : pointeur null");
            }
            catch (IOException a) 
            {
                    System.out.println("Problème d'IO  en lecture");
            }
        }
        
        public void initEdge(String key){
            int x = 0,maxX = 0;
            int y = 18, maxY = 0;
            Node node, verNode, horNode, leftNode, topNode;
            try{
                maxX = Integer.parseInt(key.split(":")[0] + 5) ;
                maxY = Integer.parseInt(key.split(":")[1]) ;                
                if(maxX > 48 )
                    maxX = 48;
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            while(x < maxX){
                y=18;
                while(y >= 0){
                    System.out.println("y  = " + y);
                    node = this.getNode(x+":"+y);
                    if(node != null ){
                        node.clearLien(node);
                        if(!node.getName().equals("wall") ){

                            horNode = this.getNode((x+1)+":"+y);
                            verNode = this.getNode(x+":"+(y+1));
                            leftNode = this.getNode((x-1)+":"+y);
                            topNode = this.getNode(x+":"+(y-1));
                             
                            if(horNode != null){
                                if(!horNode.getName().equals("wall") && !horNode.getActif() ){
                                    if(horNode.getName().equals("grass"))
                                        node.addLien(node, new Edge ( horNode, 2) );
                                    else
                                        node.addLien(node, new Edge ( horNode, 1) );
                                }
                            }
                            if(leftNode != null){
                                if(!leftNode.getName().equals("wall") && !leftNode.getActif() ){
                                    if(leftNode.getName().equals("grass"))
                                        node.addLien(node, new Edge ( leftNode, 2) );
                                    else
                                        node.addLien(node, new Edge ( leftNode, 1) );
                                }
                            }

                            if(verNode != null){
                                if(!verNode.getName().equals("wall") && !verNode.getActif() ){
                                    if(verNode.getName().equals("grass"))
                                        node.addLien(node, new Edge ( verNode, 2) );
                                    else
                                        node.addLien(node, new Edge ( verNode, 1) );
                                }
                            }    
                            if(topNode != null){
                                if(!topNode.getName().equals("wall") && !topNode.getActif() ){
                                    if(topNode.getName().equals("grass"))
                                        node.addLien(node, new Edge ( topNode, 2) );
                                    else
                                        node.addLien(node, new Edge ( topNode, 1) );
                                }
                            }   
                        }                        
                    }
                    y--;
                }                
                x++;
            }
        }
        
	public Node getNode(String key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}
        
        public Node [] getNodes(){
            Node [] tab = new Node[map.size()];
            int i = 0;
            for(String s : map.keySet()){
                tab[i] = (map.get(s));
                i++;
            }
            
            return tab;
        }
        
	public void registerNode(Node node) {
		// TODO Auto-generated method stub
		map.put(node.getId(), node);
	}

	public void unregisterNode(String key) {
		// TODO Auto-generated method stub
		map.remove(key);		
	}
        
        public void checkEntry(){
            Node nodes = null;
            for(String s : map.keySet()){
                nodes = map.get(s);                
                nodes.setMinDistance(Double.POSITIVE_INFINITY);
                nodes.clearLien(nodes);
                
            }
        }
        

}
