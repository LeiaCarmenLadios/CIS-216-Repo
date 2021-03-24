package matrixlab.AdditionalFiles;

//Modified Java book's implementation of a Singly linked list.
public class LinkedList<T extends Number> {

	//nested Node<T> class
	private static class Node<T> {
		//private instance variables
		private T data;
		private Node<T> next;
		
		//constructor Node class
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		/*
		 * access method
		 * @returns data - data inside a Node.
		 */
		public T getData() {
			return data;
		}
		
		/*
		 * access method
		 * @returns next - reference to the next Node
		 */
		public Node<T> getNext() {
			return next;
		}
		
		/*
		 * setter method
		 * @param newNext - new next value being assigned
		 */
		public void setNext(Node<T> newNext) {
			this.next = newNext;
		}
	}
	
	//private instance variables 
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	//constructor
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/*
	 * access method
	 * @return size - size of linked list
	 */
	public int size() {
		return size;  
	}
	
	/*
	 * @return T/F - true if empty, false if filed.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * @return first Element of list
	 */
	public T first() {
		return head.getData();
	}
	
	/*
	 * @return last Element of list
	 */
	public T last() {
		return tail.getData();
	}
	
	/*
	 * adds to the end of the list
	 * @param data - data for Node to be inserted.
	 */
	public void addLast(T data) {
		Node<T> newest = new Node<T>(data, null);
		if(isEmpty()) {
			head = newest;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	/*
	 * removes the first Node on the list. 
	 * @return ret - data of Node being removed.
	 */
	public T removeFirst() {
		if(isEmpty()) {
			return null;
		}
		T ret = head.getData();
		head = head.getNext();
		size--;
		if(size == 0) {
			tail = null;
		}
		return ret;
		
	}
	
	/*
	 * adds all values inside matrix of any size 
	 * containing integers.
	 * @return listSum - sum of list
	 */
	public int add() {
		Node<T> current = head;
		int listSum = 0;
		while(current != null) {
			listSum += current.getData().intValue();
			current = current.getNext();
		}
		return listSum;
		
	}
	
	/*
	 * multiplied all values inside matrix of any size 
	 * containing integers.
	 * @return listProduct - Product of list
	 */
	public int multiply() {
		Node<T> current = head;
		int listProduct = 1;
		while(current != null) {
			listProduct *= current.getData().intValue();
			current = current.getNext();
		}
		return listProduct;
	}
	
	
}
