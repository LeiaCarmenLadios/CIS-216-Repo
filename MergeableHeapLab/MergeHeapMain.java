
public class MergeHeapMain {
	public static void main(String[] args) {
		HeapPQ<Integer, String> queue = new HeapPQ<Integer, String>();
		
		queue.insert(4, "Leia");
		queue.insert(5, "Dany");
		queue.insert(1, "Hugh");
		
		
		HeapPQ<Integer, String> queueToMerge = new HeapPQ<Integer, String>();
		
		queueToMerge.insert(2, "Kasey");
		queueToMerge.insert(3, "Sahar");
		queueToMerge.insert(4, "Calie");
		
		
		System.out.println("First Heap: \n" + queue);
		System.out.println("Second Heap: \n" + queueToMerge);
		
		HeapPQ<Integer, String> mergedHeap = queue.merge(queueToMerge);
		
		
		
		System.out.println("Merged Heap: \n" + mergedHeap);
	}
}
 