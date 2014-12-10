package dijkstra_router.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Graph{

	protected HashMap<String, GenericNode> map = new HashMap<String, GenericNode>();
	
	public Graph(){
		
	}
        
        /**
         * initialize the graph via a text file
         * @param path path of text file 
         */
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
                            this.registerNode(new GenericNode(id, name));
                        }else if(line.charAt(i) == 'G'){
                            name = "grass";
                            this.registerNode(new GenericNode(id, name));
                        }else if(line.charAt(i) == 'A'){
                            name = "end";
                            this.registerNode(new GenericNode(id, name));
                        }else if(line.charAt(i) == 'D'){
                            name = "start";
                            this.registerNode(new GenericNode(id, name));
                        }else{
                            name = "wall";
                            this.registerNode(new GenericNode(id, name));
                        }                            
                    }
                    y++;
                }
                file.close();
            }//try
            catch (NullPointerException a)
            {
                    System.err.println("Erreur : pointeur null");
            }
            catch (IOException a) 
            {
                    System.err.println("Problème d'IO  en lecture");
            }
        }
        
        /**
         * create edge for each node
         * @param limitH limit of horizontal axis
         * @param limitV limit of vertical axis
         */
        public void initEdge(int limitH, int limitV){
            int x = 0;
            int y = 0;
            GenericNode node, verNode, horNode, botNode,leftNode;
            
            this.checkEntry();
            
            while(x < limitH){
                y=0;
                while(y < limitV){
                    node = this.getNode(x+":"+y);
                    if(node != null){
                        if(!node.getValue().equals("wall")){
                            node.setEdges(null);
                            horNode = this.getNode((x-1)+":"+y);
                            verNode = this.getNode(x+":"+(y-1));
                            leftNode = this.getNode((x+1)+":"+y);
                            botNode = this.getNode(x+":"+(y+1));

                            if(horNode != null){
                                if(!horNode.getValue().equals("wall")){
                                    if(horNode.getValue().equals("grass"))
                                        new GenericEdge(node, horNode, new Distance(2));
                                    else
                                        new GenericEdge(node, horNode, new Distance(1)); 
                                }
                            }

                            if(verNode != null){
                                if(!verNode.getValue().equals("wall")){
                                    if(verNode.getValue().equals("grass"))
                                        new GenericEdge(node, verNode, new Distance(2));
                                    else
                                        new GenericEdge(node, verNode, new Distance(1)); 
                                }
                            }                        
                        }
                    }
                    y++;
                }
                
                x++;
            }
        }
        
	public GenericNode getNode(String key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}
        
        /**
         * Give all nodes in the graph as a list
         * @return Arraylist of node
         */
        public ArrayList<GenericNode> getNodes(){
            ArrayList<GenericNode> nodes = new ArrayList<GenericNode>();
            for(String s : map.keySet()){
                nodes.add(map.get(s));
            }
            
            return nodes;
        }
        
        /**
         * add a node in the graph
         * @param node node at add
         */
	public void registerNode(GenericNode node) {
		// TODO Auto-generated method stub
		map.put(node.getKey(), node);
	}

        /**
         * Remove a node in the graph
         * @param key key of node at remove
         */
	public void unregisterNode(String key) {
		// TODO Auto-generated method stub
		map.remove(key);		
	}
        
        public void checkEntry(){
            GenericNode nodes = null;
            for(String s : map.keySet()){
                nodes = map.get(s);                
                nodes.setDistance(Double.POSITIVE_INFINITY);
            }
        }
        
        public boolean poPornoT( GenericNode node){
            int x = 0;
            int y = 0;
            GenericNode verNode, horNode, botNode,leftNode;            
            
            try{
                x = Integer.parseInt(node.getKey().split(":")[0]);
                y = Integer.parseInt(node.getKey().split(":")[1]);
            }catch (NumberFormatException e){
                System.err.println(" pop or not erreur recuperation coordonée node");
            }
                    if(node != null){
                            
                        horNode = this.getNode((x-1)+":"+y);
                        verNode = this.getNode(x+":"+(y-1));
                        leftNode = this.getNode((x+1)+":"+y);
                        botNode = this.getNode(x+":"+(y+1));

                        if( horNode != null &&  !horNode.getValue().equals("wall") )
                                return true; 
                        if(verNode != null && !verNode.getValue().equals("wall") )
                            return true;
                        if(leftNode != null && !leftNode.getValue().equals("wall") )
                            return true;
                        if(botNode != null   && !botNode.getValue().equals("wall") )
                            return true;
                        
                    }
                
            
               
            return false;
        }

}
