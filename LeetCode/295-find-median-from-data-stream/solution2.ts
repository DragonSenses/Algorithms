/**
 * A class for tracking the median of a stream of numbers using sorted insertion.
 *
 * This implementation maintains a sorted list of numbers by inserting each new
 * value at its correct position using binary search. Median retrieval is constant-time.
 */
class MedianFinder {
  private list: number[];

  /**
   * Constructs a new MedianFinder instance.
   * Initializes an empty list to store incoming numbers.
   */
  constructor() {
    this.list = [];
  }

  /**
   * Adds a number to the data stream while maintaining sorted order.
   *
   * This method uses binary search to find the correct index for insertion,
   * then inserts the number at that index, shifting elements as needed.
   *
   * @param num - The number to insert into the stream
   */
  addNum(num: number): void {
    const index = this.binarySearchInsertIndex(num);
    this.list.splice(index, 0, num);
  }

  /**
   * Returns the median of all elements added so far.
   *
   * If the list size is odd, returns the middle element.
   * If the list size is even, returns the average of the two middle elements.
   *
   * @returns The median value as a number
   */
  findMedian(): number {
    const size = this.list.length;
    if (size === 0) return 0;

    const mid = Math.floor(size / 2);

    return size % 2 === 1
      ? this.list[mid]
      : (this.list[mid - 1] + this.list[mid]) / 2;
  }

  /**
   * Finds the correct index to insert a number into the sorted list.
   *
   * Performs binary search to locate the first index where the target
   * should be inserted to maintain sorted order.
   *
   * @param target - The number to insert
   * @returns The index at which to insert the number
   */
  private binarySearchInsertIndex(target: number): number {
    let left = 0;
    let right = this.list.length;

    while (left < right) {
      const mid = Math.floor((left + right) / 2);
      if (this.list[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}