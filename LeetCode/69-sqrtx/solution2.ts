function mySqrt(x: number): number {
  if (x < 2) return x;

  const left = mySqrt(x >> 2) << 1;
  const right = left + 1;
  return right * right > x ? left : right;
}
