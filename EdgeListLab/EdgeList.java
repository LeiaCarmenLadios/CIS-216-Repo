import java.util.ArrayList;
import java.util.Arrays;

public class EdgeList<V, E> implements Graph<V, E>{

	
	
	private static class InVertex<V> implements Vertex<V>{
		
		private V element;
		private int index;
		private int[] edgeList;
		
		public InVertex(V element) {
			this.element = element;
			edgeList = new int[100];
		}
		
		public int[] getVertexEdges() {
			return edgeList;
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
	
	private ArrayList<InVertex<V>> vertices;
	private ArrayList<InEdge<E>> edges;
	
	public EdgeList(int numVertices) {
		vertices = new ArrayList();
		edges = new ArrayList();
	}
	
	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public Iterable vertices() {
		// TODO Auto-generated method stub
		
		return vertices;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return edges.size();
	}

	@Override
	public Iterable edges() {
		// TODO Auto-generated method stub
		return edges;
	}

	@Override
	public Edge<E> getEdge(Vertex<V> vertOne, Vertex<V> vertTwo) {
		// TODO Auto-generated method stub
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i).getToVertex().getElement() 
					== vertOne.getElement() &&
			   edges.get(i).getFromVertex().getElement() 
			   == vertTwo.getElement()) {
				return edges.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Vertex<V>> endVertices(Edge<E> edge) {
		// TODO Auto-generated method stub
		ArrayList<Vertex<V>> list = new ArrayList<Vertex<V>>();
		
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i).equals(edge)) {
				list.add(edges.get(i).getToVertex());
				list.add(edges.get(i).getFromVertex());
			}
		}
		return list;
	}

	@Override
	public Vertex<V> opposite(Vertex<V> vert, Edge<E> edge) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i).equals(edge)) {
				if(edges.get(i).getFromVertex().getElement()
						.equals(vert.getElement())) {
					return edges.get(i).getToVertex();
				}
				else {
					return edges.get(i).getFromVertex();
				}
			}
		}
		return null;
	}

	@Override
	public int outDegree(Vertex<V> vert) {
		// TODO Auto-generated method stub
		
		int counter = 0;
		
		
		
		return counter;
	}

	@Override
	public int inDegree(Vertex<V> vert) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> vert) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> vert) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public String toString() {
		String build = "Edge List: \n\n\t";
		
		
		
		
		return build;
	}





}
