package bnrytrarr;

import java.util.NoSuchElementException;

public interface BinaryTree<T> extends Tree<T>{
    

	int sibling(int index) throws IllegalArgumentException;

	T right(T element) throws IllegalArgumentException;

	T left(T element) throws IllegalArgumentException;
	
}
