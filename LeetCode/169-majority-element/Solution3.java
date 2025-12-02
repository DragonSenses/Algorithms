class Solution3 {
  public int majorityElement(int[] nums) {
    int majority = 0;
    int n = nums.length;

    // Iterate over all 32 bit positions
    for (int i = 0; i < 32; i++) {
      int bitCount = 0;

      // Count how many numbers have the i-th bit set
      for (int num : nums) {
        if (((num >> i) & 1) == 1) {
          bitCount++;
        }
      }

      // If more than half the numbers have this bit set, set it in the result
      if (bitCount > n / 2) {
        majority |= (1 << i);
      }
    }

  }
}
