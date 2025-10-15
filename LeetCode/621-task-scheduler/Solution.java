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

    return 0;
  }
}
