import java.util.ArrayList;

public interface Graph<V, E> { 
	int numVertices();
	
	Iterable<Vertex<V>> vertices();
	
	int numEdges();
	
	Iterable<Edge<E>> edges();
	
	Edge<E> getEdge(Vertex<V> vertOne, Vertex<V> vertTwo);
	
	ArrayList<Vertex<V>> endVertices(Edge<E> edge);
	
	Vertex<V> opposite(Vertex<V> vert, Edge<E> edge);
	
	int outDegree(Vertex<V> vert);
	
	int inDegree(Vertex<V> vert);
	
	Iterable<Edge<E>> outgoingEdges(Vertex<V> vert);
	
	Iterable<Edge<E>> incomingEdges(Vertex<V> vert);
	
	Vertex<V> insertVertex(V element);
	
	Edge<E> insertEdge(Vertex<V> vertOne, Vertex<V> vertTwo, E element);
	
	void removeVerted(V vert);
	
	void removeEdge(E edge);
	
}
