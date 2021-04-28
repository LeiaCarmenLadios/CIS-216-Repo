import java.util.ArrayList;

public class SortedTableMap<K,V> extends AbstractSortedMap<K,V>{
	private ArrayList<MapEntry<K,V>> tbl = new ArrayList<MapEntry<K,V>>();
	
	public SortedTableMap() {
		super();
	}
	
	public SortedTableMap(DefaultComparator<K> comparator) {
		super(comparator);
	}
	
	private int findIndex(K key, int low, int high) {
		if(high < low)
			return high + 1;
		int mid = (low + high) / 2;
		int comp = compare(key, tbl.get(mid));
		
		if(comp == 0)
			return mid;
		else if(comp < 0)
			return findIndex(key, low, mid - 1);
		else
			return findIndex(key, mid + 1, high);
	}
	
	private int findIndex(K key) {
		return findIndex(key, 0, tbl.size() - 1);
	}
	
	private Entry<K, V> safeEntry(int i){
		if(i < 0 || i >= tbl.size())
			return null;
		return tbl.get(i);
	}
	
	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return safeEntry(0);
	}

	@Override
	public Entry<K, V> lastEntry() {
		// TODO Auto-generated method stub
		return safeEntry(tbl.size() - 1);
		
	}

	@Override
	public Entry<K, V> ceilingEntry(K k) {
		// TODO Auto-generated method stub
		return safeEntry(findIndex(k));
	}

	@Override
	public Entry<K, V> floorEntry(K k) {
		// TODO Auto-generated method stub
		int i = findIndex(k);
		if(i == size() || !k.equals(tbl.get(i).getKey()))
			i--;
		return safeEntry(i);
	}

	@Override
	public Entry<K, V> lowerEntry(K k) {
		// TODO Auto-generated method stub
		return safeEntry(findIndex(k) - 1);
	}

	@Override
	public Entry<K, V> higherEntry(K k) {
		// TODO Auto-generated method stub
		int i = findIndex(k);
		if(i < size() && k.equals(tbl.get(i).getKey()))
			i++;
		return safeEntry(i);
	}

	private Iterable<Entry<K, V>> snapshot(int start, K end){
		ArrayList<Entry<K, V>> buf = new ArrayList<Entry<K, V>>();
		int i = start;
		while (i < tbl.size() && (end == null || compare(end, tbl.get(i)) > 0)) {
			buf.add(tbl.get(i++));
		}
		return (Iterable<Entry<K, V>>) buf;
	}
	@Override
	public Iterable<Entry<K, V>> subMap(K kOne, K kTwo) {
		// TODO Auto-generated method stub
		return snapshot(findIndex(kOne), kTwo);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tbl.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		
		int i = findIndex(key);
		if(i == size() || compare(key, tbl.get(i)) != 0)
			return null;
		return tbl.get(i).getValue();
		
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		
		int i = findIndex(key);
		if(i < size() && compare(key, tbl.get(i)) == 0) {
			return tbl.get(i).setValue(value);
		}
		tbl.add(i, new MapEntry<K,V>(key, value));
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		int i = findIndex(key);
		if(i == size() || compare(key, tbl.get(i)) != 0)
			return null; 
		return tbl.remove(i).getValue();
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		ArrayList<V> values = new ArrayList<V>();
		for(int i = 0; i < tbl.size(); i++) {
			values.set(i, tbl.get(i).getValue());
		}
		return (Iterable<V>) values;   
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return snapshot(0, null);
	}
	
}
