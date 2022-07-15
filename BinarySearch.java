import java.util.Comparator;

/**
 * A collection of Binary Searches, with each method and method overloads as
 * an implementation. 
 */
public class BinarySearch <T> {
    /******************** First Binary Search Implementation ********************/

    /**
     * A binary search, assumes that data is sorted.
     * @return True if the target value is found in the indicated position of the
     * data array. Searches through array portion of [lo,hi] inclusive in data.
     */
    public static boolean binarySearch(int[] data, int target, int lo, int hi){
        if(lo > hi) { return false; }   // Interval Empty; No Match
        else {
            int mid = lo + hi >>> 1; // mid = (lo+hi)/2 , always positive result
            if (target == data[mid]){       
                return true;                                    // Found Match
            } else if (target < data[mid]){ 
                return binarySearch(data, target, lo, mid-1);   // Search left of middle
            } else {
                return binarySearch(data, target, mid+1, hi);   // Search right of middle
            }
        }
    }

    /**
     * A binary search with a cleaner signature
     * @param data   The array to search in
     * @param target The target to search for
     * @return  true if target value is found in the data array
     */
    public static boolean binarySearch(int[] data, int target){
        return binarySearch(data, target, 0, data.length -1);
    }

    /******************** Second Binary Search Implementation ********************/
    // This is the same as the First implementation but uses generic data type
    Comparator<T> comp = (T t1, T t2) -> compare(t1,t2);

    /**
     * Compares Two Keys by natural ordering
     * @param x First key to compare
     * @param y Second key to compare
     * @return -1 if x < y, 
     *          0 if x==y, 
     *          1 if x > y
     */
    protected int compare(T x, T y){
        return comp.compare(x,y);
    }

    /**
     * A binary search, assumes that data is sorted.
     * @return True if the target value is found in the indicated position of the
     * data array. Searches through array portion of [lo,hi] inclusive in data.
     */
    public boolean binarySearch(T[] data, T target, int lo, int hi){
        if(lo > hi) { return false; }   // Interval Empty; No Match
        else {
            int mid = lo + hi >>> 1; // mid = (lo+hi)/2 , always positive result
            if (comp.compare(target,data[mid]) == 0){       
                return true;                                    // Found Match
            } else if (comp.compare(target,data[mid]) < 0){ 
                return binarySearch(data, target, lo, mid-1);   // Search left of middle
            } else {
                return binarySearch(data, target, mid+1, hi);   // Search right of middle
            }
        }
    }

    /**
     * A binary search with a cleaner signature
     * @param data   The array to search in
     * @param target The target to search for
     * @return  true if target value is found in the data array
     */
    public boolean binarySearch(T[] data, T target){
        return binarySearch(data, target, 0, data.length -1);
    }
}
