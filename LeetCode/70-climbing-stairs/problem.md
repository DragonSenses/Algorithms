# 70. Climbing Stairs

<p>You are climbing a staircase. It takes <code>n</code> steps to reach the top.</p>

<p>Each time you can either climb <code>1</code> or <code>2</code> steps. In how many distinct ways can you climb to the top?</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 45</code></li>
</ul>

<br>

---

# Solution

- [Brute Force (Naive Approach)](#brute-force-naive-approach)
  - **Time Complexity**: `O(2^n)`
- [Recursion with Memoization](#recursion-with-memoization)

# Brute Force (Naive Approach)

**Note:** This method is impractical due to its exponential time complexity of `O(2^n)`, which will result in a *Time Limit Exceeded* error. While the brute force (naive) approach is useful for grasping the fundamentals of the climbing stairs problem, we will soon explore more efficient solutions, such as the [Recursion with Memoization](#recursion-with-memoization) approach, to improve performance.

## **Intuition**

In this brute force approach, we take all possible step combinations, i.e., 1 and 2, at every step. At each step, we call the function `climbStairs` for step 1 and step 2, and return the sum of returned values of both functions.

The recurrence relation is:

`climbStairs(i, n) = climbStairs(i + 1, n) + climbStairs(i + 2, n)`

where `i` defines the current step and `n` defines the destination step.

### Visualization of Recursion Tree

The recursion tree for `n = 5`:

![](img/70-1.jpg)

## **Algorithm**

1. Define the base cases:
   - If the current step `i` equals `n`, return 1 (one way to reach the top).
   - If `i` exceeds `n`, return 0 (no way to reach the top from this position).
2. Recursively call `climbStairs` with `i+1` and `i+2`.
3. Sum the results of the two recursive calls to get the total number of ways to reach the top from step `i`.
4. Use the base cases to terminate the recursion.

## **Implementation**

### Java

```java
class Solution {
  /**
   * Brute force approach to calculate the number of distinct ways to climb to the top. Each time
   * you can either climb 1 or 2 steps.
   *
   * @param n The total number of steps to reach the top.
   * @returns The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    // Base case: If the steps are 0 or 1, there's only one way to climb
    if (n == 0 || n == 1) {
      return 1;
    }
    // Recursive calls to find the number of ways to reach the n-th step
    return climbStairs(n - 1) + climbStairs(n - 2);
  }
}
```

### TypeScript

```typescript
/**
 * Brute force approach to calculate the number of distinct ways to climb to the top.
 * Each time you can either climb 1 or 2 steps.
 *
 * @param n The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  // Base case: If the steps are 0 or 1, there's only one way to climb
  if (n === 0 || n === 1) {
      return 1;
  }
  // Recursive calls to find the number of ways to reach the n-th step
  return climbStairs(n - 1) + climbStairs(n - 2);
};
```

## **Complexity Analysis**

The recursion tree created for `n = 5`:

![](img/70-1.jpg)

### **Time Complexity**: `O(2^n)`

- **Exponential Growth**: For each step `i`, two recursive calls are made (`climbStairs(i + 1, n)` and `climbStairs(i + 2, n)`), forming a binary tree.
- **Height of Tree**: The height of this binary tree is `n`.
- **Total Nodes**: The total number of nodes in the recursion tree is `2^n`.
- **Result**: Therefore, the time complexity is `O(2^n)`.

### **Space Complexity**: `O(n)`

- **Recursion Depth**: The maximum depth of the recursion tree is `n`.
- **Call Stack**: The recursion stack will hold at most `n` function calls simultaneously.
- **Result**: This results in a space complexity of `O(n)`.

# Recursion with Memoization

## **Intuition**

In the previous approach, we were redundantly calculating the result for every step, which resulted in an exponential time complexity. Instead, we can use a technique called **memoization** to store the result at each step in a memo array. By directly returning the result from the memo array whenever that function is called again, we avoid redundant calculations.

### Memoization Overview

Memoization is an optimization technique that involves storing the results of expensive function calls and reusing those results when the same inputs occur again. By doing this, we significantly reduce the time complexity of the algorithm by avoiding redundant computations. 

## **Algorithm**

1. **Initialize**: Create a memo array to store the results of each step.
2. **Base Cases**: 
   - If `n` is 0 or 1, return 1.
3. **Recursive Case**: 
   - If the result for the current step is already computed (present in the memo array), return that result.
   - Otherwise, compute the result by recursively calling the function for `n-1` and `n-2` and store this result in the memo array.
4. **Return the Result**: Finally, return the result for the given `n`.

## **Implementation**

### Java

```java
public class Solution {
  // Function to calculate number of ways to climb stairs using memoization
  public int climbStairs(int n) {
    // Create a memo array to store results of each step
    int[] memo = new int[n + 1];
    return climbStairsWithMemoization(n, memo);
  }

  // Recursive auxiliary function to calculate number of ways using memoization
  private int climbStairsWithMemoization(int n, int[] memo) {
    // Base cases: if n is 0 or 1, there is only one way to climb
    if (n == 0 || n == 1) {
      return 1;
    }

    // If result is already computed, return it
    if (memo[n] != 0) {
      return memo[n];
    }

    // Compute the result for the current step
    memo[n] = climbStairsWithMemoization(n - 1, memo) + climbStairsWithMemoization(n - 2, memo);
    return memo[n];
  }
}
```

This implementation leverages memoization to efficiently compute the number of distinct ways to climb the stairs, drastically reducing the time complexity compared to the brute force approach. 

### TypeScript

```typescript
function climbStairs(n: number): number {
  // Create a memo array to store results of each step
  const memo: number[] = new Array(n + 1).fill(0);
  return climbStairsWithMemoization(n, memo);
}

function climbStairsWithMemoization(n: number, memo: number[]): number {
  // Base cases: If the steps are 0 or 1, there's only one way to climb
  if (n === 0 || n === 1) {
    return 1;
  }

  // If result is already computed, return it
  if (memo[n] !== 0) {
    return memo[n];
  }

  // Compute the result for the current step
  memo[n] =
    climbStairsWithMemoization(n - 1, memo) +
    climbStairsWithMemoization(n - 2, memo);
  return memo[n];
}
```
