package dijkstra_router.model;


public class LinkSimple{

	
	private LinkSimple next;
	private Object value;
	
	public LinkSimple getNext() {
		return next;
	}

	
	public Object getValue() {
		return value;
	}

	
	public void setNext(LinkSimple arg0) {
		next = arg0;
	}

	
	public void setValue(Object arg0) {
		value = arg0;		
	}
}
