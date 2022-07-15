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
    
    public void heapSort(int[] arr){
        Queue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(arr).forEach(element -> pq.add(element));
        StringBuilder str = new StringBuilder("[");
        for(int k=0; pq.size() > 0; k++){
            if(k > 0) { str.append(", "); }
            str.append(pq.poll());
        }
        str.append("]");
        System.out.printf(str.toString());
    }
   
}
