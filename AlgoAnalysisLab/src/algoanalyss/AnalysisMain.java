
package algoanalyss;

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;
public class AnalysisMain {
   public static void main(String[] args) {
      
      int sizeOfArray = 500;
      int[] integerArr = new int[sizeOfArray];
      
      System.out.println("Size of Array: " +sizeOfArray);
      Random generator = new Random();
      for(int i = 0; i < sizeOfArray; i ++) {
         integerArr[i] = generator.nextInt(sizeOfArray)+1;
      }
      
      for(int j = 20; j != 0; j --) {
         long start = System.currentTimeMillis();
         Arrays.sort(integerArr);
         long end = System.currentTimeMillis();
         
         long elapsed = end - start;
         
         System.out.println("Time to accomplish sort: " + elapsed + " milliseconds");
         
         //linearithmic O(nlogn) time
         long referenceFunction = (long)sizeOfArray * (long  )Math.log(sizeOfArray);
         
         System.out.println("Reference Func Value: " + referenceFunction);
         double ratio;
         if(elapsed != 0) 
            ratio = ((double)elapsed)/referenceFunction;
         else {
            ratio = 0;
         }
         
         System.out.println("Ratio (Reference function:Elapsed time): " + ratio);
         
         if(j -1 !=0) {
            sizeOfArray *= 2;
            integerArr = new int[sizeOfArray];
            System.out.println("\n\nSize of Array: " + sizeOfArray);
            
         }
         for(int k = 0; k < sizeOfArray; k++) {
            integerArr[k] = generator.nextInt(sizeOfArray) + 1;
         }
      }
   }
}
