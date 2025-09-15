import java.util.ArrayList;

class MedianFinder {
  ArrayList<Integer> list;

  // Initializes MedianFinder object
  public MedianFinder() {
    this.list = new ArrayList<>();
  }

  // Adds integer num from the data stream to data structure
  public void addNum(int num) {
    this.list.add(num);
  }

  // Returns median of all elements so far
  public double findMedian() {
    if (list.isEmpty()) { return 0; }

    this.list.sort((a, b) -> Integer.compare(a, b));

    int size = list.size();

    return (size & 1) == 1 
      ? list.get(size / 2)
      : ((list.get(size / 2 - 1) + list.get(size / 2)) / 2.0);
  }
}
