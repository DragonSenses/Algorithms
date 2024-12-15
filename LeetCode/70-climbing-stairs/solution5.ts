/**
 * Function to calculate the number of ways to climb stairs using the Fibonacci formula.
 *
 * @param n - The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  // Calculate the square root of 5
  const sqrt5 = Math.sqrt(5);

  // Calculate the golden ratio (φ)
  const phi = (1 + sqrt5) / 2;

  // Calculate the conjugate of the golden ratio (ψ)
  const psi = (1 - sqrt5) / 2;

  // Apply Binet's formula for the (n+1)th Fibonacci number:
  // F(n+1) = (φ^(n+1) - ψ^(n+1)) / √5
  // Cast the result to an integer and return
  return Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
}
