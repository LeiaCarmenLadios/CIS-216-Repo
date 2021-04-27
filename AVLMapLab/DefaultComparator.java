import java.util.Comparator;

public class DefaultComparator<K> implements Comparator<K> {

	@Override
	public int compare(K o1, K o2) {
		// TODO Auto-generated method stub
		
		return ((Comparable<K>) o1).compareTo(o2) ;
	}
	
}
