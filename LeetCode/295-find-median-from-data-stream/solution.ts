class MedianFinder {
  private list: number[];

  constructor() {
    this.list = [];
  }

  addNum(num: number): void {
    this.list.push(num);
  }

  findMedian(): number {
    if (this.list.length === 0) return 0;

    this.list.sort((a, b) => a - b);

    const size = this.list.length;
    const mid = Math.floor(size / 2);

    return size % 2 === 1
      ? this.list[mid]
      : (this.list[mid - 1] + this.list[mid]) / 2;
  }
}
