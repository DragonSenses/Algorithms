/**
 * Calculates the number of distinct ways to climb a staircase with `n` steps,
 * where each step can be either 1 or 2 steps at a time, using the Fibonacci number approach.
 *
 * @param n - The total number of steps in the staircase.
 * @returns The number of distinct ways to reach the top of the staircase.
 */
function climbStairs(n: number): number {
  // Base case: If there's only one step, there's only one way to climb
  if (n === 1) {
    return 1;
  }

  let first = 1; // First Fibonacci number
  let second = 2; // Second Fibonacci number

  // Calculate the nth Fibonacci number
  for (let i = 3; i <= n; i++) {
    let third = first + second; // The current Fibonacci number
    first = second; // Update first
    second = third; // Update second
  }

  return second; // The nth Fibonacci number
}
