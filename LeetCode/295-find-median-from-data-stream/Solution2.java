import java.util.ArrayList;
import java.util.List;

class MedianFinder {
  private List<Integer> list;

  /** Initializes the MedianFinder object. */
  public MedianFinder() {
    this.list = new ArrayList<>();
  }

  public void addNum(int num) {
    int index = binarySearchInsertIndex(num);
    list.add(index, num); // insert at index, shifting elements as needed
  }

  public double findMedian() {
    int size = list.size();
    
    if (size == 0) {
      return 0;
    }

    if ((size & 1) == 1) {
      return list.get(size / 2);
    } else {
      return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
    }
  }

  private int binarySearchInsertIndex(int target) {
    int left = 0, right = list.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (list.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}