import java.util.Comparator;

/**
 * Keep swapping adjacent elements of an array until the collection is sorted.
 * Small items "bubble" to the top of the list as we iterate through the data structure.
 * 
 * Worst Case:   O(n^2)
 * Best Case:    O(n)
 * Average Case: O(n^2)
 * 
 */
public class BubbleSort {
    /******************** First BubbleSort Implementation ********************/
    private static void swap(int[] a, int m, int n){
        int temp = a[m]; a[m] = a[n]; a[n] = temp;
    }

    /**
     * Smaller values gradually bubbble their way to the top while larger values sink to the
     * bottom. After the first pass, last element becomes largest in the array. After 2nd pass,
     * the second to last elements becomes the second largest in the array.
     * @param list - An integer array, or list of values to sort
     */
    public void bubbleSort(int[] list){
        for(int k = 1; k < list.length; k++){ 
            for(int i = 0; i < list.length - k; i++){
                if (list[i] > list[i + 1]){
                    swap(list,i,i+1);
                }
            }
        }
    }

    /******************** Second BubbleSort Implementation ********************/
    
    /**
     * A more optimized version of bubble sort. The first pass places the largest element at 
     * the end of the array. In the second pass, compare and order pairs of elements sequentially.
     * There is no need to consider the last pair, because the last element in the array is already
     * the largest. In the 3rd pass, you compare and order pairs of elements sequentially except
     * the last 2 elements. 
     * 
     * Property: In the kth iteration, you don't need to consider the last k-1 elements, because 
     * they are already ordered. Using this we can improve upon BubbleSort
     * @param arr - Target array to sort
     */
    public void bubbleSort2(int[] arr){
        // Flag determines whether array is sorted and next iteration is not needed
        boolean reiteration = true; 
        
        for(int k = 1; k < arr.length && reiteration; k++){
            //Array may be sorted, so next iteration is not needed
            reiteration = false;
            for(int i = 0; i < arr.length -k; i++) {
                if(arr[i] > arr[i+1]){ // Swap arr[i] with arr[i+1]
                    swap(arr,i,i+1);
                    reiteration = true; // need next pass
                }
                
            }
        }
    }

    /******************** Third BubbleSort Implementation ********************/
    //This time with generic array and using the comparator
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
