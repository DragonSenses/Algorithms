import { Heap } from 'heap-js';

class MedianFinder {
  private lo: Heap<number>; // Max-heap
  private hi: Heap<number>; // Min-heap

  constructor() {
    // Max-heap: largest value at top
    this.lo = new Heap<number>((a, b) => b - a);

    // Min-heap: smallest value at top
    this.hi = new Heap<number>((a, b) => a - b);
  }

  addNum(num: number): void {
    this.lo.push(num);
    this.hi.push(this.lo.pop()!);

    if (this.hi.size() > this.lo.size()) {
      this.lo.push(this.hi.pop()!);
    }
  }

}