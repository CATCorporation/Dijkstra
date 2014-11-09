package dijkstra_router;

import dijkstra_router.LinkSimple;
import java.util.ArrayList;
import java.util.Comparator;


public class LinkedPriorityQueue{

	private ArrayList<Object> list = new ArrayList<Object>();
	private Comparator c;
	
	
	public LinkedPriorityQueue(Comparator c){
		this.c = c;
	}
	
	
	public void add(Object arg0) {
		// TODO Auto-generated method stub
                int i = 0;
                if(list.isEmpty()){
                    list.add(arg0);
                }else{
                    while( i < list.size()){
                        if(c.compare(arg0, list.get(i)) < 0){
                            break;
                        }
                        i++;
                        
                    }
                    
                    list.add(i, arg0);
                }
                
		
	}

	
	public Object peek() {
		// TODO Auto-generated method stub
		return list.get(0);
	}

	
	public Object remove() {
		// TODO Auto-generated method stub
		return list.remove(0);
	}

}