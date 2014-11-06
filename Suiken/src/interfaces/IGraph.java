package interfaces;


public interface IGraph<String,Object> {
	@SuppressWarnings("rawtypes")
	public INode getNode(String key);
	public void registerNode(INode<String,Object> node);
	public void unregisterNode(String key);
}

