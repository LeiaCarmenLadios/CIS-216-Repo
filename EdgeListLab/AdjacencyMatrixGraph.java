import java.util.ArrayList;

public class AdjacencyMatrixGraph<V, E> implements Graph<V, E>{

	
	private class InVertex<V> implements Vertex<V>{
		
		private V element;
		private int index;
		
		public InVertex(V element) {
		
			this.element = element;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
		@Override
		public V getElement() {
			// TODO Auto-generated method stub
			return element;
		}
		
	} //end of nested InVertex class
	
	private class InEdge<E> implements Edge<E>{
		private E element;
		private InVertex<V> to;
		private InVertex<V> from; 
		
		public InEdge(E element) {
			this.element = element;
		}
		
		public InEdge(InVertex<V> to, InVertex<V> from) {
			this.to = to;
			this.from = from;
		}
		
		@Override
		public E getElement() {
			// TODO Auto-generated method stub
			return element;
		}
		
		public InVertex<V> getToVertex(){
			return to; 
		}
		
		public InVertex<V> getFromVertex(){
			return from;
		}
		
	} //end of nested InVertex class
	
	private int[][] adjMat;
	private InVertex<V>[] vertices;
	private InEdge<E>[] edges;
	
	public AdjacencyMatrixGraph(V[] vertices, V[][] vertexPairs) {
		this.vertices = new InVertex[vertices.length];
		this.edges = new InEdge[vertexPairs.length];
		adjMat = new int[vertices.length][vertices.length];
		for(int i = 0; i < vertices.length; i++) {
			InVertex<V> vert = new InVertex<V>(vertices[i]);
			vert.setIndex(i);
			this.vertices[i] = vert;
			
			System.out.println(this.vertices[i].getElement());
		}
		
		for(int j = 0; j < vertexPairs.length; j++) {
			
			InVertex<V> toVertex = null;
			InVertex<V> fromVertex = null;
			V to = vertexPairs[j][0];
			V from = vertexPairs[j][1];
			for(int k = 0; k < this.vertices.length; k++) {
				if(to == this.vertices[k].getElement()) {
					toVertex = this.vertices[k];
				}
				if(from == this.vertices[k].getElement()) {
					fromVertex = this.vertices[k];
				}
			}
			InEdge<E> edge = new InEdge<E>(toVertex, fromVertex);
			
			System.out.println("edge:\t v1: " + toVertex.getElement() + " " + toVertex.getIndex() + " v2: " + fromVertex.getElement() + " " + fromVertex.getIndex());
			this.edges[j] = edge;
		}
		
		
	}
	
	private void formMatrix() {
		
	}
	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return vertices.length;
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return edges.length;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge<E> getEdge(Vertex<V> vertOne, Vertex<V> vertTwo) {
		// TODO Auto-generated method stub
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].getToVertex().getElement() == vertOne.getElement() &&
			   edges[i].getFromVertex().getElement() == vertTwo.getElement()) {
				return edges[i];
			}
		}
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
