/**
 * A collection of Binary Searches, with each method and method overloads as
 * an implementation. 
 */
public class BinarySearch {
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
}
