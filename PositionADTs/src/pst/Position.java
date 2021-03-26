package pst;

public interface Position<T> {
   /**
    * Returns the element stored at this position
    * 
    * @return the stored Element
    * @throws IllegalStateException
    */
   T getElement() throws IllegalStateException;
}
