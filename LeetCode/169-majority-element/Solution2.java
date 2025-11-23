import java.util.HashMap;

public class Solution2 {
  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    int threshold = nums.length / 2;

    for (int num : nums) {
      int count = frequencyMap.getOrDefault(num, 0) + 1;
      frequencyMap.put(num, count);

      if (count > threshold) {
        return num;
      }
    }

    return -1; // Should never reach here due to problem constraints
  }
}