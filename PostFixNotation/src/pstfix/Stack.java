package pstfix;

/**
 * Stack ADT from the book
 * @param <T>
 */
public interface Stack<T> {
   
   /**
    * Returns number of elements in the stack
    * @return number of elements in the stack
    */
   int size();
   
   /**
    * Tests if the stack is empty
    * @return true if the stack is empty
    *         false if not empty
    */
   boolean isEmpty();
   
   /**
    * Inserts an element at the top of the stacks
    * @param t element to be inserted
    */
   void push(T e);
   
   /**
    * Returns the element at top of the stack
    * but does not remove it
    * @return top element in the stack
    */
   T top();
   
   /**
    * Removes and returns top element from the stack
    * @return element removed(or null if stack is empty)
    */
   T pop();
   
}
