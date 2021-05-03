
public class EdgeListMain {

	public static void main(String[] args) { 
		Integer[] vertices = {2, 4, 6, 8, 10};
		Integer[][] vertPairs = { {2,4}, {4,6}, {2,10}, {8, 6}, {4,8}};
		
		AdjacencyMatrixGraph<Integer, Integer> adjMat = new AdjacencyMatrixGraph<Integer, Integer>(vertices, vertPairs);
	}
	
}
