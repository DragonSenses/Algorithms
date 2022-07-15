/**
 * Best  - O(n^2)
 * Avg   - O(n^2)
 * Worst - O(n^2)
 * 
 * Applications:
 *  - Cyber Security when password sorting and matching should
 * always take a certain amount of time so as not to give 
 * away information during execution
 */
public class SelectionSort {
    
    public static void selectionSort(int[] data){
        for(int k = 0; k < data.length -1; k++){
            int i = k; // index
            for(int j = k + 1; j < data.length; j++){
                if (data[j] < data[i]) {
                    i = j; // Search for Lowest index
                }
            }
            // Swap
            int smaller = data[i];
            data[i] = data[k];
            data[k] = smaller;
        }
    }

    public static void main(String a[]){  
        int[] arr1 = {9,14,3,2,43,11,58,22};  
        System.out.println("Before Selection Sort");  
        for(int i:arr1){  
            System.out.print(i+" ");  
        }  
        System.out.println();  
          
        selectionSort(arr1);//sorting array using selection sort  
         
        System.out.println("After Selection Sort");  
        for(int i:arr1){  
            System.out.print(i+" ");  
        }  
    }  
}  
