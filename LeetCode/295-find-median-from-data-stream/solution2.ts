class MedianFinder {
  private list: number[];

  constructor() {
    this.list = [];
  }

  addNum(num: number): void {
    const index = this.binarySearchInsertIndex(num);
    this.list.splice(index, 0, num); // Insert at index, shifting elements
  }

  findMedian(): number {
    const size = this.list.length;
    if (size === 0) return 0;

    const mid = Math.floor(size / 2);

    return size % 2 === 1
      ? this.list[mid]
      : (this.list[mid - 1] + this.list[mid]) / 2;
  }

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