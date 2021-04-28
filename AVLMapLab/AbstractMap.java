import java.util.NoSuchElementException;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	protected static class MapEntry<K, V> implements Entry<K, V>{
		private K key;
		private V value;
		
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}
		
		protected void setKey(K key) {
			this.key = key;
		}
		
		protected V setValue(V value) {
			V temp = this.value;
			this.value = value;
			return temp;
		}
		
	}
	
	private class KeyIterator implements Iterator<K>{
		
		private Iterator<Entry<K, V>> entryList = (Iterator<Entry<K, V>>) entrySet().iterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return entryList.hasNext();
		}

		@Override
		public K next() throws NoSuchElementException {
			// TODO Auto-generated method stub
			return entryList.next().getKey();
		}

		@Override
		public void remove(Position<K> t) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("This is not supported.");
			
		}


		
	}
	
	private class KeyIterable implements Iterable<K>{

		@Override
		public Iterator<K> iterator() {
			// TODO Auto-generated method stub
			return new KeyIterator();
		}

		
	}
	
	public Iterable<K> keySet() {
		return new KeyIterable();
	}
	
	private class ValIterator implements Iterator<V>{
		private Iterator<Entry<K, V>> entryList = (Iterator<Entry<K, V>>) entrySet().iterator();
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return entryList.hasNext();
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub
			return entryList.next().getValue();
		}

		@Override
		public void remove(Position<V> t) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("This is not supported");
		}
		
	}
	
	private class ValIterable implements Iterable<V>{

		@Override
		public Iterator<V> iterator() {
			// TODO Auto-generated method stub
			return new ValIterator();
		}
		
	}
	
	public Iterable<V> valueEntries(){
		return new ValIterable();
	}
}
