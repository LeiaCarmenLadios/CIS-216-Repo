import java.util.Iterator;

public class MazeGraphMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyMatrixGraph<Integer, String> adjMat =
				new AdjacencyMatrixGraph<Integer, String>(3);
		adjMat.insertVertex(new Integer(4));
		adjMat.insertVertex(new Integer(7));
//		Iterator it = adjMat.vertices().iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next().toString() +" ");
//		}
//		
	}

}
