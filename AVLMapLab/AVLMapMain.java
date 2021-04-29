

public class AVLMapMain {
	public static void main(String[] args) {

		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer,String>();
		
		treeMap.put(1, "Hello");
		treeMap.put(5, "There");
		treeMap.put(2, "My");
		treeMap.put(3, "Name");
		treeMap.put(4,"Is");
		treeMap.put(0, "Leia");
		treeMap.inOrder();
		
		//Position<Entry<Integer, String>> testRestructure = treeMap.right(treeMap.right(treeMap.right(treeMap.right(treeMap.root()))));
		
		//System.out.println(testRestructure.getElement().getValue());
		
		
	
	}
}
