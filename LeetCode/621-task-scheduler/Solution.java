import java.util.Arrays;

class Solution {
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

  }
}
