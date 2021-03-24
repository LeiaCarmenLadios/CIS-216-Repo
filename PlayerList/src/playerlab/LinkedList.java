package playerlab;
import java.lang.ArrayIndexOutOfBoundsException;
//Modified Java book's implementation of a Singly linked list.
public class LinkedList<T extends GameEntry> {

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
	
	public T get(int index) throws ArrayIndexOutOfBoundsException {
	    if(index < 0 || size <= index)
	            throw new ArrayIndexOutOfBoundsException(index);

	    Node<T> node = head;
	    while(node.next != null && index > 0) {
	        node = node.next;
	        index--;
	    }

	     return node.getData();
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
	 * adds to the top of the list
	 * @param data - data for Node to be inserted.
	 */
	public void addFirst(T data) {
		head = new Node<T>(data, head);
		
		if(size == 0) {
			tail = head;
		}
		
		size ++;
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
	 * add score into list only if it is higher than a score already on
	 * the board.
	 */
	public void addEntry(T entry) {
		
		if(size < 2) {
			if(isEmpty() == true || entry.getScore() > head.getData().getScore()){
				addLast(entry);
			}
			else if(isEmpty() == false) {
				Node<T> temp = head; 
				head = new Node<T>(entry, temp);
			}
		}
		else if(size <= 10) {
			organize(entry);
		}
	
	}
	
	private void organize(T entry) {
		
		Node<T> scoreEntry = new Node<T>(entry, null);
		boolean added = false;
		Node<T> current = head;
		
		while(current.getNext() != null && !added) {
			if(current.getData().getScore() <= scoreEntry.getData().getScore() 
			  && current.getNext().getData().getScore() >= scoreEntry.getData().getScore()) {   
				Node<T> temp = current.getNext();	
				scoreEntry.setNext(temp);
				current.setNext(scoreEntry);
				size++; 
				added = true;
			}
			else if(scoreEntry.getData().getScore() < head.getData().getScore()) {
				addFirst(scoreEntry.getData());
				added = true;
			}
			else {
				added = false;
				current = current.getNext();
			}
		}
		
		if(added != true) {
			addLast(entry);
		}
		
		if(size > 10) {
			removeFirst();
		}
	
	}
	
	public void remove(int index) {
		
		int i = 0;
		Node
		<T> current = head;
		Node<T> prev = null;
		boolean removed = false;
		
		if(isEmpty()) {
			System.out.println("There is nothing to remove");
		}
		if(index == 1) {
			removeFirst();
		}
		else {
			while(current.getNext() != null && !removed) {
			   
				if(i == (index - 1)) {
					prev.setNext(current.getNext());
					size--;
					removed = true;
				}
				else{
					prev = current;
					current = current.getNext();
					i++;
				}
			}
			
			if(index == size && !removed) {
				tail = prev;
				prev.setNext(null);
				size--;
				
			}
		}
	}
	
	public String toString() {
		int i = 0;
		String build = "";
		Node<T> current = head;
		while(i < size && current.getNext() != null) {
			build += (i+1) + ") " + current.getData().toString() + "\n\n";
			current = current.getNext();
			i++;
		}
		build += (i+1) + ") " + tail.getData().toString();
		return build;
	}
}
