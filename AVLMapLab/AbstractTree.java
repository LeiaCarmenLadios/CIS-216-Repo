

public abstract class AbstractTree<T> implements Tree<T> {
	
	public boolean isInternal(Position<T> index) {
		return numChildren(index) > 0;
	}
	
	public boolean isExternal(Position<T> index) {
		return numChildren(index) == 0;
	}
	
	public boolean isRoot(Position<T> p) {
		return p == root();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}
