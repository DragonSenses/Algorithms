import java.util.Comparator;

/**
 * A simple sorting algorithm that builds the final sorted array (or list) one
 * at a time. Iterates through a collection, consuming one input element each
 * repetition and grows a sorted output list. At each iteration, it removes 
 * one element from the input data, finds the location it belongs within the
 * sorted list, and inserts it there. It repeats until no input elements remain.
 * Typically sorting is done in-place, by iterating up the array, growing the 
 * sorted list behind it. At each-array position it checks the value against the
 * largest value in the sorted list. If larger it leaves the element in place
 * and moves to the next. If smaller, it finds the correct position within the
 * sorted list, shifts all the larger values up to make space, and inserts it
 * into the correct position. 
 * 
 * Less efficient on large lists than more advanced sorts (heapsort, mergesort,
 * quicksort). HOWEVER, the Straight Insertion Sort is best for small or very
 * nearly sorted lists. In fact, it is one of the fastest algorithms for 
 * sorting very small arrays, even faster than quicksort. As good quicksort 
 * implementations use insertion sort for arrays smaller than a certain threshold,
 * also when arising as subproblems. Exact threshold depends on machine and must
 * be determined experimentally, but commonly is around ten.
 * 
 * Advantages:
 * - Simple Implementation
 * - Efficient for small data sets
 * - Adaptive: meaning it is efficient for data sets that are already substantially 
 *             sorted; the time complexity is O(kn) where each element in the input
 *             is no more than k places away from its sorted position
 * - Stable: Does not change the relative order of elements with equal keys
 * - In-Place: Only requires a constant amount O(1) of additional memory space
 * - Online: Can sort a list as it receives it
 * 
 * Runtimes: Best case input of insertion sort is an array that is already sorted, so
 * it has a linear running time. During each iteration, the first remaining element of
 * the input is only compared with the right-most element of the sorted subsection of 
 * the array. Worst case input is an array sorted in reverse order, every iteration of 
 * the inner loop will scan and shift the entire sorted subsection of the array before 
 * inserting the next element giving it a quadratic running time. 
 * 
 * Best-  O(n)     
 * Avg -  O(n^2)
 * Worst- O(n^2)
 */
public class InsertionSort <E> {
    
    /**
     * Insertion sort on an array of integers 
     * @param data
     */
    public static void insertionSort(int[] data){
        int len = data.length;
        // 1. Mark First Element as sorted
        for(int k = 1; k < len; k++){       // Start with Second element
            int c = data[k];                // 2. Extract the element c
            int i = k;                      // Save the correct index for c
            while (i > 0 && data[i-1] > c){ // 3. If the data[i-1] is greater
                data[i] = data[i-1];        // 4. Move data[i-1] to the right
                i--;                        // 5. Repeat until data[i-1] is lesser
            }
            data[i] = c;                    // 6. Insert element here after loop
        }
    }

    /**
     * Insertion sort on an array of characters 
     * @param data
     */
    public static void insertionSort(char[] data){
        int len = data.length;
        // 1. Mark First Element as sorted
        for(int k = 1; k < len; k++){       // Start with Second Character
            char c = data[k];               // 2. Extract the element c
            int i = k;                      // Save the correct index for c
            while (i > 0 && data[i-1] > c){ // 3. If the data[i-1] is greater
                data[i] = data[i-1];        // 4. Move data[i-1] to the right
                i--;                        // 5. Repeat until data[i-1] is lesser
            }
            data[i] = c;                    // 6. Insert element here after loop
        }
    }

    Comparator<E> comp = (E x, E y) -> compare(x,y);

    /**
     * Compares Two Keys by natural ordering
     * @param x First key to compare
     * @param y Second key to compare
     * @return -1 if x < y, 
     *          0 if x==y, 
     *          1 if x > y
     */
    protected int compare(E x, E y){
        return comp.compare(x,y);
    }

    /**
     * Insertion sort on an array of generic type 
     * @param data
     */
    public void insertionSort(E[] data){
        int len = data.length;
        // 1. Mark First Element as sorted
        for(int k = 1; k < len; k++){       // Start with Second Character
            E e = data[k];                  // 2. Extract the element c
            int i = k;                      // Save the correct index for c
            while (i > 0 && comp.compare(e,data[i-1]) <= 0){ // 3. If the data[i-1] is greater
                data[i] = data[i-1];        // 4. Move data[i-1] to the right
                i--;                        // 5. Repeat until data[i-1] is lesser
            }
            data[i] = e;                    // 6. Insert element here after loop
        }
    }
    // data[i-1] > e
    // e < data[i-1]
    // x < y
    // -1 or 0 (if duplicates allowed
    // 

    public static void main(String[] args) {
        char[] a = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
        System.out.println(java.util.Arrays.toString(a));
        insertionSort(a);
        System.out.println(java.util.Arrays.toString(a));
      }
}
