/**
 * Solution class provides a method to calculate the number of distinct ways to climb a staircase
 * with `n` steps, where each step can be either 1 or 2 steps at a time, using the Fibonacci number
 * approach.
 */
public class Solution4 {
  
  /**
   * Function to calculate the number of ways to climb stairs using the Fibonacci number approach.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    // Base case: If there's only one step, there's only one way to climb
    if (n == 1) {
      return 1;
    }

    int first = 1; // First Fibonacci number
    int second = 2; // Second Fibonacci number

    // Calculate the nth Fibonacci number
    for (int i = 3; i <= n; i++) {
      int third = first + second; // The current Fibonacci number
      first = second; // Update first
      second = third; // Update second
    }

    return second; // The nth Fibonacci number
  }
}
