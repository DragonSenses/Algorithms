/**
 * Quick Sort is a divide and conquer algorithm like merge-sort but with a key difference,
 * most of the hard work is done before tthe recursive calls. 
 * 
 * 1. Divide: If a set S has at least two elements, select a specified element x from S, called
 * the pivot. Remove all elements of S and separate them into 3 categories
 *      I.   Elements less than x
 *      II.  Elements equal to x  (if pivot x is distinct, only one element)
 *      III. Elements greater than x
 * 2. Conquer: Recursively sort sequences I and II
 * 3. Combine: Put back elements into S in order by first inserting elements of I, then II, then III
 * 
 * @author kendr
 */
public class QuickSort {
    
}
