import java.util.Comparator;

/**
 * Keep swapping adjacent elements of an array until the collection is sorted.
 * Small items "bubble" to the top of the list as we iterate through the data structure.
 * 
 * Worst Case:   O(n^2)
 * Best Case:    O(n)
 * Average Case: O(n^2)
 * 
 * @author kendr
 */
public class BubbleSort {
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
    
    public <K> void bubbleSort(K[] a, Comparator<K> C){
        int len = a.length;
        for(int idx = len-1; idx > 0; idx-- ){
            for(int j = 0; j < idx; j++){
                if(C.compare(a[idx], a[idx+1]) > 1) {
                    swap(a,idx,idx+1);
                }
            }
        }
    }
}
