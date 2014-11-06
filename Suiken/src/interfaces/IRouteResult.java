package interfaces;

public interface IRouteResult {
	Iterable<IElement> getRoute();
	
	
	@Override
	String toString();
}