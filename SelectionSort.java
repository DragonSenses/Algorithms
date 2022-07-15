import java.util.Comparator;

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
public class SelectionSort <E> {
    
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

    public static void selectionSort(char[] data){
        for(int k = 0; k < data.length -1; k++){
            int i = k; // index
            for(int j = k + 1; j < data.length; j++){
                if (data[j] < data[i]) {
                    i = j; // Search for Lowest index
                }
            }
            // Swap
            char smaller = data[i];
            data[i] = data[k];
            data[k] = smaller;
        }
    }

    Comparator<E> comp = (E x, E y) -> compare(x,y);

    /**
     * Compares Two Keys by natural ordering
     * @param x First key to compare
     * @param y Second key to compare
     * @return -1 if x < y, 
     *          0 if x==y, 
     *          1 if x > y
     */
    protected int compare(E x, E y){
        return comp.compare(x,y);
    }

    public void selectionSort(E[] data){
        for(int k = 0; k < data.length -1; k++){
            int i = k; // index
            for(int j = k + 1; j < data.length; j++){
                if (comp.compare(data[j],data[i]) < 0) {
                    i = j; // Search for Lowest index
                }
            }
            // Swap
            E smaller = data[i];
            data[i] = data[k];
            data[k] = smaller;
        }
    }

    public static void main(String args[]){  
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
        System.out.println();

        char[] a = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
        System.out.println(java.util.Arrays.toString(a));
        selectionSort(a);
        System.out.println(java.util.Arrays.toString(a));
    }  
}  
