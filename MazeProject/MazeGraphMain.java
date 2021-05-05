import java.util.ArrayList;
import java.util.Iterator;

public class MazeGraphMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyMatrixGraph<Integer, String> adjMat =
				new AdjacencyMatrixGraph<Integer, String>(5);
		
		
		adjMat.buildMaze();
//		Iterator it = adjMat.vertices().iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next().toString() +" ");
//		}
//		
	}

}
