
public abstract class AbstractPQ<J, T> 
					implements PriorityQueue<J,T>{

	protected static class PQEntry<J, T> implements Entry<J, T> {
		private J key;
		private T value;

		public PQEntry(J key, T value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public J getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public T getValue() {
			// TODO Auto-generated method stub
			return value;
		}
		
		protected void setKey(J key) {
			this.key = key;
		}
		
		protected void setValue(T value) {
			this.value = value;
		}

	}

	private PQComparator<J> comp;

	protected AbstractPQ(PQComparator<J> comp) {
		this.comp = comp;
	}

	protected AbstractPQ() {
		this(new PQComparator<J>());
	}

	protected int compare(Entry<J, T> one, Entry<J, T> two) {
		return comp.compare(one.getKey(), two.getKey());
	}

	protected boolean checkKey(J key) throws IllegalArgumentException {
		try {
			return comp.compare(key, key) == 0;
		} catch (Exception e) {
			throw new IllegalArgumentException("There has been" 
					+ " an incompatible key detected.");
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

}
