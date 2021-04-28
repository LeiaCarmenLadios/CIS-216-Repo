

import java.util.ArrayList;


public abstract class AbstractBinaryTree<T> extends AbstractTree<T> 
											implements BinaryTree<T>
{
	public Position<T> sibling(Position<T> p) {
		Position<T> parent = parent(p);
		if(parent == null)
			return null;
		
		if(p == left(parent)) {
			return right(parent);
		}
		else
			return left(parent);
		
	}
	
	public int numChildren(Position<T> p) {
		int count = 0;
		if(left(p) != null) {
			count++;  
		}
		if(right(p) != null) {
			count++;
		}
		return count;
	}
	
	public Iterable children (Position<T> p){
		ArrayList<T> snapshot = new ArrayList<T>();
		
		
		if(left(p) != null) {
			snapshot.add( (T) left(p));
		}
		if(right(p) != null) {
			snapshot.add((T) right(p));
		}
		return (Iterable) snapshot;
	}
}
