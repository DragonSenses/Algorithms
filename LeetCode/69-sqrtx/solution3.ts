function mySqrt(x: number): number {
  if (x < 2) return x;

  let left = 2, right = Math.floor(x / 2);
  while (left <= right) {
    let pivot = Math.floor(left + (right - left) / 2);
    let num = pivot * pivot;
    if (num > x) {
      right = pivot - 1;
    } else if (num < x) {
      left = pivot + 1;
    } else {
      return pivot;
    }
  }
  return right;
}