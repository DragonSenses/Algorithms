import java.util.Arrays;
import java.util.Comparator;

/**
 * This class is a collection of merge sorts, with each sort method and its helper methods
 * another implementation
 * 
 * Merge Sort is a divide and conquer algorithm known for its stability with worst, average,
 * and even best case of O(nlogn)
 * 
 * 1. Divide: If input size is smaller than a certain threshold (1 or 2 items), solve and 
 * return the solution. Otherwise, divide the input into two or more subsets
 * 2. Conquer: Recursively solve the subproblems with the given subsets
 * 3. Combine: Take the solutions to the subproblems and merge them into a larger solution
 * to the original problem
 * 
 * 
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
                a[i+j] = x[i++];   //Copy ith element of x into main array a, increment i
            } else {
                a[i+j] = y[j++];   //Copy jth element of y into main array a, increment j
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

    /******************** Second MergeSort Implementation ********************/
    /**
     * One way to solve a problem is to divide it into independent parts, conquer them independently,
     * and then use the solutions for the parts to develop a solution for the full problem
     * 
     * Base Case: If The subarray length is 0 or 1, it is already sorted
     * Reduction Step: Otherwise, compute mid = lo + (hi - lo)/2, recursively sort the two sub arrays
     * a[lo,mid) and a[mid, hi)  and merge them
     * 
     * Source: Sedgewick, R., &amp; Wayne, K. (2017). 
     *   Introduction to programming in java: An interdisciplinary approach. Addison-Wesley. 
     * @author Sedgewick, R.
     * @author Wayne, K.
     * 
     * Private static helper Method 
     * @param <K>   The generic type
     * @param a     The main array to sort
     * @param aux   The auxiliay array that temporarily holds the results
     * @param lo    The smallest index of the array to sort for the first half
     * @param hi    The largest index of the array to sort for the second half
     */
    @SuppressWarnings("unchecked")
    private static <K> void sort(Comparable<K>[] a, Comparable<K>[] aux, int lo, int hi){
        //Sorting a[lo, hi) which is the subarray to sort
        if(hi - lo <= 1) return;  //Array is Trivially sorted
        int mid = lo + (hi-lo)/2; //Store the middle index
        
        sort(a,aux,lo,mid); // sort subarray a[lo, mid) 
        sort(a,aux,mid,hi); // sort subarray a[mid, hi)

        //Set aux[k] to either a[i] or a[j] then increments both k and index of subarray used
        /**
         * The first 2 cases involves whether i or j has reached the end of its subarray, then 
         * set aux[k] from the other in these edge cases. Otherwise, compare the values with
         * each subarray and set aux[k] to the smaller of the two, either a[i] or a[j].
         * 
         * After all this, the sorted result auxiliary array, aux[], is copied back to original
         * array. This recursive method ensures that two subarrays are sorted before the merge.
         */
        int i = lo, j = mid;
        for(int k = lo; k < hi; k++){
            if (i == mid) {         //Index i has reached the end of its subarray
                aux[k] = a[j++];    //aux[k] is set from the other a[j]
            }
            else if (j == hi) {     //Index j has reached the end of its subarray
                aux[k] = a[i++];    //aux[k] is set from the other a[i]
            }   
            else if(a[j].compareTo((K)a[i]) < 0) { //Which subarray has the smaller value? 
                // a[j] < a[i] returned either -1 or 0, so a[j] is the smaller value
                aux[k] = a[j++];    //Set aux[k] as subarray a[j]  since it is smaller
            } else{
                // a[j] < a[i] returned 1, so 1 < 0 is false, so a[j] is the greater value
                aux[k] = a[i++];    //Set aux[k] as subarray a[i] since it is smaller
            }
        }
        //Repopulate the Original Array with the sorted result of auxiliary array
        for(int k = lo; k < hi; k++){
            a[k] = aux[k];
        }
    }
    
    /**
     * The main recursive call
     * @param <K>
     * @param a
     */
    @SuppressWarnings("unchecked") //Small change from original, since applying generics
    public static <K> void sort(Comparable<K>[] a){
        Comparable<K>[] aux = (Comparable<K>[]) new Object[a.length]; //auxiliary array
        sort(a, aux, 0, a.length);
    }

    /******************** Third MergeSort Implementation ********************/

    /**
     * The Bread and Butter of the mergesort. Here we conquer and merge
     * @param arr   Incoming caller array
     * @param aux   Auxliary array to store sorted values to
     * @param low   The lowest index
     * @param mid   Mid point
     * @param high  The highest index
     */
    private void merge(int[] arr, int[] aux, int low, int mid, int high){
        /* Copy Both halves into auxiliary array */
        for(int i = low; i <= high; i++){
            aux[i] = arr[i];
        }

        //Create runners to keep track of the start of the left and right halves
        int left = low;
        int right = mid + 1;
        int curr = low;

        /**
         * Iterate through auxiliary array and compare left and right halves, copying
         * the smaller element of the two halves into the original array.
         */
        while(left <= mid && right <= high){ //While runners are not at end of their subarray
            arr[curr] = (aux[left] <= aux[right]) ? aux[left++] : aux[right++];
            // The equivalent of the ternary operator statement is below
            // if(aux[left] <= aux[right]){
            //     arr[curr] = aux[left];
            //     left++;
            // } else {
            //     arr[curr] = aux[right];
            //     right++;
            // }
            curr++;
            
            
        }

        /** Copy the rest of the left side of the auxiliary array into the target array 
         *  The right side does not need to be copied since it is already there. 
         */
        int restOfArray = mid - left;
        for(int i = 0; i <= restOfArray; i++){
            arr[curr + i] = aux[left +i];
        }
        
    }

    /** Divide **/
    private void mergesort(int[] arr, int[] aux, int low, int high) {
        if (low < high) {
            int mid = (low + high)/2;
            mergesort(arr, aux, low, mid);   //Sort the left half
            mergesort(arr,aux, mid+1, high); //Sort the right half
            merge(arr, aux, low, mid, high); //Merge them 
        }
    }

    /**
     * Starts the mergesort with only incoming parameter is the integer array.
     * @param arr The original integer array to sort
     */
    public void mergesort(int[] arr) {
        int[] aux = new int[arr.length];
        mergesort(arr, aux, 0, arr.length-1);
    }


    /******************** Fourth MergeSort Implementation ********************/
} //EOF