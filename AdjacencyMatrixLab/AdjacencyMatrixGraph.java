import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyMatrixGraph<V, E> implements Graph<V, E>{

	
	
	private static class InVertex<V> implements Vertex<V>{
		
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
			
			
			this.edges[j] = edge;
		}
		
		this.formMatrix();
	}
	
	private void formMatrix() {
		for(int i = 0; i < edges.length; i++) {
			adjMat[edges[i].getToVertex().getIndex()]
					[edges[i].getFromVertex().getIndex()] = 1;
			adjMat[edges[i].getFromVertex().getIndex()]
					[edges[i].getToVertex().getIndex()] = 1;
		}
	}
	
	public String toString() {
		String build = "Adjacency Matrix: \n\n\t";
		
		for(int k = 0; k < vertices.length; k ++) {
			build += vertices[k].getElement() + " ";
		}
		build += "\n";
		for(int i = 0; i < adjMat.length; i++) {
			build += vertices[i].getElement() + "\t";
			for(int j = 0; j < adjMat[0].length; j++) {
				build += adjMat[i][j] + " ";
			}
			build += "\n";
		}
		
		
		return build;
	}
	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return vertices.length;
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		return Arrays.asList(vertices);
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return edges.length;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return Arrays.asList(edges);
	}

	@Override
	public Edge<E> getEdge(Vertex<V> vertOne, Vertex<V> vertTwo) {
		// TODO Auto-generated method stub
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].getToVertex().getElement() 
					== vertOne.getElement() &&
			   edges[i].getFromVertex().getElement() 
			   == vertTwo.getElement()) {
				return edges[i];
			}
		}
		return null;
	}

	@Override
	public ArrayList<Vertex<V>> endVertices(Edge<E> edge) {
		// TODO Auto-generated method stub
		ArrayList<Vertex<V>> list = new ArrayList<Vertex<V>>();
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].equals(edge)) {
				list.add(edges[i].getToVertex());
				list.add(edges[i].getFromVertex());
			}
		}
		return list;
	}

	@Override
	public Vertex<V> opposite(Vertex<V> vert, Edge<E> edge) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].equals(edge)) {
				if(edges[i].getFromVertex().getElement()
						.equals(vert.getElement())) {
					return edges[i].getToVertex();
				}
				else {
					return edges[i].getFromVertex();
				}
			}
		}
		return null;
	}

	@Override
	public int outDegree(Vertex<V> vert) {
		// TODO Auto-generated method stub
		
		int counter = 0;
		
		for(int i = 0; i < vertices.length; i++) {
			for(int j = 0; j < adjMat.length; j++) {
//				System.out.println(vertices[i].getElement().equals(vert.getElement()));
//				System.out.println(adjMat[i][j]);
				if(vertices[i].getElement().equals(vert.getElement())) {
					if(adjMat[i][j] == 1) {
						counter++;
					}
				}
			}
		}
		
		
		return counter;
	}

	@Override
	public int inDegree(Vertex<V> vert) {
		// TODO Auto-generated method stub

		int counter = 0;
		
		for(int i = 0; i < vertices.length; i++) {
			for(int j = 0; j < adjMat.length; j++) {
//				System.out.println(vertices[i].getElement().equals(vert.getElement()));
//				System.out.println(adjMat[i][j]);
				if(vertices[i].getElement().equals(vert.getElement())) {
					if(adjMat[i][j] == 1) {
						counter++;
					}
				}
			}
		}
		
		
		return counter;
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> vert) {
		// TODO Auto-generated method stub
		
		ArrayList<Edge<E>> outEdges = new ArrayList<Edge<E>>(); 
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].getToVertex().getElement().equals(vert.getElement()) ||
				edges[i].getFromVertex().getElement().equals(vert.getElement())) {
				outEdges.add(edges[i]);
			}
		}
		return outEdges;
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> vert) {
		// TODO Auto-generated method stub
		ArrayList<Edge<E>> inEdges = new ArrayList<Edge<E>>(); 
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].getToVertex().getElement().equals(vert.getElement()) ||
				edges[i].getFromVertex().getElement().equals(vert.getElement())) {
				inEdges.add(edges[i]);
			}
		}
		return inEdges;
	}





}
