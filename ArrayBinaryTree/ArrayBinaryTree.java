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
	
	public void addRoot(T element) {
		root = element;
		treeArr.add(0, root);
		size ++;
	}
	
	public void addLeft(int index, T element) throws IllegalArgumentException {
		try {
			
			if(left(index) != null) {
				System.out.println("This index already has a left child. Remove it, or try another index.");
			}
		}
		catch(IllegalArgumentException e) {
			treeArr.add(2 * (index) + 1, element);
			size++;
			
		}
	}
	
	public void addRight(int index, T element) throws IllegalArgumentException{
		try {
			if(right(index) != null)
				System.out.println("This index already has a right child. Remove it, or try another index.");
		}
		catch(IllegalArgumentException e) {
			treeArr.add(2 * (index) + 2, element);
			size++;
		}
	}

	@Override
	public T left(int index) throws IllegalArgumentException {
		if(this.size() <= 2 *(index) + 1) { // no left children
			throw new IllegalArgumentException("This index does not have a left child.");
		}
		
		return treeArr.get(2 * (index) + 1); //return left child if it exists.
	}

	@Override
	public T right(int index) throws IllegalArgumentException {
		if(this.size() <= 2 * (index) + 2) { // no left children
			throw new IllegalArgumentException("This index does not have a left child.");
		}
		return treeArr.get(2 * (index) + 2); //return right child if it exists.
		
		
	}

	@Override
	public Object root() {
		
		if(this.isEmpty())
			return null; 
		else
			root = treeArr.get(0);
		return root;
	}

	@Override
	public int parent(int index) throws IllegalArgumentException {
		
		if(index == 0) {
			throw new IllegalArgumentException(); 
		}
		
		return (index -1) / 2;
		
		
	}

	@Override
	public Iterable<T> children(int index) throws IllegalArgumentException {
		
		if(this.isExternal(index)) {
			throw new IllegalArgumentException(); 
		}
		else {
		    return this.children(index);
		}
	}

	@Override
	public int numChildren(int index) throws IllegalArgumentException {
		
		int count = 0;
		if(isEmpty()) {
			throw new IllegalArgumentException();
		}
		else {
			int parentIndex = parent(index);
			if(2 * (index) + 1 > parentIndex){
				count++;
			}
			if(2 * (index) + 2 > parentIndex) {
				count++;
			}
			return count;
		}
	
		
	}

	@Override
	public int size() {
		 
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		 
		return this.iterator();
	}

	@Override
	public Iterable<T> positions() {
		//default iteration method
		return (Iterable<T>) treeArr;
	}

//	private Iterable<T> preOrder() {
//		
//		return null;
//	}
//	
//	public void preOrderSubtree(int index, ArrayList<T> snap) {
//		snap.add(treeArr.get(index));
//		
//		this.children(index);
//	}
	
	
	

}
