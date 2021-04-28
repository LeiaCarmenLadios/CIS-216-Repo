
public class TreeMap<K, V> extends AbstractSortedMap<K,V> {
	
	protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>>{
		protected static class BSTNode<T> extends Node<T>{
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
		
		public int getAux(Position<Entry<K,V>> p) {
			return ((BSTNode<Entry<K, V>>) p).getAux();
		}
		
		public void setAux(Position<Entry<K,V>> p, int value) {
			((BSTNode<Entry<K, V>>)p).setAux(value);
		}
		
		protected Node<Entry<K,V>> createNode(Entry<K,V> element, Node<Entry<K,V>> parent
											, Node<Entry<K,V>> left, Node<Entry<K,V>> right){
			return new BSTNode<>(element, parent, left, right);
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
	
	public void ExpandExternal(Position<Entry<K,V>> p, Entry<K, V> entry) {
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
   
    
	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> lastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> ceilingEntry(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> floorEntry(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> lowerEntry(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> higherEntry(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> subMap(K kOne, K kTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (tree.size() - 1) / 2 ;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
