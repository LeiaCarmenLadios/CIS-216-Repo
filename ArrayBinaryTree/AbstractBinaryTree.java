package bnrytrarr;

import java.util.ArrayList;


public abstract class AbstractBinaryTree<T> extends AbstractTree<T> 
											implements BinaryTree<T>
{
	public int sibling(int index) {
		int parentIndex = parent(index);

		if(parentIndex == 0)
			return 0;
		if(index == 2 * (parentIndex) + 1) {
			return 2 * (parentIndex) + 2;
		}
		else
			return 2 * (parentIndex) + 1;
	}
	
	
	public Iterable<T> children(int index){
		ArrayList<T> snapshot = new ArrayList<T>();
		
		
		snapshot.set(2 * (index) + 1, left(index));
		
		snapshot.set(2 * (index) + 1, right(index));
		
		return (Iterable<T>) snapshot;
	}
}
