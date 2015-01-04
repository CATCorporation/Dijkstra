package dijkstra_router.model;


public class Element{

    GenericEdge value;
    Element nextElement = null;
    
    public Element(){}
    
    public Element(Element e){
	value = e.getValue();
    }

    public Element(GenericEdge value) {
        this.value = value;
    }

    public Element getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    public GenericEdge getValue() {
        return value;
    }
}
