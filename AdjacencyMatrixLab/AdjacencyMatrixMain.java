import java.util.ArrayList;
import java.util.Iterator;

public class AdjacencyMatrixMain {

	public static void main(String[] args) { 
		Integer[] vertices = {2, 4, 6, 8, 10};
		Integer[][] vertPairs = { {2,4}, {4,6}, {2,10}, {8, 6}, {4,8}};
		
		AdjacencyMatrixGraph<Integer, Integer> adjMat = new AdjacencyMatrixGraph<Integer, Integer>(vertices, vertPairs);
		
		System.out.println(adjMat);
		Iterator it = adjMat.vertices().iterator();
		
		System.out.println();
		while(it.hasNext()) {
			Vertex<Integer> obj = (Vertex<Integer>) it.next();
			System.out.println("The number of out going connections" +
								" for the vertex element " + obj.getElement() 
								+ " is " + adjMat.outDegree(obj));
		}
	
		
	}
	
}
