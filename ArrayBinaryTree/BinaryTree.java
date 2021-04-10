package bnrytrarr;

import java.util.NoSuchElementException;

public interface BinaryTree<T> extends Tree<T>{
    
	T left(int index) throws IllegalArgumentException;
	
	T right(int index) throws IllegalArgumentException;
	
	int sibling(int index) throws IllegalArgumentException;
	
}
