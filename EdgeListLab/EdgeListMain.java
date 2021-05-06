import java.util.ArrayList;

public class EdgeListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		vertices.add(4);
		vertices.add(10);
		vertices.add(3);
		vertices.add(15);
		vertices.add(26);
		
		ArrayList<Integer> edges = new ArrayList<Integer>();
		edges.add(4);
		edges.add(10);
		edges.add(4);
		edges.add(3);
		edges.add(10);
		edges.add(15);
		edges.add(15);
		edges.add(26);
		
		
		
		EdgeList<Integer, Integer> list = new EdgeList<Integer,Integer>(vertices, edges);
		
	}

}
