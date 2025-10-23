/**
 * Calculates the minimum number of CPU intervals required to execute all tasks
 * with a cooling interval constraint between identical tasks.
 *
 * Each task is represented by an uppercase letter ('A' to 'Z'). The CPU can execute
 * one task per interval and must wait at least `n` intervals before executing the same task again.
 *
 * This function uses a greedy strategy: it schedules the most frequent tasks first,
 * then fills idle slots with less frequent tasks to minimize total time.
 *
 * @param tasks - An array of uppercase letters representing tasks to be scheduled.
 * @param n - The cooling interval between identical tasks.
 * @returns The minimum number of intervals needed to complete all tasks.
 */
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

  // Step 5: Fill idle slots with other tasks
  for (let i = 1; i < 26 && idle_time > 0; i++) {
    idle_time -= Math.min(f_max - 1, freq[i]);
  }

  // Step 6: Clamp idle time to zero
  idle_time = Math.max(0, idle_time);

  // Step 7: Return total intervals
  return tasks.length + idle_time;
}