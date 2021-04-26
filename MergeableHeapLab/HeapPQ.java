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
		return heap.size();
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
		checkKey(key);
		Entry<J,T> newEntry = new PQEntry<>(key, value);
		heap.add(newEntry);
		upHeap(heap.size()-1);
		
		return newEntry;
	}

	@Override
	public Entry<J, T> min() {
		// TODO Auto-generated method stub
		if(heap.isEmpty())
			return null;
		
		return heap.get(0);
	}

	@Override
	public Entry<J, T> removeMin() {
		if(heap.isEmpty())
			return null;
		Entry<J, T> ans = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size()-1);
		downHeap(0);
		
		return ans;
	}

	private void downHeap(int i) {
		// TODO Auto-generated method stub
		while(hasLeft(i)) {
			int leftInd = left(i);
			int smChildInd = leftInd;
			if(hasRight(i)) {
				int rightInd = right(i);
				if((compare(heap.get(leftInd), heap.get(rightInd)) > 0)){
					smChildInd = rightInd;
				}
			}
			
			if(compare(heap.get(smChildInd), heap.get(i)) >= 0){
				break;
			}
			
			swap(i, smChildInd);
			i = smChildInd;
		}
		
	}
	
	public HeapPQ<J,T> merge(HeapPQ<J, T> toMerge) {
		if(toMerge.isEmpty()) {
			
			return null;
		}
		
		Entry<J, T> min = toMerge.min();
		
		
		J key = min.getKey();
		T value =  min.getValue();
		this.insert(key, value);
		toMerge.removeMin();
		merge(toMerge);
		
		
		
		return this;
	}
	
	public String toString() {
		String queueString = "";
		
		if(heap.isEmpty())
			return null;
		for(int i = 0; i < heap.size(); i++) {
			queueString += heap.get(i).getKey() + " " + heap.get(i).getValue() + "\n";
		}
		
		return queueString;
	}

}
