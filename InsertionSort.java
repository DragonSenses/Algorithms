/**
 * 
 * Best-  O(n)
 * Avg -  O(n^2)
 * Worst- O(n^2)
 */
public class InsertionSort {
    
    /**
     * Insertion sort on an array of characters 
     * @param data
     */
    public static void insertionSort(char[] data){
        int len = data.length;
        // 1. Mark First Element as sorted
        for(int k = 1; k < len; k++){       // Start with Second Character
            char c = data[k];               // 2. Extract the element c
            int i = k;                      // Save the correct index for c
            while (i > 0 && data[i-1] > c){ // 3. If the data[i-1] is greater
                data[i] = data[i-1];        // 4. Move data[i-1] to the right
                i--;                        // 5. Repeat until data[i-1] is lesser
            }
            data[i] = c;                    // 6. Insert element here after loop
        }
    }
}
