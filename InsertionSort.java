import java.util.Comparator;

/**
 * 
 * Best-  O(n)
 * Avg -  O(n^2)
 * Worst- O(n^2)
 */
public class InsertionSort <E> {
    
    /**
     * Insertion sort on an array of integers 
     * @param data
     */
    public static void insertionSort(int[] data){
        int len = data.length;
        // 1. Mark First Element as sorted
        for(int k = 1; k < len; k++){       // Start with Second element
            int c = data[k];                // 2. Extract the element c
            int i = k;                      // Save the correct index for c
            while (i > 0 && data[i-1] > c){ // 3. If the data[i-1] is greater
                data[i] = data[i-1];        // 4. Move data[i-1] to the right
                i--;                        // 5. Repeat until data[i-1] is lesser
            }
            data[i] = c;                    // 6. Insert element here after loop
        }
    }

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

    /**
     * Insertion sort on an array of generic type 
     * @param data
     */
    public void insertionSort(E[] data){
        int len = data.length;
        // 1. Mark First Element as sorted
        for(int k = 1; k < len; k++){       // Start with Second Character
            E e = data[k];                  // 2. Extract the element c
            int i = k;                      // Save the correct index for c
            while (i > 0 && comp.compare(e,data[i-1]) <= 0){ // 3. If the data[i-1] is greater
                data[i] = data[i-1];        // 4. Move data[i-1] to the right
                i--;                        // 5. Repeat until data[i-1] is lesser
            }
            data[i] = e;                    // 6. Insert element here after loop
        }
    }
    // data[i-1] > e
    // e < data[i-1]
    // x < y
    // -1 or 0 (if duplicates allowed
    // 
}
