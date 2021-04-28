import java.util.ArrayList;


public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

	protected static class Node<T> implements Position<T> {
		
		private T element;
		private Node<T> parent, left, right;
		
		public Node(T element, Node<T> parent, Node<T> left, Node<T> right) {
			this.element = element;
			this.parent = parent;
			this.right = right;
			this.left = left;
		}

		@Override
		public T getElement() throws IllegalStateException {
			// TODO Auto-generated method stub
			return element;
		}
		
		public Node<T> getParent(){
			return parent;
		}
		
		public Node<T> getRightChild(){
			return right;
		}
		
		public Node<T> getLeftChild(){
			return left;
		}
		
		public void setElement(T element) {
			this.element = element;
		}
		
		public void setParent(Node<T> parent) {
			this.parent = parent;
		}
		
		public void setRight(Node<T> right) {
			this.right = right;
		}
		
		public void setLeft (Node<T> left) {
			this.left = left;
		}
	}
	
	protected Node<T> createNode(T element, Node<T> parent, Node<T> left, Node<T> right){
		return new Node<T>(element, parent, left, right);
	}
	
	protected Node<T> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {
		
	}
	
	@Override
	public Position<T> right(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return ((Node<T>)p).getRightChild();
	}

	@Override
	public Position<T> left(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return ((Node<T>)p).getLeftChild();
	}

	@Override
	public Position<T> root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Position<T> parent(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return ((Node<T>)p).getParent();
	}

	@Override
	public Iterable<T> children(T element, int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public Position<T> addRoot(T element) throws IllegalStateException{
		if(!isEmpty())
			throw new IllegalStateException("Root already exists");
		root = createNode(element, null, null, null);
		size = 1; 
		return root;
	}
	
	public Position<T> addRight(Position<T> p, T element) throws IllegalArgumentException{
		Node<T> parent = (Node<T>)p;
		
		if(parent.getRightChild() != null) {
			throw new IllegalArgumentException("Right child already exists");
		}
		
		Node<T> child = createNode(element, parent, null, null);
		parent.setRight(child);
		size ++;
		return child;
	}
	
	public Position<T> addLeft(Position<T> p, T element) throws IllegalArgumentException{
		Node<T> parent = (Node<T>)p;
		
		if(parent.getLeftChild() != null) {
			throw new IllegalArgumentException("Left child already exists");
		}
		
		Node<T> child = createNode(element, parent, null, null);
		parent.setLeft(child);
		size ++;
		return child;
	}
	
	public T set(Position<T> p, T element) throws IllegalArgumentException {
		Node<T> node = (Node<T>) p;
		T temp = node.getElement();
		node.setElement(element);
		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	

}
