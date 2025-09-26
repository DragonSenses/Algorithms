import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
  private PriorityQueue<Integer> lo; // Max-heap
  private PriorityQueue<Integer> hi; // Min-heap

  public MedianFinder() {
    lo = new PriorityQueue<>(Collections.reverseOrder());
    hi = new PriorityQueue<>();
  }

  public void addNum(int num) {
    lo.offer(num);
    hi.offer(lo.poll());

    if (hi.size() > lo.size()) {
      lo.offer(hi.poll());
    }
  }


  public double findMedian() {
    if (lo.size() > hi.size()) {
      return lo.peek();
    } else {
      return (lo.peek() + hi.peek()) / 2.0;
    }
  }
}