class MedianFinder {
  private list: number[];

  constructor() {
    this.list = [];
  }

  addNum(num: number): void {
    const index = this.binarySearchInsertIndex(num);
    this.list.splice(index, 0, num); // Insert at index, shifting elements
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