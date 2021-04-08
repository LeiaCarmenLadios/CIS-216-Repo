package bnrytrarr;

public abstract class AbstractTree<T> implements Tree<T> {
	
	public boolean isInternal(int index) {
		return numChildren(index) > 0;
	}
	
	public boolean isExternal(int index) {
		return numChildren(index) == 0;
	}
	
	public boolean isRoot(int index) {
		return index == 0;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}
