

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Tree<T> extends Iterable<T>{
	
	
	Position<T> root();
	
	Position<T> parent(Position<T> p) throws IllegalArgumentException;
	
	Iterable<T> children(T element, int index) throws IllegalArgumentException;
	
	int numChildren(Position<T> p) throws IllegalArgumentException;
	
	boolean isInternal(Position<T> index) throws IllegalArgumentException;
	
    boolean isExternal(Position<T> index) throws IllegalArgumentException;
    
    boolean isRoot(Position<T> index) throws IllegalArgumentException;
    
    int size();
    
    boolean isEmpty();
    

	
}
