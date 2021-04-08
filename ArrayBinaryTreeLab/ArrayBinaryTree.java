package bnrytrarr;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayBinaryTree<T> extends AbstractBinaryTree {

	private T root = null;
	private int size = 0;
	private ArrayList<T> treeArr = (ArrayList<T>) new ArrayList<String>();

	private class ArrayTreeIterator implements Iterator<T> {
		
		private int i = 0;
		private boolean removable = false;

		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public T next() throws NoSuchElementException {
			if(i == size)
				throw new NoSuchElementException();
			removable = true;
			return treeArr.get(i++);
		}

		@Override
		public void remove(T t) throws IllegalStateException {
			if(!removable)
				throw new IllegalStateException("There is nothing to remove");
			treeArr.remove(i - 1);
			i--;
			removable = false;
	
		}
		
	}

	/**
	 * constructs empty binary tree
	 */
	public ArrayBinaryTree() {
	}

	@Override
	public int left(int index) throws IllegalArgumentException {
		 
		return 0;
	}

	@Override
	public int right(int index) throws IllegalArgumentException {
		 
		return 0;
	}

	@Override
	public Object root() {
		 
		return null;
	}

	@Override
	public int parent(int index) throws IllegalArgumentException {
		 
		return 0;
	}

	@Override
	public Iterable children(int index) throws IllegalArgumentException {
		 
		return null;
	}

	@Override
	public int numChildren(int index) throws IllegalArgumentException {
		 
		return 0;
	}

	@Override
	public int size() {
		 
		return 0;
	}

	@Override
	public Iterator iterator() {
		 
		return null;
	}

	@Override
	public Iterable positions() {
		 
		return null;
	}

}
