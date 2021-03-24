package playerlab;

import java.lang.ArrayIndexOutOfBoundsException;


//Modified Java book's implementation of a Singly linked list.
public class DoublyLinkedList<T extends GameEntry> {

	//nested Node<T> class
	private static class Node<T> {
		//private instance variables
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		
		//constructor Node class
		public Node(T data, Node<T> next, Node<T> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
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
		
		public Node<T> getPrev(){
		   return prev;
		}
		
		/*
		 * setter method
		 * @param newNext - new next value being assigned
		 */
		public void setNext(Node<T> newNext) {
			this.next = newNext;
		}
		
		public void setPrev(Node<T> newPrev) {
		   this.prev = newPrev;
		}
	}
	
	//private instance variables 
	private Node<T> header;
	private Node<T> trailer;
	private int size;
	
	//constructor
	public DoublyLinkedList() {
		header = new Node<T>(null, null, null);
		trailer = new Node<T>(null, null, header);
		size = 0;
	}
	
	public T get(int index) throws ArrayIndexOutOfBoundsException {
	    if(index < 0 || size <= index)
	            throw new ArrayIndexOutOfBoundsException(index);

	    Node<T> node = header;
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
	   if(isEmpty())
	        return null;
		return header.getNext().getData();
	}
	
	/*
	 * @return last Element of list
	 */
	public T last() {
	    if(isEmpty()) 
	       return null;
		return trailer.getPrev().getData();
	}
	
	/*
	 * adds to the top of the list
	 * @param data - data for Node to be inserted.
	 */
	public void addFirst(T data) {
		addBetween(data, header.getNext(), header);
	}
	

   /*
    * adds to the end of the list
    * @param data - data for Node to be inserted.
    */
   public void addLast(T data) {
     addBetween(data, trailer, trailer.getPrev());
   }
   
   
   public void addBetween(T data, Node<T> nt, Node<T> pr) {
      
      Node<T> newest = new Node<T>(data, nt, pr);
      
      pr.setNext(newest);
      nt.setPrev(newest);
      newest.setNext(nt);
      size++;
   }
   
   
 /*
 * add score into list only if it is higher than a score already on
 * the board.
 */
public void addEntry(T entry) {

   
   if(size <= 2 ) { 
      if(isEmpty() || entry.getScore() > header.getNext().getData().getScore()) {
         addLast(entry);
      }
      else if(isEmpty()) {
         addFirst(entry);
      }
      else if(entry.getScore() > header.getNext().getData().getScore() 
            && entry.getScore() < trailer.getPrev().getData().getScore()) {
         addBetween(entry, trailer, header);
      }
   }
   else {
     boolean added = false;
     Node<T> current = header.getNext();
    
    
     while(current.getNext() != trailer && !added) {
       if(current.getData().getScore() <= entry.getScore() 
          && current.getNext().getData().getScore() > entry.getScore()) {
          //enter in between current and current.getNext()
          addBetween(entry, current.getNext(), current);
          added = true;
       }   
       else if(entry.getScore() < first().getScore()) {
          addFirst(entry);
          added = true;
       }
       else {
          current = current.getNext();
       }
     }
     if(!added) {
        addLast(entry);
        added = true;
     }
     if(size > 10) {
        removeFirst();
     }

   
   }

}
	/*
	 * removes the first Node on the list. 
	 * @return ret - data of Node being removed.
	 */
   public T removeFirst() {
   	if(isEmpty())
   		  return null;
   	Node<T> first = header.getNext();
   	T ret = first.getData();
   	header.setNext(first.getNext());
   	size--;
   	return ret;
   		
   }
   	
   public T removeLast() {
   	 if(isEmpty())
   	      return null;
   	 Node<T> last = trailer.getPrev();
   	 T ret = last.getData();
   	 trailer.setPrev(last.getPrev());
   	 size--;
   	 return ret;
   }
   	

	public void remove(int index) {
		
		int i = 0;
		Node<T> current = header.getNext();
		boolean removed = false;
		
		if(isEmpty()) {
			System.out.println("There is nothing to remove");
		}
		if(index == 1) {
			removeFirst();
		}
		else {
			while(current.getNext() != trailer && !removed) {
				if(i == (index-1)) {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					size--;
					
					removed = true;
				}
				else{
					current = current.getNext();
					i++;
				}
			}
			
			if(index == size) {
			   current.getPrev().setNext(trailer);
            trailer.setPrev(current.getPrev());
            System.out.println(current.getNext().getData());
				size--;
			}
		}
	}
	
	public String toString() {
		int i = 0;
		
		String build = "";
		
		Node<T> current = header.getNext();
		while(i < size && current.getNext() != null) {
		   if(size > 2) {
   			build += (i+1) + ") " + current.getData().toString()
   			      + "\n\n"; 
   			current = current.getNext();
   			i++;
   			
		   }
		   
		   else{
		      build += (i+1) + ") " + current.getData().toString() 
		            + "\t\t null \n\n";
            current = current.getNext();
            i++;
		   }
		   
		}
		return build;
	}
}
