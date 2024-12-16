public class Solution5 {
  /**
   * Function to calculate the number of ways to climb stairs using the Fibonacci formula.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    // Calculate the square root of 5
    double sqrt5 = Math.sqrt(5);

    // Calculate the golden ratio (φ)
    double phi = (1 + sqrt5) / 2;

    // Calculate the conjugate of the golden ratio (ψ)
    double psi = (1 - sqrt5) / 2;

    // Apply Binet's formula for the (n+1)th Fibonacci number:
    // F(n+1) = (φ^(n+1) - ψ^(n+1)) / √5
    // Cast the result to an integer and return
    return (int) ((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
  }
}
