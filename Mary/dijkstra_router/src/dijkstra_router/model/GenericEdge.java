package dijkstra_router.model;

import java.util.ArrayList;
import java.util.HashMap;



public class GenericEdge{

	private HashMap<String,Object> attributes = new HashMap<String, Object>();
	private GenericNode nodeOne, nodeTwo;
        private Distance value;
        private ArrayList<GenericEdge> pile = new ArrayList<>();
	
	public GenericEdge(){
		
	}

	public GenericEdge(GenericNode node1,
			GenericNode node2, Distance value) {
		// TODO Auto-generated constructor stub
		this.nodeOne = node1;
		this.nodeTwo = node2;
		this.value = value;
		this.nodeOne.getEdges().add(this);
		this.nodeTwo.getEdges().add(this);
	}

	public Distance getAttribute() {
		// TODO Auto-generated method stub
		return value;
	}

	
	public GenericNode getOther(GenericNode node) {
		// TODO Auto-generated method stub
		if(node == nodeOne)
			return nodeTwo;
		else if(node == nodeTwo)
			return nodeOne;
		else
			return null;
	
	}

	public void setAttribute(int Distance) {
		// TODO Auto-generated method stub
		value.addValue(Distance);
	}

        public void push(GenericEdge e){
            pile.add(e);
        }
        
        public ArrayList<GenericEdge> getPile(){
            return pile;
        }
    @Override
    public String toString() {
        return nodeOne + " - " + nodeTwo;
    }

}
