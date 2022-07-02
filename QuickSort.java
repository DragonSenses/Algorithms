import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Quick Sort is a divide and conquer algorithm like merge-sort but with a key difference,
 * most of the hard work is done before tthe recursive calls. 
 * 
 * 1. Divide: If a set S has at least two elements, select a specified element x from S, called
 * the pivot. Remove all elements of S and separate them into 3 subsets
 *      I.   Elements less than x
 *      II.  Elements equal to x  (if pivot x is distinct, only one element)
 *      III. Elements greater than x
 * 2. Conquer: Recursively sort sequences I and II
 * 3. Combine: Put back elements into S in order by first inserting elements of I, then II, then III
 * 
 * @author kendr
 */
public class QuickSort {
    
    /**
     * QuickSort implementation
     * @param <K> 
     * @param Q
     * @param C
     * 
     * Quick note on the method signature, even if method is returning void, the <K>
     * implies that the method will be dealing with generic type K. If dealing with 
     * more then <K,L> 
     */ 
    public static <K> void quickSort(Queue<K> Q, Comparator <K> C){
        int len = Q.size(); 
        if (len < 2) { return; } // Base Case: Queue is trivially sorted

        /** Divide **/
        // The first element is used as arbitrary pivot
        K pivot = (K) Q.poll();
        // Divide the elements within the 3 subsets
        Queue<K> I = new LinkedList<K>();
        
    }
}
