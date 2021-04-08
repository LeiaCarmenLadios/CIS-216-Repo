package bnrytrarr;

import java.util.NoSuchElementException;

public interface BinaryTree<T> extends Tree<T>{
    
	int left(int index) throws IllegalArgumentException;
	
	int right(int index) throws IllegalArgumentException;
	
	int sibling(int index) throws IllegalArgumentException;
	
}
