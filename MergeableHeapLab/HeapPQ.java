import java.util.ArrayList;

public class HeapPQ<J, T> extends AbstractPQ<J, T> {

	protected ArrayList<Entry<J, T>> heap = new ArrayList<Entry<J, T>>();
	

	public HeapPQ(){
		super();
	}
	
	public HeapPQ(PQComparator<J> comp) {
		super(comp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected int parent(int i) {
		return (i-1)/2;
	}
	
	protected int left(int i) {
		return (2 * i) + 1;
	}
	
	protected int right(int i) {
		return (2 * i) + 2;
	}
	
	protected boolean hasLeft(int i) {
		return left(i) < heap.size();
	}
	
	protected boolean hasRight(int i) {
		return right(i) < heap.size();
	}
	
	protected void swap(int k, int m) {
		Entry<J, T> temp = heap.get(k);
		heap.set(k, heap.get(m));
		heap.set(m, temp);
	}
	
	protected void upHeap(int j) {
		while(j > 0) {
			int pare = parent(j);
			if(compare(heap.get(j), heap.get(pare)) >= 0) {
				break;
			}
			swap(j, pare);
			j = pare;
		}
	}

	@Override
	public Entry<J, T> insert(J key, T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<J, T> min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<J, T> removeMin() {
		// TODO Auto-generated method stub
		return null;
	}

}
