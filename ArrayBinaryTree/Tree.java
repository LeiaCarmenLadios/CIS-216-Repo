package bnrytrarr;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface Tree<T> extends Iterable<T>{
	
	
	T root();
	
	int parent(int index) throws IllegalArgumentException;
	
	Iterable<T> children(T element, int index) throws IllegalArgumentException;
	
	int numChildren(int index) throws IllegalArgumentException;
	
	boolean isInternal(int index) throws IllegalArgumentException;
	
    boolean isExternal(int index) throws IllegalArgumentException;
    
    boolean isRoot(int index) throws IllegalArgumentException;
    
    int size();
    
    boolean isEmpty();
    
    Iterator<T> iterator();

    ArrayList<T> positions();
	
	
}
