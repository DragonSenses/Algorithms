import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * 
 * Implementation: Using a priority queue is a convenient 
 * data structure to implement heap sort
 * 
 * Time Complexity - O(nlogn)
 *  - O(logn) time to add and remove elements
 *  - O(n) time since loop runs n times
 */
public class HeapSort {
    /******************** First HeapSort Implementation ********************/
    
    public heapSort(int[] arr){
        Queue<Integer> pq = new PriorityQueue();
        Arrays.stream(arr).forEach(element -> pq.add(element));

        while(pq.size() > 0) {
            
        }
    }
   
}
