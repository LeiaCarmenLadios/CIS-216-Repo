
public interface SortedMap<K,V> {
	Entry<K, V> firstEntry();
	Entry<K,V> lastEntry();
	Entry<K, V> ceilingEntry(Entry<K,V> k);
	Entry<K, V> floorEntry(Entry<K,V> k);
	Entry<K, V> lowerEntry(Entry<K,V> k);
	Entry<K, V> higherEntry(Entry<K,V> k);
	Iterable<Entry<K,V>> subMap(Entry<K,V> kOne, Entry<K,V> kTwo);
}
