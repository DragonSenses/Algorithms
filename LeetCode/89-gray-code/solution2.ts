
function grayCode(n: number): number[] {
  const totalLength = 1 << n; // 2^n
  const sequence: number[] = [0]; // Initialize with 0
  const visited = new Set<number>();
  visited.add(0);

  return sequence;
}
