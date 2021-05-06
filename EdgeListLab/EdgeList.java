import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class EdgeList<V, E> implements Graph<V, E>{

	
	
	public class InVertex<V> implements Vertex<V>{
		
		private V element;
		private int index;
		private ArrayList<InEdge<E>> edgeList;
		
		public InVertex(V element) {
			this.element = element;
			edgeList = new ArrayList<InEdge<E>>(); //store corresponding edge elements 
		}
		
		public ArrayList<InEdge<E>> getVertexEdges() {
			return edgeList;
		}
		
		public void addEdge(InEdge<E> edge) {
			edgeList.add(edge);
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
	
	public class InEdge<E> implements Edge<E>{
		private E element;
		private InVertex<V> to;
		private InVertex<V> from; 
		
		public InEdge(E element) {
			this.element = element;
		}
		
		public InEdge(InVertex<V> to, InVertex<V> from, E element) {
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
	
	public EdgeList(ArrayList<V> v, ArrayList<V> e) {
		
		vertices = new ArrayList<InVertex<V>>();
		edges = new ArrayList<InEdge<E>>();
		
		
		for(int i = 0; i < v.size(); i++) {
			InVertex<V> vert = new InVertex<V>(v.get(i));
			this.vertices.add(vert);
		}
		
		Random r = new Random();
		Character c = (char)(r.nextInt(26) + 'a');
		
		for(int j = 0; j < e.size(); j += 2) {
				InVertex<V> from = new InVertex<V>(e.get(j));
				InVertex<V> to = new InVertex<V>(e.get(j + 1));
				InEdge<E> edge = new InEdge<E>(to,from, (E) new Character(c));
				this.edges.add(edge);
			
		}
	
		this.formEdgeList();
		
	}
	
	private void formEdgeList() {
		
		for(int i = 0; i < vertices.size(); i++) {
			for(int j = 0; j < edges.size(); j++) {
				if(vertices.get(i).getElement().equals(edges.get(j).getFromVertex().getElement()) 
				 || vertices.get(i).getElement().equals(edges.get(j).getToVertex().getElement())) {
					vertices.get(i).addEdge(edges.get(j));
				}
			}
		}
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
