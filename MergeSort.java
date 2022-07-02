import java.util.Arrays;
import java.util.Comparator;

/**
 * Merge Sort is a divide and conquer algorithm with a O(nlogn). This is done in 3 steps:
 * 1. Divide: If input size is smaller than a certain threshold (1 or 2 items), solve and 
 * return the solution. Otherwise, divide the input into two or more subsets.
 * 2. Conquer: Recursively solve the subproblems with the given subsets
 * 3. Combine: Take the solutions to the subproblems and merge them into a larger solution
 * to the original problem
 * @author kendr
 */
public class MergeSort {

    /**
     * Merges the contents of first half of subarray withh second half of another subarray
     * into a properly sized array 
     * @param <K>  
     * @param x - First subarray
     * @param y - Second subarray
     * @param a  - Main Array to sort into
     * @param C  - The Comparator
     */
    public static <K> void merge(K[] x, K[] y, K[]a, Comparator<K> C){
        int i = 0, j = 0;   // Will represent the index for each subarray, i for x and j for y

        //Keep looping until each contents of both subarray is still not the size of the main array
        while(i + j < a.length){ 
            /**
             * compare(x,y) returns -1, 0, 1 for the cases respectively: 
             * I) x < y         II) x == y          III) x > y
             * 
             * So if x < y, or x[i] < y[j], then -1, which is -1 < 0 so x[i] will be copied
             * into main array. Otherwise, y[j] was a lower value, so it will be copied into
             * main array
             */
            if(j == y.length || (i < x.length && C.compare(x[i], y[j]) < 0)){
                a[i+j] = x[i++];   //Copy ith element of a1 into main array a, increment i
            } else {
                a[i+j] = y[j++];   //Copy jth element of a2 into main array a, increment j
            }
        }
    }

    public static <K> void mergeSort(K[] arr, Comparator<K> C){
        int l = arr.length;
        // Case 1: Array is Trivially sorted
        if ( l < 2) { return; }  

        /** Divide **/
        int mid = l/2; // Mid point of the array
        K[] arr1 = Arrays.copyOfRange(arr,0,mid);   // Copy First Half of Array
        K[] arr2 = Arrays.copyOfRange(arr,mid,l);         // Copy of Second Half of Array

        /** Conquer **/ 
        //Using recursion, sort the halves of the array
        mergeSort(arr1,C);
        mergeSort(arr2,C);

        /** Merge **/
        merge(arr1, arr2, arr, C); //Merge the sorted halves back into thhe original

    }

} //EOF