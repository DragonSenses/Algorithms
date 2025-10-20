function leastInterval(tasks: string[], n: number): number {
  // Step 1: Count frequency of each task
  const freq: number[] = new Array(26).fill(0);
  for (const task of tasks) {
    freq[task.charCodeAt(0) - 'A'.charCodeAt(0)]++;
  }

}