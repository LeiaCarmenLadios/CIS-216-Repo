import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AdjacencyMatrixGraph<V extends Integer, E> implements Graph<V, E>{

	
	
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
		
		public InEdge(InVertex<V> to, InVertex<V> from, E element) {
			this.to = to;
			this.from = from;
			this.element = element;
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
	
	public AdjacencyMatrixGraph(int dimensions) {
		adjMat = new int[dimensions][dimensions];
		vertices = new InVertex[dimensions];
		edges = new InEdge[dimensions * (dimensions - 1)];
		
	}
	
	private void formMatrix() {
		for(int i = 0; i < edges.length; i++) {
			if(edges[i] != null) {
				adjMat[edges[i].getToVertex().getIndex()]
						[edges[i].getFromVertex().getIndex()] = 1;
				adjMat[edges[i].getFromVertex().getIndex()]
						[edges[i].getToVertex().getIndex()] = 1;
			}
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
				build += adjMat[i][j] + "  ";
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

	@Override
	public Vertex<V> insertVertex(V element) {
		// TODO Auto-generated method stub
		boolean added = false;
		InVertex<V> newElement = new InVertex<V>(element);
		
		for(int i = 0; i < vertices.length && !added; i++) {
			if(vertices[i] == null) {
				vertices[i] = newElement;
				vertices[i].setIndex(i);
				added = true;
			}
		}
		
		if(!added) {
			System.out.println("It has not been added. There is no more "
					+ "space to add this element.");
		}
		
		return newElement;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> vertOne, Vertex<V> vertTwo, E element) {
		// TODO Auto-generated method stub
		boolean added = false;
		InVertex<V> vert1 = (InVertex<V>) vertOne;
		InVertex<V> vert2 = (InVertex<V>) vertTwo;
		InEdge<E> newElement = new InEdge<E>(vert1, vert2, element);
		
		for(int j = 0; j < edges.length; j++) {
			if(edges[j] == null) {
				j++;
			}
			else {
				if(edges[j].getToVertex().getElement() == vert1.getElement() &&
				   edges[j].getFromVertex().getElement() == vert2.getElement()) {
					return null;
				}
			}
		}
		
		for(int i = 0; i < edges.length && !added; i++) {
			if(edges[i] == null) {
				edges[i] = newElement;
				added = true;
				System.out.println("TO: "  +  edges[i].getToVertex().getIndex() + " FROM: " + edges[i].getFromVertex().getIndex());
			}
			//System.out.println(edges[i].getElement() + " ");
		}
		
		if(!added) {
			System.out.println("It has not been added. There is no more "
					+ "space to add this element.");
		}
	
		
		return newElement;
	}
	
	public void buildMaze() {
		Random generator = new Random();
		for(int i = 0; i < vertices.length; i++) {
			this.insertVertex((V) new Integer(generator.nextInt(100 + 1)));
			System.out.println(vertices[i].getElement() + " " + vertices[i].getIndex());
		}
		
		System.out.println(edges.length);
		int randomEdges = generator.nextInt(edges.length/2) + adjMat.length;
		System.out.println(randomEdges);
		for(int j = 0; j < randomEdges ; j++) {
			int to = generator.nextInt(vertices.length);
			int from = generator.nextInt(vertices.length);
			
			while(to > from || to == from) {
				if(to > from) {
					//System.out.println(to + " " + from);
					int temp = from;
					from = to;
					to = temp;
					//System.out.println(to + " " + from + "\n\n");
				}
				if(to == from) {
					to = generator.nextInt(vertices.length);
				}
			}
			
			
			this.insertEdge(vertices[to], vertices[from], (E)new Integer(j));
			
			
		}
		
		this.formMatrix();
		System.out.println(this);
	
	}

	@Override
	public void removeVerted(V vert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(E edge) {
		// TODO Auto-generated method stub
		
	}





}
