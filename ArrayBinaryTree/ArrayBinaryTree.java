package bnrytrarr;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayBinaryTree<T> extends AbstractBinaryTree {

	private T root = null;
	private int size = 0;
	private ArrayList<T> treeArr = (ArrayList<T>) new ArrayList<String>();

	public class ArrayTreeIterator implements Iterator<T> {

		private int i = 0;
		private boolean removable = false;
		private T current;

		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public T next() throws NoSuchElementException {
			if (i == size)
				throw new NoSuchElementException();
			removable = true;
			return treeArr.get(i++);
		}

		@Override
		public void remove(T t) throws IllegalStateException {
			if (!removable)
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

	public ArrayBinaryTree(ArrayList<T> treeArr) {
		this.treeArr = treeArr;
		this.size = treeArr.size();
	}

	public void addRoot(T element) {
		root = element;
		treeArr.add(0, root);
		size++;
	}

	public void addLeft(int index, T element) throws IllegalArgumentException {
		try {
			if (left(treeArr.get(index)) != null) {
				System.out.println("Index " + index + " already has a left child. Remove it, or try another index.");
			}
		} catch (IllegalArgumentException e) {
			treeArr.add(2 * (index) + 1, element);
			size++;
		}
	}

	public void addRight(int index, T element) throws IllegalArgumentException {
		try {
			if(right(treeArr.get(index)) != null)
				System.out.println("Index " + index + " already has a right child. Remove it, or try another index.");
		} catch (IllegalArgumentException e) {
			try {
				if(left(treeArr.get(index)) != null)
					treeArr.add(2 * (index) + 2, element);
			}
			catch(IllegalArgumentException eTwo) {
				treeArr.add(2 * (index) + 1, (T)new String(""));
				treeArr.add(2 * (index) + 2, element);
				
			}
			size++;
		}
	}

	@Override
	public T left(Object element) throws IllegalArgumentException {
		int index = 0;
		for (int i = 0; i < treeArr.size(); i++) {
			if (treeArr.get(i).equals(element)) {
				index = i;
			}
		}
		if (this.size() <= 2 * (index) + 1) { // no left children
			throw new IllegalArgumentException("This index does not have a left child.");
		}

		return treeArr.get(2 * (index) + 1); // return left child if it exists.
	}

	@Override
	public T right(Object element) throws IllegalArgumentException {
		int index = 0;
		for (int i = 0; i < treeArr.size(); i++) {
			if (treeArr.get(i).equals(element)) {
				index = i;
			}
		}
		if (treeArr.size() <= (2 * (index) + 2)) { // no right children
			throw new IllegalArgumentException("This index does not have a right child.");
		}
		return treeArr.get(2 * (index) + 2); // return right child if it exists.

	}

	@Override
	public Object root() {

		if (this.isEmpty())
			return null;
		else
			root = treeArr.get(0);
		return root;
	}

	@Override
	public int parent(int index) throws IllegalArgumentException {

		if (index == 0) {
			throw new IllegalArgumentException();
		}

		return (index - 1) / 2;

	}

	@Override
	public Iterable<T> children(Object element, int index) throws IllegalArgumentException {

		if (this.isExternal(index)) {
			throw new IllegalArgumentException();
		} else {
			return super.children(element, index);
		}
	}

	@Override
	public int numChildren(int index) throws IllegalArgumentException {

		int count = 0;
		if (isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			int parentIndex = parent(index);
			if (2 * (index) + 1 > parentIndex) {
				count++;
			}
			if (2 * (index) + 2 > parentIndex) {
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

		return new ArrayTreeIterator();
	}

	@Override
	public ArrayList<T> positions() {
		// default iteration method
		return preOrder();
	}

	private ArrayList<T> preOrder() {

		ArrayList<T> preOrderedList = new ArrayList<T>();

		if(!isEmpty())
			preOrderSubtree((T) root(), preOrderedList);

		return preOrderedList;
	}

	public void preOrderSubtree(T element, ArrayList<T> snap) {
   
		
		if (element == null) {
			return;
		}
		
		snap.add(element);
		
		try {
			preOrderSubtree(this.left(element), snap);
			preOrderSubtree(this.right(element), snap);
		} 
		catch (IllegalArgumentException e) {
			return;
		}

	}

	public ArrayList<T> postOrder() {

		ArrayList<T> postOrderedList = new ArrayList<T>();

		if (!isEmpty()) {
			postOrderSubtree((T) root(), postOrderedList);
		}

		return postOrderedList;
	}

	private void postOrderSubtree(T element, ArrayList<T> snap) {

		if (element == null) {
			return;
		}

		try {
			postOrderSubtree(this.left(element), snap);
			
			postOrderSubtree(this.right(element), snap);
			snap.add(element);
		} catch (IllegalArgumentException e) {
			snap.add(element);
			return;
		}

	}
	
	public ArrayList<T> inorder(){
		ArrayList<T> inorderList = new ArrayList<T>();
		
		if(!isEmpty()) {
			inorderSubtree((T) root(), inorderList);
		}
		
		return inorderList;
	}
	
	private void inorderSubtree(T element, ArrayList<T> snap) {
		try {
			if(this.left(element) != null){
				inorderSubtree(left(element), snap);
			}
			snap.add(element);
			if(this.right(element) != null) {
				inorderSubtree(right(element), snap);
			}
		}
		catch(IllegalArgumentException e) {
			snap.add(element);
			return;
		}
	}

	public int depth(int index) {
		if (treeArr.get(index).equals(root)) {
			return 0;
		} else
			return 1 + depth(parent(index));
	}


	public String toString() {
		String ret = "";

		int currLevel = 0;
		int nextLevel = currLevel++;

		for (int i = 0; i < treeArr.size(); i++) {
			if (i == 0) {
				System.out.print("root: ");
				ret += treeArr.get(0);
			} else {
				
				if(treeArr.get(i).equals("") == false) {
					ret += "\n\nnode " + (i + 1) + ":\t";
					ret += treeArr.get(i);
				}
			}

		}
		return ret;
	}

}
