import java.util.ArrayList;

//adapted implementation from the book
public class TreeMap<K, V> extends AbstractSortedMap<K, V> {

	protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {
		protected static class BSTNode<T> extends Node<T> {
			int aux = 0;

			public BSTNode(T element, LinkedBinaryTree.Node<T> parent, LinkedBinaryTree.Node<T> left,
					LinkedBinaryTree.Node<T> right) {
				super(element, parent, left, right);
				// TODO Auto-generated constructor stub
			}

			public int getAux() {
				return aux;
			}

			public void setAux(int a) {
				aux = a;
			}
		}

		public int getAux(Position<Entry<K, V>> p) {
			return ((BSTNode<Entry<K, V>>) p).getAux();
		}

		private void setAux(Position<Entry<K, V>> p, int value) {
			((BSTNode<Entry<K, V>>) p).setAux(value);
		}

		protected Node<Entry<K, V>> createNode(Entry<K, V> element, Node<Entry<K, V>> parent, Node<Entry<K, V>> left,
				Node<Entry<K, V>> right) {
			return new BSTNode<>(element, parent, left, right);
		}

		private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeft) {
			child.setParent(parent);
			if (makeLeft) {
				parent.setLeft(child);
			} else
				parent.setRight(child);
		}

		public void rotate(Position<Entry<K, V>> p) {
			Node<Entry<K, V>> a = (Node<Entry<K, V>>) p;
			Node<Entry<K, V>> b = (Node<Entry<K, V>>) parent(a);
			Node<Entry<K, V>> c = (Node<Entry<K, V>>) parent(b);
			
			if (c == null) {
				root = a;
				a.setParent(null);
			} else {
				relink(c, a, b == c.getLeftChild());
			}

			if (a == b.getLeftChild()) {
				relink(b, a.getRightChild(), true);
				relink(a, b, false);
			} else {
				relink(b, a.getLeftChild(), false);
				relink(a, b, true);
			}
		}
			
		//trinode restructure
		public Position<Entry<K, V>> restructure(Position<Entry<K, V>> a) {
			if(a != root() && parent(a) != null) {
				Position<Entry<K, V>> b = parent(a);
				
				if(parent(b) != null) {
					Position<Entry<K, V>> c = parent(b);
					if ((a == right(b)) == (b == right(c))) {
						rotate(b);
						return b;
					} else {
						rotate(a);
						rotate(a);
						return a;
	
					}
				}

			}
			return null;
		}

	}

	protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

	public TreeMap() {
		super();
		tree.addRoot(null);
	}

	public TreeMap(DefaultComparator<K> comp) {
		super(comp);
		tree.addRoot(null);
	}

	public void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
		tree.set(p, entry);
		tree.addLeft(p, null);
		tree.addRight(p, null);
	}

	// Some notational shorthands for brevity (yet not efficiency)
	protected Position<Entry<K, V>> root() {
		return tree.root();
	}

	protected Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
		return tree.parent(p);
	}

	protected Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
		return tree.left(p);
	}

	protected Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
		return tree.right(p);
	}

	protected Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
		return tree.sibling(p);
	}

	protected boolean isRoot(Position<Entry<K, V>> p) {
		return tree.isRoot(p);
	}

	protected boolean isExternal(Position<Entry<K, V>> p) {
		return tree.isExternal(p);
	}

	protected boolean isInternal(Position<Entry<K, V>> p) {
		return tree.isInternal(p);
	}

	protected void set(Position<Entry<K, V>> p, Entry<K, V> e) {
		tree.set(p, e);
	}

	private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
		if (isExternal(p)) {
			return p;
		}
		int comp = compare(key, p.getElement());
		if (comp == 0) {
			return p;
		} else if (comp < 0) {
			return treeSearch(left(p), key);
		} else {
			return treeSearch(right(p), key);
		}
	}

	protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
		Position<Entry<K, V>> walk = p;
		while (isInternal(walk)) {
			walk = right(walk);
		}
		return parent(walk);
	}

	protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
		Position<Entry<K, V>> walk = p;
		while (isInternal(walk)) {
			walk = left(walk);
		}
		return parent(walk);
	}

	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return treeMin(root()).getElement();
	}

	@Override
	public Entry<K, V> lastEntry() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return treeMax(root()).getElement();
	}

	@Override
	public Entry<K, V> ceilingEntry(K k) {
		// TODO Auto-generated method stub
		checkKey(k);
		Position<Entry<K, V>> p = treeSearch(root(), k);
		if (isInternal(p)) {
			return p.getElement();
		}
		while (isRoot(p) == false) {
			if (p == left(parent(p))) {
				return parent(p).getElement();
			} else {
				p = parent(p);
			}
		}
		return null;
	}

	@Override
	public Entry<K, V> floorEntry(K k) {
		// TODO Auto-generated method stub
		checkKey(k);
		Position<Entry<K, V>> p = treeSearch(root(), k);
		if (isInternal(p)) {
			return p.getElement();
		}
		while (isRoot(p) == false) {
			if (p == right(parent(p))) {
				return parent(p).getElement();
			} else {
				p = parent(p);
			}
		}
		return null;
	}

	@Override
	public Entry<K, V> lowerEntry(K k) {
		// TODO Auto-generated method stub
		checkKey(k);
		Position<Entry<K, V>> p = treeSearch(root(), k);
		if (isInternal(p) && isInternal(left(p))) {
			return treeMax(left(p)).getElement();
		}

		while (isRoot(p) == false) {
			if (p == right(parent(p))) {
				return parent(p).getElement();
			} else {
				p = parent(p);
			}
		}
		return null;
	}

	@Override
	public Entry<K, V> higherEntry(K k) {
		// TODO Auto-generated method stub
		checkKey(k); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), k);
		if (isInternal(p) && isInternal(right(p))) {
			return treeMin(right(p)).getElement(); // this is the successor to p
		}
		// otherwise, we had failed search, or match with no right child
		while (isRoot(p) == false) {
			if (p == left(parent(p))) {
				return parent(p).getElement(); // parent has next lesser key
			} else {
				p = parent(p);
			}
		}
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> subMap(K kOne, K kTwo) {
		// TODO Auto-generated method stub

		checkKey(kOne); // may throw IllegalArgumentException
		checkKey(kTwo); // may throw IllegalArgumentException
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
		if (compare(kOne, kTwo) < 0) // ensure that fromKey < toKey
		{
			subMapRecurse(kOne, kTwo, root(), buffer);
		}
		return (Iterable<Entry<K, V>>) buffer;

	}

	private void subMapRecurse(K kOne, K kTwo, Position<Entry<K, V>> p, ArrayList<Entry<K, V>> buffer) {
		if (isInternal(p)) {
			if (compare(p.getElement(), kOne) < 0)
			{
				subMapRecurse(kOne, kTwo, right(p), buffer);
			} 
			else {
				subMapRecurse(kOne, kTwo, left(p), buffer); // first consider left subtree
				if (compare(p.getElement(), kTwo) < 0) { // p is within range
					buffer.add(p.getElement()); // so add it to buffer, and consider
					subMapRecurse(kOne, kTwo, right(p), buffer); // right subtree as well
				}
			}
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (tree.size() - 1) / 2;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		checkKey(key); // may throw IllegalArgumentException
		Position<Entry<K, V>> p = treeSearch(root(), key);
//		rebalanceAccess(p); // hook for balanced tree subclasses
		if (isExternal(p)) {
			return null; // unsuccessful search
		}
		return p.getElement().getValue(); // match found
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		checkKey(key);
		Entry<K, V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K, V>> p = treeSearch(root(), key);
		
		if (isExternal(p)) {
			expandExternal(p, newEntry);
			rebalanceInsert(p);
			return null;
		} else {
			V old = p.getElement().getValue();
			set(p, newEntry);
			return old;
		}
	}

	@Override
	public V remove(K leaf2) {
		// TODO Auto-generated method stub
		checkKey(leaf2);
		Position<Entry<K, V>> p = treeSearch(root(), leaf2);
		if (isExternal(p)) {
			return null;
		} else {
			V old = p.getElement().getValue();
			if (isInternal(left(p)) && isInternal(right(p))) {
				Position<Entry<K, V>> replacement = treeMax(left(p));
				set(p, replacement.getElement());
				p = replacement;
			}
			Position<Entry<K, V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
			Position<Entry<K, V>> sib = sibling(leaf);
			remove(leaf.getElement().getKey());
			remove(p.getElement().getKey());
			rebalanceDelete(sib);
			return old;
		}
	}

	public void inOrder() {
		this.inOrder(root());
	}

	private void inOrder(Position<Entry<K, V>> p) {

		if (p.getElement() == null) {
			return;
		}
		System.out.print(p.getElement().getValue() + " " + p.getElement().getKey() + "\n");
		
		if(p != root())
			System.out.println("parent: " + parent(p).getElement().getValue());
		System.out.println();
		
		inOrder(left(p));

		
		
		inOrder(right(p));
		
		

	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	private void rebalanceDelete(Position<Entry<K, V>> sib) {
		// TODO Auto-generated method stub
		tree.restructure(sib);
	}

	protected void rebalanceInsert(Position<Entry<K, V>> p) {
        tree.restructure(p);
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return null;
	}

}
