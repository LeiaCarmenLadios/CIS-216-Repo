import java.util.ArrayList;

public class AdjacencyMatrixGraph<V, E> implements Graph<V, E>{

	
	private class InVertex<V> implements Vertex<V>{
		
		private V element;
		
		public InVertex(V element) {
			this.element = element;
		}
		@Override
		public V getElement() {
			// TODO Auto-generated method stub
			return element;
		}
		
	} //end of nested InVertex class
	
	private class InEdge<E> implements Edge<E>{
		private E element;
		
		public InEdge(E element) {
			this.element = element;
		}
		
		@Override
		public E getElement() {
			// TODO Auto-generated method stub
			return element;
		}
		
	} //end of nested InVertex class
	
	private Integer[][] adjMat;
	
	public AdjacencyMatrixGraph(V[] vertices, V[][] vertexPairs) {
		
		adjMat = new Integer[vertices.length][vertices.length];
		
		for(int i = 0; i < vertices.length; i++) {
			for(int j = 0; j < vertexPairs[0].length; j++) {
				if(vertices[i] == vertexPairs[j][0] ) {
					adjMat[i][j] = 1;
					System.out.print(vertices[i] + " " + vertexPairs[j][0] + " ");
					System.out.print(adjMat[i][j] + " \n");
				}
			}
		}
		
	}
	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge<E> getEdge(Vertex<V> vertOne, Vertex<V> vertTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vertex<V>> endVertices(Edge<E> edge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex<V> opposite(Vertex<V> vert, Edge<E> edge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outDegree(Vertex<V> vert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegree(Vertex<V> vert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<E> outgoingEdges(Vertex<V> vert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<E> incomingEdges(Vertex<V> vert) {
		// TODO Auto-generated method stub
		return null;
	}





}
