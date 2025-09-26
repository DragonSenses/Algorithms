import java.util.Collections;
import java.util.PriorityQueue;

/**
 * MedianFinder using two heaps to maintain median access.
 *
 * - Max-heap (lo) stores the smaller half of the numbers
 * - Min-heap (hi) stores the larger half of the numbers
 */
class MedianFinder {
  private PriorityQueue<Integer> lo; // Max-heap
  private PriorityQueue<Integer> hi; // Min-heap

  /** Initializes the MedianFinder object. */
  public MedianFinder() {
    lo = new PriorityQueue<>(Collections.reverseOrder());
    hi = new PriorityQueue<>();
  }

  /**
   * Adds a number to the data stream and rebalances the heaps.
   *
   * @param num the number to insert
   */
  public void addNum(int num) {
    lo.offer(num);
    hi.offer(lo.poll());

    if (hi.size() > lo.size()) {
      lo.offer(hi.poll());
    }
  }

  /**
   * Returns the median of all elements added so far.
   *
   * @return the median value as a double
   */
  public double findMedian() {
    if (lo.size() > hi.size()) {
      return lo.peek();
    } else {
      return (lo.peek() + hi.peek()) / 2.0;
    }
  }
}