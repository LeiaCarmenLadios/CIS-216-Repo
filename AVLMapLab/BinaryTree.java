

import java.util.NoSuchElementException;

public interface BinaryTree <T> extends Tree<T>{
    

	Position<T> sibling(Position<T> p) throws IllegalArgumentException;

	Position<T> right(Position<T> p) throws IllegalArgumentException;

	Position<T> left(Position<T> p) throws IllegalArgumentException;
	
}
