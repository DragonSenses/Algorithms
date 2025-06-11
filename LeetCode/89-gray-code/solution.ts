function grayCodeIterative(n: number): number[] {
  const result: number[] = [0]; // Initialize with 0

  for (let i = 0; i < n; i++) {
    const mask = 1 << i; // Define mask for bit shifting

    // Reverse iterate and apply bitwise OR to create mirrored sequence
    for (let j = result.length - 1; j >= 0; j--) {
      result.push(result[j] | mask);
    }
  }

  return result;
}