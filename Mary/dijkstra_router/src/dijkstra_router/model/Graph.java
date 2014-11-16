package dijkstra_router.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Graph{

	private HashMap<String, GenericNode> map = new HashMap<String, GenericNode>();
	
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
                    System.out.println("Erreur : pointeur null");
            }
            catch (IOException a) 
            {
                    System.out.println("Problème d'IO  en lecture");
            }
        }
        
        public void initEdge(){
            int x = 0;
            int y = 0;
            GenericNode node, verNode, horNode, botNode,leftNode;
            while(x < 48){
                y=0;
                while(y < 18){
                    node = this.getNode(x+":"+y);
                    if(!node.getValue().equals("wall") && !node.isActive()){
                        
                        horNode = this.getNode((x-1)+":"+y);
                        verNode = this.getNode(x+":"+(y-1));
                        leftNode = this.getNode((x+1)+":"+y);
                        botNode = this.getNode(x+":"+(y+1));
                        
                        if(horNode != null){
                            if(!horNode.getValue().equals("wall") ){
                                //if(horNode.isActive() )
                                    //System.out.println("trouve horizontale x "+x +" y" +y+ "    " + horNode.isActive());
                                if(horNode.getValue().equals("grass"))
                                    new GenericEdge(node, horNode, new Distance(2));
                                else
                                    new GenericEdge(node, horNode, new Distance(1)); 
                                //System.out.println("je créer un edge entre " + node + " et " + horNode);
                            }
                        }
                        if(botNode != null){
                            if(!botNode.getValue().equals("wall") ){
                                //if(horNode.isActive() )
                                    //System.out.println("trouve horizontale x "+x +" y" +y+ "    " + horNode.isActive());
                                if(botNode.getValue().equals("grass"))
                                    new GenericEdge(node, botNode, new Distance(2));
                                else
                                    new GenericEdge(node, botNode, new Distance(1)); 
                                //System.out.println("je créer un edge entre " + node + " et " + horNode);
                            }
                        }
                        if(leftNode != null){
                            if(!leftNode.getValue().equals("wall")){
                                 //if(verNode.isActive() )
                                    //System.out.println("trouve verticale x "+x +" y" +y+ "    " + verNode.isActive());
                                if(leftNode.getValue().equals("grass"))
                                    new GenericEdge(node, leftNode, new Distance(2));
                                else
                                    new GenericEdge(node, leftNode, new Distance(1));                        
                                //System.out.println("je créer un edge entre " + node + " et " + verNode);
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
        
        public ArrayList<GenericNode> getNodes(){
            ArrayList<GenericNode> nodes = new ArrayList<GenericNode>();
            for(String s : map.keySet()){
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
        
        public void checkEntry(){
            HashMap<String, GenericNode> map2 = new HashMap<String, GenericNode>();
            GenericNode nodes = null;
            for(String s : map.keySet()){
                nodes = map.get(s);
                if(nodes.isActive()) {
                   nodes.setDistance(20);
                    System.out.println(nodes.isActive());
                }
                else
                    nodes.setDistance(Double.POSITIVE_INFINITY);
            }
        }
        

}
