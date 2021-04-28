
public class AVLMapMain {
	public static void main(String[] args) {
		SortedTableMap<Integer, String> tester = new SortedTableMap<Integer, String>();
		tester.put(1, "Hello");
		
		System.out.println(tester.firstEntry().getValue());
	}
}
