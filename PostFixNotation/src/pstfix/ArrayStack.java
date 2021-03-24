package pstfix;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T>{
      public static final int CAPACITY = 50;
      private T[] data;
      private int t = -1;  // empty stack
      
      public ArrayStack() {
         this(CAPACITY);
      }
      
      @SuppressWarnings("unchecked")
      public ArrayStack(int capacity) {
         data = (T[])new Object[capacity];
      }
      
      @Override
      public int size() {
         return t + 1;
      }
      
      @Override
      public boolean isEmpty() {
         if(t == -1) {
            return true;
         }
         return false;
      }
      
      @Override
      public void push(T e) {
         if(size() == data.length) {
            System.out.println("Stack Full");
         }
       
         
         data[++t] = e;
      }
      
      @Override
      public T top() {
         if(isEmpty()) {
            System.out.println("Empty Stack");
            return null;
         }
         return data[t];
      }
      
      @Override
      public T pop() {
        if(isEmpty()) {
           return null;
        }
        T toRemove = data[t];
        data[t] = null; //dereference
        t--;
        
        return toRemove;
      }
   
      public T evaluate(String pst) {
         
            for(int i = 0; i < pst.length(); i++) {
               
               Character curr = pst.charAt(i);
           
               if(Character.isDigit(curr)) {
                  Integer j = new Integer(Character.getNumericValue(curr));
                  this.push((T)j);   
               }
             
               if((curr == '%' || curr == '/' || curr == '*' 
                 || curr == '+' || curr == '-') && size() >= 2) {
                  //System.out.println(curr);

                  T a = this.pop();
                  T b = this.pop();
                 
                  if(curr == '%') {
                     Integer mod = (Integer)b % (Integer)a; // must cast to do operations
                     this.push((T)mod);
                    // System.out.println(this.top());
                  }
                  else if (curr == '/') {
                     Integer div = (Integer)b / (Integer)a; // must cast to do operations
                     this.push((T)div);
                     //System.out.println(this.top());
                  }
                  else if(curr == '*') {
                     Integer mult = (Integer)b * (Integer)a; // must cast to do operations
                     this.push((T)mult);
                     //System.out.println(this.top());
                  }
                  else if(curr == '+') {
                     Integer add = (Integer)b + (Integer)a; // must cast to do operations
                     this.push((T)add);
                    // System.out.println(this.top());
                  }
                  else if(curr == '-') {
                     Integer sub = (Integer)b - (Integer)a; // must cast to do operations
                     this.push((T)sub);
                     //System.out.println(this.top());
                  }
                  
               }
               else if(i == pst.length() -1) {
                  System.out.println("Not enough arguments. Please try again.");
                  return null;
               }
             
               
            }
         return this.pop();
      }
      
    
      
}
