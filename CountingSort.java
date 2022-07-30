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
 * Time Complexity 
 * N is number of elements
 * K is range of elements (largest element - smallest element)
 * 
 * Best-  O(n+k)  // When all elements are the same   
 * Avg -  O(n^2)  // N & K are equally dominant
 * Worst- O(n^2)  // When data is skewed and range is large
 */
public class CountingSort {
    
}
