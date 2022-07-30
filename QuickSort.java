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
 *        of the array and use that as the pivot. Requires lower overhead than random number generator.
 *        This can scale for larger sets, as more than three potentional pivots may be computed
 * 2) Sorting In-Place
 *     - Another key difference of quicksort and mergesort is that mergesort requires more memory as it
 *      uses an auxiliary array to store the sorted values. Depending on the implmentation quicksort may
 *      also use just as much memory. The first implementation here does so. 
 *     - To Sort In-Place, we must use the input sequence itself to store the subsequences. Element 
 *      swapping and representing subsequences implicitly by their indexes, from leftmost index to 
 *      rightmost index
 *          
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
    
    /** @returns The Median of three values to be used as the pivot */
    private static <K> K medianOfThree(Comparator<K> C, K lo, K mid, K hi){
        //Example --> lo = 0, mid = 4, hi = 8
        /* mid < lo --> (4 < 0) --> -1 --> (-1 < 0) median = mid
         * 
         *  x < y   -1          x<= y 
         *  x == y   0
         *  x > y    1  
         */
        K median = (C.compare(mid,lo) < 0) ? mid:lo;

        //Brute forcing comparisons to find median
        if ( ((C.compare(mid,lo) < 0)&&(C.compare(lo,hi) < 0))
        || (C.compare(hi,lo) < 0) && (C.compare(lo,mid) < 0) ){
            median = lo; // mid < lo < hi OR hi < lo < mid
        } else if ( (C.compare(lo,mid)<0)&&(C.compare(mid,hi)<0)
        || ((C.compare(hi,mid)<0) && (C.compare(mid,lo)<0 )) ){
            median = mid; // lo < mid < hi OR hi < mid < lo
        } else {
            median = hi; 
        }
        return median;
    }
    
    /**
     * Swaps elements of a given generic array
     * @param <K>   The type to use
     * @param a - The incoming target array to swap elements in
     * @param m - The index of the first element to swap
     * @param n - The index of the second element to swap
     */
    private static <K> void swap(K[] a, int m, int n){
        K temp = a[m]; a[m] = a[n]; a[n] = temp;
    }

    /**
     * In-Place QuickSort optimization which uses a small amount of memory compared to ones
     * which use additional containers that store sorted results. To do this we need to 
     * implicitly represent a subsequence through a range of indexes. There is no step to 
     * explicitly "combine" or concatenate since the two subsequences will concetenate implicitly
     * to the in-place use of the original array
     * @param <K> - The generic data type
     * @param a  - Incoming caller array
     * @param C  - Comparator
     * @param lo - The leftmost index of the subsequence
     * @param hi - The rightmost index of the subsequence
     */
    public static <K> void quickSortInPlace(K[] a, Comparator<K> C, int lo, int hi){
        if(lo >= hi) { return; } //Base Case: Subarray is Trivially sorted

        /** Divide **/
        // Local variables left and right will be used to scan the array simultaneously
        // These pairs of runners will swap pairs of elements that are in reverse order
        // When these two indexes pass each other, the division step is complete, then
        // algorithm contines by recurring on the two sublists
        int left = lo;      // Runner advances forward through the array
        int right = hi-1;   // Runner advances backwards through the array
        
        // K pivot = a[hi]; // Pivot choice is conventionally rightmost element
        // middle = (low + high) >>> 1, always gives positive result as opposed to lo+hi/2, may overflow
        K pivot = medianOfThree(C, a[lo], a[(lo+hi)>>>1], a[hi]); //Optimized Pivot Choice

        while(left <= right) {
            //1. Scan until reaching value Equal or Larger than pivot (or right runner)
            while (left <= right && C.compare(a[left], pivot) < 0) { left++; }
            //2. Scan until reaching value Equal or Smaller than pivot (or left runner)
            while (left <= right && C.compare(a[right],pivot) > 0 ) { right--; }
            //3. Indices did not strictly cross
            if(left <= right) {
                // Swap values then shrink range of runners
                swap(a, left,right);
                left++; right--; 
            }
        }
        // At this point, the left index marks the pivot, swap it to put into its final place
        swap(a, left, hi);
        //make recursive calls
        quickSortInPlace(a, C, lo, left-1); // The left half of the subarray 
        quickSortInPlace(a, C, left+1, hi); // The right half of the subarray
    }
}
