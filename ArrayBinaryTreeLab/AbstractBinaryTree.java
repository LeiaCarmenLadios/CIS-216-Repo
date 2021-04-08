package bnrytrarr;

import java.util.ArrayList;


public abstract class AbstractBinaryTree<T> extends AbstractTree<T> 
											implements BinaryTree<T>
{
	public int sibling(int index) {
		int parentIndex = parent(index);

		if(parentIndex == 0)
			return 0;
		if(index == left(parentIndex)) {
			return right(parentIndex);
		}
		else
			return left(parentIndex);
	}
	
	public int numChildren(Integer index) {
		Integer count = 0;
		
		if(left(index) > index) {
			count++;
		}
		if(right(index) > index) {
			count++;
		}
		
		return count; 
	}
	
	public Integer[] children(Integer index){
		Integer[] snapshot = new Integer[2];
		if(left(index) > index)
			snapshot[0] = (left(index));
		if(right(index) > index)
			snapshot[1] = right(index);
		
		return snapshot;
	}
}
