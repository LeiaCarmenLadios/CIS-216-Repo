package txteditr;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;

//Modified Java book's implementation of a Singly linked list.
public class DoublyLinkedList<T> implements PositionalList<T> {

	// nested Node<T> class
	public static class Node<T> implements Position<T> {
		// private instance variables
		private T data;
		private Node<T> next;
		private Node<T> prev;

		// constructor Node class
		public Node(T data, Node<T> next, Node<T> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public Node(T data) {
			this.data = data;
		}

		/*
		 * access method
		 * 
		 * @returns data - data inside a Node.
		 */
		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		/*
		 * access method
		 * 
		 * @returns next - reference to the next Node
		 */
		public Node<T> getNext() {
			return next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		/*
		 * setter method
		 * 
		 * @param newNext - new next value being assigned
		 */
		public void setNext(Node<T> newNext) {
			this.next = newNext;
		}

		public void setPrev(Node<T> newPrev) {
			this.prev = newPrev;
		}

		@Override
		public T getElement() throws IllegalStateException {
			return this.getData();
		}
	}

	// private instance variables
	private Node<T> header;
	private Node<T> trailer;
	private Node<T> cursor;
	private int size;

	// constructor
	public DoublyLinkedList() {
		header = new Node<T>(null, null, null);
		trailer = new Node<T>(null, null, header);
		size = 0;
		cursor = null;
	}

	public T get(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || size <= index)
			throw new ArrayIndexOutOfBoundsException(index);

		Node<T> node = header;
		while (node.next != null && index > 0) {
			node = node.next;
			index--;
		}

		return node.getData();
	}

	/*
	 * access method
	 * 
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

	public Position<T> getCursorPos() {
		return (Position) cursor;
	}

	public void setCursor(Position<T> cursorNode) {
		cursor = (Node) cursorNode;
	}

	/*
	 * @return first Element of list
	 */
	public Position<T> first() {
		if (isEmpty())
			return null;
		return header.getNext();
	}

	/*
	 * @return last Element of list
	 */
	public Position<T> last() {
		if (isEmpty())
			return null;
		return trailer.getPrev();
	}

	/*
	 * adds to the top of the list
	 * 
	 * @param data - data for Node to be inserted.
	 */
	public Position<T> addFirst(T data) {

		return addBetween(data, header.getNext(), header);

	}

	/*
	 * adds to the end of the list
	 * 
	 * @param data - data for Node to be inserted.
	 */
	public Position<T> addLast(T data) {

		return addBetween(data, trailer, trailer.getPrev());
	}

	private Position<T> addBetween(T data, Node<T> nt, Node<T> pr) {

		Node<T> newest = new Node<T>(data, nt, pr);

		pr.setNext(newest);
		nt.setPrev(newest);
		newest.setNext(nt);
		size++;

		return newest;
	}

	public Position<T> removeFirst() {
		Node<T> temp = header.getNext();

		header.setNext(header.getNext().getNext());
		header.getNext().setPrev(header);
		size--;
		
		return (Position) temp;
	}

	public Position<T> removeLast() {
		Node<T> temp = trailer.getPrev();
		trailer.getPrev().getPrev().setNext(trailer);
		trailer.setPrev(trailer.getPrev().getPrev());
		
		size--;
		return (Position) temp;
	}

	public String toString() {
		int i = 0;

		String build = "";

		Node<T> current = header.getNext();
		while (current != trailer) {
			if (size > 2) {
				
				build += current.getData().toString();
				current = current.getNext();
				i++;

			}

			else {
				build += current.getData().toString();
				current = current.getNext();
				i++;
			}

		}
		return build;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Position<T> before(Position<T> p) throws IllegalArgumentException {

		Node<T> b = (Node) p;
		return (Position) b.getPrev();
	}

	@Override
	public Position<T> after(Position<T> p) throws IllegalArgumentException {
		Node<T> a = (Node) p;

		if (a != trailer)
			return (Position) a.getNext();
		else
			return null;
	}

	@Override
	public Position<T> addBefore(Position<T> p, T t) {
		Node<T> hold = (Node) p;

		if (hold.getPrev() == header) {
			return this.addFirst(t);
		} else if (hold.getNext() == trailer) {
		    return this.addBetween(t, trailer.getPrev(), trailer.getPrev().getPrev());
		    
		} else {
			return this.addBetween(t, hold, hold.getPrev());
		}

	}

	@Override
	public Position<T> addAfter(Position<T> p, T t) {
		Node<T> hold = (Node) p;

		if (hold.getNext() == trailer) {
			return this.addLast(t);
		} else {
			return this.addBetween(t, hold.getNext(), hold);
		}

	}

	@Override
	public T set(Position<T> p, T t) throws IllegalArgumentException {

		Node<T> bucket = (Node) p;
		bucket.setData(t);
		return null;
	}

	@Override
	public T remove(Position<T> p) throws IllegalArgumentException {
		Node<T> hold = (Node) p;
		Node<T> current = header.getNext();
		
		while (current != trailer) {
			if (hold.getPrev() == header) {
				return this.removeFirst().getElement();
				
			} else if (hold.getNext() == trailer) {
				return this.removeLast().getElement();
				
			} else if (current == p) {
				current.getNext().setPrev(current.getPrev());
				current.getPrev().setNext(current.getNext());
				size--;
				return p.getElement();
			}
			current = current.getNext();
		}
		return null;
	}

	
	private Position<T> findCursor() {
		Position<T> current = this.first();
		
		while (current != null) {
			if ((Character) current.getElement() == '|') {
				cursor = (Node)current;
				return (Position)cursor;
			} else {
				current = this.after(current);
			}
		}
		return null;
		
	}
	
	public void moveCursorToEnd() {
		Position<T> cursor = this.findCursor();
		Node<T> holder = (Node) cursor;
		
		holder.getPrev().setNext(holder.getNext());
		holder.getNext().setPrev(holder.getPrev());
		trailer.getPrev().setNext(holder);
		holder.setNext(trailer);
	}
	
	public void editLine() {
		
		
		boolean done = false;
	
		while(!done) {

			this.findCursor();
			
			
			Scanner in = new Scanner(System.in);
			System.out.println("Would you like the cursor to: ");
			System.out.println("1) Move left ");
			System.out.println("2) Move right ");
			System.out.println("3) Insert at cursor");
			System.out.println("4) Remove at cursor");
			System.out.println("5) Exit Edit Mode");
			
		    int moveChoice = in.nextInt();
		    
		    if(moveChoice == 1) {
		    	if(size() == 1 && this.first() == cursor) {
		    		this.remove(cursor);
		    		System.out.println("The line is empty.\n");
		    	}
		    	else if(this.first() != cursor) {
			    	Node<T> temp = cursor;
			    	this.remove(cursor);
			    	this.addAfter(cursor.getPrev().getPrev(), cursor.getElement());
			    	System.out.println("\n" + this + "\n");
		        }
		        else {
		        	System.out.println("You have reached the beginning of the line.\n");
		        }
	
		    }
		    else if(moveChoice == 2) {
		    	if(size() == 1 && this.first() == cursor.getElement()) {
		    		this.remove(cursor);
		    		System.out.println("The line is empty.\n");
		    	}
		    	else if(this.last() != cursor) {
			    	Node<T> temp = cursor;
			    	this.remove(cursor);
			    	this.addAfter(cursor.getNext(), cursor.getElement());
			    	System.out.println("\n" + this + "\n");
		        }
		        else {
		        	System.out.println("You have reached the end of the line.\n");
		        }
		    }
		    else if(moveChoice == 3) {
		    	System.out.println("What would you like to insert?");
		    	
		    	String toInsert = in.next();
		    	
		    	for(int i = 0; i < toInsert.length(); i++) {  
		    		Character charInsert = toInsert.charAt(i);
		    		this.addBefore(cursor, (T)charInsert);
		    		
		    	}
		    	System.out.println("\n" + this + "\n");
		    	
		    	
		    }
		    else if(moveChoice == 4) {
		    	
		    	if(this.first() != cursor) {
		    		this.remove(this.before(cursor));
		    		System.out.println("\n" + this + "\n");
		    	}
		    	else {
		    		
		    		System.out.println("There is nothing left to remove. Please enter a line.\n");
		    	}
		      
		    	
		    }
		    else if(moveChoice == 5) {
		    	done = true;
		    	System.out.println();
		    }
		    else {
		    	System.out.println("Invalid choice. Please Try Again.");
		    }
		}
	   

	}

}
