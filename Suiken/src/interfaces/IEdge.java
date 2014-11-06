package interfaces;

public interface IEdge<String,Object> {
	public INode<String,Object> getOther(INode<String,Object> me);
	public void setAttribute(String key, Object value);
	public Object getAttribute(String value);
}