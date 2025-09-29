import { Heap } from 'heap-js';

/**
 * MedianFinder using two heaps to maintain median access.
 *
 * - Max-heap (lo) stores the smaller half of the numbers
 * - Min-heap (hi) stores the larger half of the numbers
 *
 * Time Complexity:
 * - addNum: O(log n)
 * - findMedian: O(1)
 *
 * Space Complexity:
 * - O(n)
 */
class MedianFinder {
  private lo: Heap<number>; // Max-heap
  private hi: Heap<number>; // Min-heap

  constructor() {
    // Max-heap: largest value at top
    this.lo = new Heap<number>((a, b) => b - a);

    // Min-heap: smallest value at top
    this.hi = new Heap<number>((a, b) => a - b);
  }

  /**
   * Adds a number to the data stream and rebalances the heaps.
   * @param num - The number to insert
   */
  addNum(num: number): void {
    this.lo.push(num);
    this.hi.push(this.lo.pop()!);

    if (this.hi.size() > this.lo.size()) {
      this.lo.push(this.hi.pop()!);
    }
  }

  /**
   * Returns the median of all elements added so far.
   * @returns The median value as a number
   */
  findMedian(): number {
    if (this.lo.size() > this.hi.size()) {
      return this.lo.peek()!;
    } else {
      return (this.lo.peek()! + this.hi.peek()!) / 2;
    }
  }
}