import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is a collection of Quick Sorts, with each different implementation having its own 
 * method and helper methods.
 * 
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
 * Optimizations: 
 * 1) Choosing the Pivot
 *      - Rightmost pivot will prove the worst case when original sequence is already sorted, reverse
 *        sorted, or nearly sorted. O(n^2)
 *      - Randomizing the pivot choice shows expected running time is O(nlogn)
 *      - Median-Of-Three heurisiticm which takes the median of three values (front, middle, and tail)
 *        of the array and use that as the pivot. Requires lower overhhead than random number generator.
 *        This can scale for larger sets, as more than three potentional pivots may be computed
 * 2) Sorting In-Place
 *     - Another key difference of quicksort and mergesort is that mergesort requires more memory as it
 *      uses an auxiliary array to store the sorted values. Depending on the implmentation quicksort may
 *      also use just as much memory. The first implementation here does so. 
 *     - To Sort In-Place, we must use the input sequence itself to store the subsequences. Element 
 *      swapping and representing subsequences implicitly by their indexes, from leftmost index to 
 *      rightmost index
 *          
 * @author kendr
 */
public class QuickSort {
    
    /**
     * QuickSort implementation
     * @param <K>   The type of values to work with
     * @param Q     The queue that stores the elements to sort
     * @param C     The comparator
     * 
     * Quick note on the method signature, even if method is returning void, the <K>
     * implies that the method will be dealing with generic type K. If dealing with 
     * more then <K,L> 
     */ 
    public static <K> void quickSort(Queue<K> Q, Comparator <K> C){
        int c;      // Be used to store the result of compare()
        K element;  // The current element to compare pivot to
        int len = Q.size(); 
        if (len < 2) { return; } // Base Case: Queue is trivially sorted

        // The first element is used as arbitrary pivot
        K pivot = (K) Q.poll();

        // Divide the elements within the 3 subsets
        Queue<K> less = new LinkedList<K>();
        Queue<K> equal = new LinkedList<K>();
        Queue<K> greater = new LinkedList<K>();

        /** Divide **/
        //While Queue is nonempty, divide elements and insert into subsets
        while(!Q.isEmpty()) { 
            // Used poll() to get null rather than remove(), which throws an exception when queue is empty
            element = Q.poll(); 
            c = C.compare(element,pivot);
            // Output from compare is -1 if less, 0 if equal, 1 if greater 
            switch(c){
                case -1:
                    less.add(element);
                case 0: 
                    equal.add(element);
                case 1:
                    greater.add(element);
                default:
                    return; 
            }
        }

        /** Conquer **/
        quickSort(less,C);      // Sort elements less than pivot
        quickSort(greater,C);   // Sort elements greater than pivot

        /** Combine **/
        while(!less.isEmpty()){
            Q.add(less.remove());
        }
        while(!equal.isEmpty()){
            Q.add(equal.remove());
        }
        while(!greater.isEmpty()){
            Q.add(greater.remove());
        }
    }

    /******************** Second Implementation ********************/
    
    private static <K> void quickSortInPlace(K[] a, Comparator<K> c, int lo, int hi){

    }
}
