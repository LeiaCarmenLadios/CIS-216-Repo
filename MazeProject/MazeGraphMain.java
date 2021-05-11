import java.util.ArrayList;
import java.util.Iterator;

public class MazeGraphMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyMatrixGraph<Integer, String> adjMat =
				new AdjacencyMatrixGraph<Integer, String>(5);
		
		
		adjMat.buildMaze();
		System.out.println(adjMat);
		
		adjMat.DFT(adjMat);
	}

}
