
function grayCode(n: number): number[] {
  const totalLength = 1 << n; // 2^n
  const sequence: number[] = [0]; // Initialize with 0
  const visited = new Set<number>();
  visited.add(0);

  function backtrack(): boolean {


    const current = sequence[sequence.length - 1];
    for (let i = 0; i < n; i++) {
      const next = current ^ (1 << i); // Flip ith bit

    }
  }

  backtrack();
  return sequence;
}
