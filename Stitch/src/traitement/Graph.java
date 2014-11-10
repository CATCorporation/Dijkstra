package traitement;


import diksjtra.source.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Graph{

	private HashMap<String, Node> map = new HashMap<String, Node>();
	
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
                            
                            id = (i + " : " + y + " : ");
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
        
        public void initEdge(){
            for(Node n : this.getNodes()){
                int x = Integer.parseInt(n.name.split(":")[0]);
                int y = Integer.parseInt(n.name.split(":")[1]);
                if(n.name.split(":")[2].equals("void")){
                    Node otherNode = this.getNode(x-1 + " : " + y );
                    if(otherNode != null){
                        if(!otherNode.name.equals("wall")){
                        
                        }
                    }
                }
            }
        }
        
	public Node getNode(Object key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}
        
        public ArrayList<Node> getNodes(){
            ArrayList<Node> nodes = new ArrayList<Node>();
            for(String s : map.keySet()){
                nodes.add(map.get(s));
            }
            
            return nodes;
        }
        
	public void registerNode(Node node) {
		// TODO Auto-generated method stub
		map.put((String) node.id, node);
	}

	public void unregisterNode(Object key) {
		// TODO Auto-generated method stub
		map.remove(key);
		
	}

}
