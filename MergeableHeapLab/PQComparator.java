import java.util.Comparator;

public class PQComparator<J> implements Comparator<J> {

	@Override
	public int compare(J o1, J o2) {
		
		return ((Comparable<J>) o1).compareTo(o2);
	}

}
