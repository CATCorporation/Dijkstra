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
            StringBuffer name;
            int y = 0;
            try
            {
                    file = new BufferedReader(new FileReader(path)) ;
                    while ((line = file.readLine()) != null) 
                    {
                        for(int i = 0; i < line.length(); i++){
                            
                            name = new StringBuffer(i + " : " + y + " : ");
                            if(line.charAt(i) == ' '){
                                name.append("void");
                                this.registerNode(new Node(name.toString()));
                            }else if(line.charAt(i) == 'G'){
                                name.append("grass");
                                this.registerNode(new Node(name.toString()));
                            }else if(line.charAt(i) == 'A'){
                                name.append("end");
                                this.registerNode(new Node(name.toString()));
                            }else if(line.charAt(i) == 'G'){
                                name.append("start");
                                this.registerNode(new Node(name.toString()));
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
		map.put((String) node.name, node);
	}

	public void unregisterNode(Object key) {
		// TODO Auto-generated method stub
		map.remove(key);
		
	}

}
