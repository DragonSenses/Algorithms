function leastInterval(tasks: string[], n: number): number {
  // Step 1: Count frequency of each task
  const freq: number[] = new Array(26).fill(0);
  for (const task of tasks) {
    freq[task.charCodeAt(0) - 'A'.charCodeAt(0)]++;
  }

  // Step 2: Sort frequencies in descending order
  freq.sort((a, b) => b - a);

  // Step 3: Get the max frequency
  const f_max = freq[0];

  // Step 4: Calculate initial idle time
  let idle_time = (f_max - 1) * n;

}