import java.util.Arrays;

class Solution {

  /**
   * Calculates the minimum number of CPU intervals required to execute all tasks
   * with a cooling interval constraint between identical tasks.
   *
   * Each task is represented by a capital letter A–Z. The CPU can execute one task per interval,
   * and must wait at least 'n' intervals before executing the same task again.
   *
   * The strategy is greedy: schedule the most frequent tasks first and fill idle slots with others
   * to minimize total time.
   *
   * @param tasks an array of characters representing tasks to be scheduled
   * @param n the cooling interval between identical tasks
   * @return the minimum number of intervals needed to complete all tasks
   */
  public int leastInterval(char[] tasks, int n) {
    // Step 1: Count frequency of each task
    int[] freq = new int[26];
    for (char task : tasks) {
      freq[task - 'A']++;
    }

    // Step 2: Sort frequencies in descending order
    Arrays.sort(freq);

    // Step 3: Get the max frequency
    int f_max = freq[25];

    // Step 4: Calculate initial idle time
    int idle_time = (f_max - 1) * n;

    // Step 5: Fill idle slots with other tasks
    for (int i = 24; i >= 0 && idle_time > 0; i--) {
      idle_time -= Math.min(f_max - 1, freq[i]);
    }

    // Step 6: Clamp idle time to zero
    idle_time = Math.max(0, idle_time);

    // Step 7: Return total intervals
    return tasks.length + idle_time;
  }
}