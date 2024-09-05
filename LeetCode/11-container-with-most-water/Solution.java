public class Solution {
  public int maxArea(int[] height) {
    // Initialize two pointers, one at the beginning and one at the end of the array
    int left = 0;
    int right = height.length - 1;
    // Variable to store the maximum area found
    int maxArea = 0;

    // Loop until the two pointers meet
    while (left < right) {
      // Calculate the width between the two pointers
      int width = right - left;
      // Calculate the height of the container, which is the minimum of the two heights
      int h = Math.min(height[left], height[right]);
      // Calculate the area and update maxArea if the current area is larger
      int area = width * h;
      maxArea = Math.max(maxArea, area);

      // Move the pointer pointing to the shorter line inward
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    // Return the maximum area found
    return maxArea;
  }
}
