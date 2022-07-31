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
    
    /**
     * A simple Counting Sort Algorithm
     * @param input = Input integer array
     * @param k - The range of values, from 0 to k
     */
    public static void countingSort(int[] input, int k){
        int counter[] = new int[k+1]; // Create count array
        
        // 1. Fill the CountArray
        for(int i: input){ // For every integer in input array
            counter[i]++;  // Increment ith position
        }

        // 2. Sort Array
        int i = 0; // index
        for(int n = 0; n< counter.length; n++){
            while(0 < counter[n]) {
                input[i++] = n;
                counter[n]--; 
            }
        }
    }

    public static final boolean debug = false;
    //  Elements are only single digits ranging from 0-9
    public static int[] SimpleCountingSort(int[] arr){
        // Initialize countArray with 10 possible elements for every possible digit
        int[] countArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 

        // 1. Populate countArray by counting the occurrence of each digit
        for(int i = 0; i < arr.length; i++) { // from 0 to n-1
            // Increment the value on the position arr[i] in countArray
            countArray[arr[i]]++; 
        } 
        // countArray = {1, 2, 0, 0, 1, 0, 0, 2, 1, 1}
        if(debug) { System.out.println(Arrays.toString(countArray)); }

        // 2. Apply Prefix sums to countArray
        // Prefix sums are formed when we add each of the previous numbers in the array
        // onto the next accumulatively forming a sum of all yet seen prefixes
        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1]; 
        }
        // countArray = {1, 3, 3, 3, 4, 4, 4, 6, 7, 8}
        if(debug){ System.out.println(Arrays.toString(countArray)); }

        // 3. Calculate element positions in the sorted output based off the values
        // in countArray. Make a new auxiliary array to store the output, the size
        // is the same as input array
        int[] aux = new int[arr.length];
        if(debug) { System.out.println(Arrays.toString(aux)); }
        for(int i = arr.length-1; i >= 0; i--){
            // Find index in countArray that is equal to value of current element arr[i]
            // at position countArray[arr[i] -1, place element arr[i]. 
            aux[countArray[arr[i]] -1 ] = arr[i]; // Guarantees stability of sort
            countArray[arr[i]]--; // Decrement value of countArray[i]
        }

        // Copy values from aux array into initial array, and print
        for(int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
        if(debug) { Arrays.toString(arr); }
        return aux;
    }

    /**
     * Improved CountingSort from above, that allows user to select the 
     * range of values. Where k is the maximum value, and the range of
     * input array is between 0 to k, [0,k].
     * @param arr   Input Array
     * @param k     The max range of values
     * @return      The final sorted array of the input
     */
    public static int[] betterCountingSort(int[] arr, int k){
        // Initialize countArray with k+1 possible elements, including 0 and k
        int[] countArray = new int[k+1]; 

        // 1. Populate countArray by counting the occurrence of each digit
        for(int i = 0; i < arr.length; i++) { // from 0 to n-1
            // Increment the value on the position arr[i] in countArray
            countArray[arr[i]]++; 
        } 

        // 2. Apply Prefix sums to countArray
        // Prefix sums are formed when we add each of the previous numbers in the array
        // onto the next accumulatively forming a sum of all yet seen prefixes
        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1]; 
        }

        // 3. Calculate element positions in the sorted output based off the values
        // in countArray. Make a new auxiliary array to store the output, the size
        // is the same as input array
        int[] aux = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            // Find index in countArray that is equal to value of current element arr[i]
            // at position countArray[arr[i] -1, place element arr[i]. 
            aux[countArray[arr[i]] -1 ] = arr[i]; // Guarantees stability of sort
            countArray[arr[i]]--; // Decrement value of countArray[i]
        }

        // Copy values from aux array into initial array, and print
        for(int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
        if(debug) { Arrays.toString(arr); }
        return aux;
    }

    public static void main(String[] args){
        int[] input = { 60, 40, 30, 20, 10, 40, 30, 60, 60, 20, 40, 30, 40 };
        int k = 60; 
        System.out.println("Before Sorting"); 
        System.out.println(Arrays.toString(input)); 
        countingSort(input, k); 
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(input));
        
        System.out.println();
        System.out.println("Another Counting Sort Example: ");
        int[] arr = {0, 8, 4, 7, 9, 1, 1, 7};
        System.out.println("Before Sorting"); 
        System.out.println(Arrays.toString(arr)); 
        int[] sortedArr = SimpleCountingSort(arr);
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(sortedArr));

        System.out.println();
        System.out.println("Counting Sort Example 3: ");
        System.out.println("Before Sorting"); 
        System.out.println(Arrays.toString(input)); 
        betterCountingSort(input, k); 
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(input));
    }
}
