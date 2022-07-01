import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kendr
 */
public class MergeSort {

    public static <K> void merge(K[] a1, K[] a2, K[]a, Comparator<K> C){
        int i = 0, j = 0;


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