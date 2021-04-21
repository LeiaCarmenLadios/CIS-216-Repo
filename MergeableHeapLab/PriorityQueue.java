
public interface PriorityQueue<J,T> {
	int size();
	boolean isEmpty();
	Entry<J,T> insert(J key, T value);
	Entry<J,T> min();
	Entry<J,T> removeMin();
}
