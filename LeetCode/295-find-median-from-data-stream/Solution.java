import java.util.ArrayList;

/**
 * Naive implementation of a data stream median finder.
 * 
 * This approach stores all incoming numbers in a resizable list. On each call to findMedian(), the
 * list is sorted and the median is computed.
 * 
 * Time Complexity: - addNum: O(1) - findMedian: O(n log n) due to sorting
 * 
 * Space Complexity: - O(n) for storing all elements
 */
class MedianFinder {
  // Stores all incoming numbers from the data stream
  private ArrayList<Integer> list;

  /**
   * Initializes the MedianFinder object. Uses an ArrayList to store the stream of numbers.
   */
  public MedianFinder() {
    this.list = new ArrayList<>();
  }

  /**
   * Adds an integer to the data stream.
   * 
   * @param num the number to be added
   */
  public void addNum(int num) {
    this.list.add(num);
  }

  /**
   * Returns the median of all elements added so far.
   * 
   * This is a naive implementation: - Sorts the entire list on each call - Computes the median
   * based on sorted order
   * 
   * @return the median value as a double
   */
  public double findMedian() {
    if (list.isEmpty()) {
      return 0;
    }

    // Sort the list before computing the median
    this.list.sort((a, b) -> Integer.compare(a, b));

    int size = list.size();

    // If odd number of elements, return the middle one
    // If even, return the average of the two middle elements
    return (size & 1) == 1 ? list.get(size / 2)
        : ((list.get(size / 2 - 1) + list.get(size / 2)) / 2.0);
  }
}
