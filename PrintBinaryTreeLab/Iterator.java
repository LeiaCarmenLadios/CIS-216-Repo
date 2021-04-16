package bnrytrarr;

import java.util.NoSuchElementException;

public interface Iterator<T> {
  
	boolean hasNext();
	
	T next() throws NoSuchElementException;
	
	void remove(T t) throws IllegalStateException;
}
