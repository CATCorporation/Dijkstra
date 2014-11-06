package interfaces;

import java.util.List;

public interface INode<String, Object> extends IElement{
    public String getId();
    public Object getValue();
    @SuppressWarnings("rawtypes")
	public List<IEdge> getEdges();
}
