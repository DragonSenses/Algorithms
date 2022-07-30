import java.util.Arrays;

/**
 * Counting Sort is a stable, non-comparative sorting algorithm,
 * with it's main use is for sorting arrays of non-negative integers.
 * 
 * Non-Comparative - performs the sort without any comparisons between the
 *  elements to be sorted.
 * Stable - sorting algorithm, Counting Sort preserves the order of the elements 
 *  with equal keys sorted in the output array as they were in the original array.
 *
 * This operation results in, essentially, a list of integer occurrences,
 * which is typically named the count array. It uses the auxilliary 
 * count array to determine the positions of elements
 * 
 * N is number of elements
 * K is range of elements (largest element - smallest element)
 * Time Complexity 
 * Best-  O(n+k)  // When all elements are the same   
 * Avg -  O(n^2)  // N & K are equally dominant
 * Worst- O(n^2)  // When data is skewed and range is large
 * 
 * Space Complexity : O(k)
 */
public class CountingSort {
    
    // Simple Implementation - Elements are only single digits ranging from 0-9
    public static int[] SimpleCountingSort(int[] arr){
        // Initialize countArray with 10 possible elements for every possible digit
        int[] countArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
        
        // 1. Populate countArray by counting the occurrence of each digit
        for(int i = 0; i < arr.length; i++) { // from 0 to n-1
            // Increment the value on the position arr[i] in countArray
            countArray[arr[i]]++; 
        } 
        // countArray = {1, 2, 0, 0, 1, 0, 0, 2, 1, 1}
        System.out.println(Arrays.toString(countArray));

        // 2. Apply Prefix sums to countArray
        // Prefix sums are formed when we add each of the previous numbers in the array
        // onto the next accumulatively forming a sum of all yet seen prefixes
        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i=1]; 
        }
        // countArray = {1, 3, 3, 3, 4, 4, 4, 6, 7, 8}
        System.out.println(Arrays.toString(countArray));

        return arr;
    }

    public static void main(String[] args){
        int[] arr = {0, 8, 4, 7, 9, 1, 1, 7};
        int[] sortedArr = SimpleCountingSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
