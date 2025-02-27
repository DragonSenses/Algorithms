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
  - **Space Complexity**: `O(n)`
- [Recursion with Memoization](#recursion-with-memoization)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Dynamic Programming Approach](#dynamic-programming-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Fibonacci Number (Naive Approach)](#fibonacci-number-naive-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(1)`
- [Fibonacci Formula (Optimized Approach)](#fibonacci-formula-optimized-approach)
  - **Time Complexity**: `O(1)`
  - **Space Complexity**: `O(1)`
- [Binet's Method](#binets-method-approach)
  - **Time Complexity**: `O(log n)`
  - **Space Complexity**: `O(1)`

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

## **Complexity Analysis**

### **Time Complexity**: `O(n)`

- **Reason**: In the memoization approach, each unique subproblem is solved only once. Once computed, the result is stored in the memo array and reused whenever needed. Hence, we perform a constant amount of work for each step from `0` to `n`.
- **Linear Growth**: The number of steps, `n`, directly determines the number of calculations. Therefore, the time complexity is linear, `O(n)`.

### **Space Complexity**: `O(n)`

- **Memoization Storage**: We use a memo array of size `n+1` to store the results of subproblems. This requires additional space proportional to the number of steps, `n`.
- **Recursion Depth**: The recursion stack depth also grows up to `n` in the worst case, contributing to the space complexity.
- **Total Space Usage**: Combining the memo array and the recursion stack, the overall space complexity is `O(n)`.

# Dynamic Programming Approach

This dynamic programming approach efficiently calculates the number of ways to climb stairs, utilizing both optimal time and space complexity.

## **Intuition**

This problem can be broken into subproblems and contains the optimal substructure property, meaning its optimal solution can be constructed efficiently from the optimal solutions of its subproblems. Therefore, dynamic programming can be used to solve this problem.

One can reach the i-th step in one of two ways:
1. Taking a single step from the (i-1)-th step.
2. Taking a step of 2 from the (i-2)-th step.

Thus, the total number of ways to reach the i-th step is equal to the sum of ways of reaching the (i-1)-th step and the ways of reaching the (i-2)-th step.

Let `dp[i]` denote the number of ways to reach the i-th step:
\[ \text{dp[i]} = \text{dp[i-1]} + \text{dp[i-2]} \]

### Dynamic Programming Overview

Dynamic programming is a method for solving problems by breaking them down into simpler subproblems and solving each subproblem only once, storing their solutions - usually in an array or hash table. This approach reduces the computational overhead associated with solving the same subproblems multiple times.

## **Algorithm**

1. **Initialization**: 
   - Create an array `dp` of size `n+1` to store the number of ways to reach each step.
   - Initialize `dp[1]` to 1 and `dp[2]` to 2, as there is only one way to reach step 1 and two ways to reach step 2.

2. **Iteration**:
   - Use a loop from 3 to `n`.
   - For each step `i`, set `dp[i]` to the sum of `dp[i-1]` and `dp[i-2]`.

3. **Return Result**: 
   - The result is the value of `dp[n]`.

## **Implementation**

### Java

```java
public class Solution {
  /**
   * Function to calculate the number of ways to climb stairs using dynamic programming.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    // Base case: If there's only one step, there's only one way to climb
    if (n == 1) {
      return 1;
    }

    // Create a dp array to store results of each step
    int[] dp = new int[n + 1];
    dp[1] = 1; // One way to reach the first step
    dp[2] = 2; // Two ways to reach the second step

    // Fill the dp array using the dynamic programming approach
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to reach i-th step
    }

    return dp[n]; // Return the number of ways to reach the top
  }
}
```

### TypeScript

```typescript
/**
 * Calculates the number of distinct ways to climb a staircase with `n` steps,
 * where each step can be either 1 or 2 steps at a time.
 *
 * @param n - The total number of steps in the staircase.
 * @returns The number of distinct ways to reach the top of the staircase.
 */
function climbStairs(n: number): number {
  // Base case: If there's only one step, there's only one way to climb
  if (n === 1) {
    return 1;
  }

  // Create a dp array to store results of each step
  const dp: number[] = new Array(n + 1);
  dp[1] = 1; // One way to reach the first step
  dp[2] = 2; // Two ways to reach the second step

  // Fill the dp array using the dynamic programming approach
  for (let i = 3; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to reach the i-th step
  }

  return dp[n]; // Return the number of ways to reach the top
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(n)`

- **Single Loop**: The algorithm iterates from 3 to `n`, performing a constant amount of work in each iteration. The time complexity is linear, `O(n)`.

### **Space Complexity**: `O(n)`

- **Array Storage**: The algorithm uses an array `dp` of size `n+1` to store the number of ways to reach each step. The space complexity is linear, `O(n)`.

# Fibonacci Number (Naive Approach)

This approach efficiently calculates the number of ways to climb stairs by leveraging the properties of the Fibonacci sequence, resulting in both optimal time and space complexity.

## **Intuition**

The problem of climbing stairs is analogous to finding the Fibonacci sequence. In the dynamic programming approach, we observed that the number of ways to reach the i-th step could be derived from the sum of ways to reach the (i-1)-th and (i-2)-th steps. This is the essence of the Fibonacci sequence, where each term is the sum of the two preceding ones.

### Fibonacci Number Overview

For those unfamiliar with the Fibonacci sequence, it is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1. In this problem, however, we start with 1 and 2 because the first step can be taken in 1 way, and the second step can be reached directly in 2 ways (either two single steps or one double step).

## **Algorithm**

1. **Initialize** two variables to represent the first two Fibonacci numbers, `first = 1` and `second = 2`.
2. **Iterate** from 3 to `n` (inclusive) to compute the i-th Fibonacci number:
   - Calculate the i-th Fibonacci number as the sum of the previous two numbers.
   - Update the variables to hold the last two computed values.
3. **Return** the value of the n-th Fibonacci number.

## **Implementation**

### Java

```java
public class Solution {
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
```

### TypeScript

```typescript
function climbStairs(n: number): number {
  // Base case: If there's only one step, there's only one way to climb
  if (n === 1) {
    return 1;
  }

  let first: number = 1;  // First Fibonacci number
  let second: number = 2; // Second Fibonacci number

  // Calculate the nth Fibonacci number
  for (let i = 3; i <= n; i++) {
    const third: number = first + second; // The current Fibonacci number
    first = second; // Update first
    second = third; // Update second
  }

  return second; // The nth Fibonacci number
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(n)`

- **Single Loop**: The algorithm iterates from 3 to `n`, performing a constant amount of work in each iteration (calculating the sum of the previous two Fibonacci numbers). Since this linear iteration directly depends on the input size `n`, the time complexity is `O(n)`.

### **Space Complexity**: `O(1)`

- **Constant Space**: We use a constant amount of space to store the last two Fibonacci numbers. No additional space is required that grows with the input size `n`, making the space complexity constant, `O(1)`.

# Fibonacci Formula (Optimized Approach)

This optimized approach provides an efficient way to compute the number of ways to climb stairs, leveraging the mathematical properties of the Fibonacci sequence to achieve constant time and space complexity.

## **Intuition**

We can find a closed-form expression to calculate the n-th Fibonacci number using the Fibonacci formula. This closed-form expression is known as Binet's formula.

### Fibonacci Formula Overview

Binet's formula states that the n-th Fibonacci number can be computed using:
\[ F(n) = \frac{\phi^{(n+1)} - \psi^{(n+1)}}{\sqrt{5}} \]
where:
- \( \phi = \frac{1 + \sqrt{5}}{2} \) (the golden ratio)
- \( \psi = \frac{1 - \sqrt{5}}{2} \)

For the given problem, we consider the first and second steps as the base cases, i.e., \( F(1) = 1 \) and \( F(2) = 2 \). The Fibonacci sequence for this problem is defined such that \( F(n+2) = F(n+1) + F(n) \). By solving the recurrence relation using the quadratic formula, we arrive at the above closed-form expression.

## **Algorithm**

1. **Calculate Constants**: 
   - Compute \( \sqrt{5} \).
   - Compute \( \phi \) and \( \psi \).
2. **Apply Binet's Formula**: 
   - Use the formula \( F(n) = \frac{\phi^{(n+1)} - \psi^{(n+1)}}{\sqrt{5}} \) to compute the n-th Fibonacci number.
3. **Return Result**: 
   - Convert the result to an integer (since the number of ways to climb stairs must be a whole number).

## **Implementation**

### Java

```java
public class Solution {
  /**
   * Function to calculate the number of ways to climb stairs using the Fibonacci formula.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    double sqrt5 = Math.sqrt(5);
    double phi = (1 + sqrt5) / 2;
    double psi = (1 - sqrt5) / 2;
    return (int) ((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
  }
}
```

### TypeScript

```typescript
/**
 * Function to calculate the number of ways to climb stairs using the Fibonacci formula.
 *
 * @param n - The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  const sqrt5 = Math.sqrt(5);
  const phi = (1 + sqrt5) / 2;
  const psi = (1 - sqrt5) / 2;
  return Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(1)`

- **Constant Time**: Calculating the n-th Fibonacci number using Binet's formula involves a constant number of arithmetic operations, regardless of the value of `n`. Thus, the time complexity is `O(1)`.

### **Space Complexity**: `O(1)`

- **Fixed Space**: The algorithm uses a fixed amount of extra space to store the constants \( \sqrt{5} \), \( \phi \), and \( \psi \). No additional space is required that grows with the input size `n`, making the space complexity constant, `O(1)`.

# Binet's Method Approach

Binet's method efficiently computes the number of ways to climb stairs using matrix exponentiation, achieving logarithmic time complexity and constant space complexity.

## **Intuition**

This approach uses matrix exponentiation to compute the n-th Fibonacci number efficiently. By leveraging the properties of matrix multiplication, we can calculate the n-th Fibonacci number in logarithmic time.

### Matrix Representation of Fibonacci Numbers

The Fibonacci sequence can be represented using matrix multiplication:
\[ Q = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix} \]

By raising this matrix to the power of (n-1), the top left element of the resulting matrix will give us the n-th Fibonacci number.

## **Algorithm**

1. **Matrix Initialization**:
   - Initialize the transformation matrix \( Q = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix} \).
2. **Matrix Exponentiation**:
   - Raise the matrix Q to the power of (n-1) using efficient exponentiation by squaring.
3. **Extract Result**:
   - The resulting matrix's top left element will be the n-th Fibonacci number.

## **Implementation**

### Java

```java
public class Solution6 {
  /**
   * Function to calculate the number of ways to climb stairs using matrix exponentiation.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    int[][] q = {{1, 1}, {1, 0}};
    int[][] res = matrixPower(q, n);
    return res[0][0];
  }

  /**
   * Function to raise a 2x2 matrix to the power n using exponentiation by squaring.
   *
   * @param a The matrix to be raised to the power.
   * @param n The exponent.
   * @return The resultant matrix after exponentiation.
   */
  private int[][] matrixPower(int[][] a, int n) {
    int[][] result = {{1, 0}, {0, 1}}; // Identity matrix
    while (n > 0) {
      if ((n & 1) == 1) {
        result = multiplyMatrices(result, a);
      }
      n >>= 1;
      a = multiplyMatrices(a, a);
    }
    return result;
  }

  /**
   * Function to multiply two 2x2 matrices.
   *
   * @param a The first matrix.
   * @param b The second matrix.
   * @return The resultant matrix after multiplication.
   */
  private int[][] multiplyMatrices(int[][] a, int[][] b) {
    int[][] c = new int[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
      }
    }
    return c;
  }
}
```

### TypeScript

```typescript
/**
 * Function to calculate the number of ways to climb stairs using matrix exponentiation.
 *
 * @param n - The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  const q = [[1, 1], [1, 0]];
  const res = matrixPower(q, n);
  return res[0][0];
}

/**
 * Function to raise a 2x2 matrix to the power n using exponentiation by squaring.
 *
 * @param a - The matrix to be raised to the power.
 * @param n - The exponent.
 * @returns The resultant matrix after exponentiation.
 */
function matrixPower(a: number[][], n: number): number[][] {
  let result = [[1, 0], [0, 1]]; // Identity matrix
  while (n > 0) {
    if (n & 1) {
      result = multiplyMatrices(result, a);
    }
    n >>= 1;
    a = multiplyMatrices(a, a);
  }
  return result;
}

/**
 * Function to multiply two 2x2 matrices.
 *
 * @param a - The first matrix.
 * @param b - The second matrix.
 * @returns The resultant matrix after multiplication.
 */
function multiplyMatrices(a: number[][], b: number[][]): number[][] {
  const c = [[0, 0], [0, 0]];
  for (let i = 0; i < 2; i++) {
    for (let j = 0; j < 2; j++) {
      c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
    }
  }
  return c;
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(log n)`

- **Exponentiation by Squaring**: The matrix exponentiation is performed using the method of exponentiation by squaring, which requires `log n` multiplications. Each matrix multiplication operation takes constant time `O(1)` for a fixed-size 2x2 matrix.

### **Space Complexity**: `O(1)`

- **Fixed Space**: The algorithm uses a constant amount of extra space to store the matrices and intermediate results. The space complexity is therefore `O(1)`.

### Proof of Time Complexity

Let's consider raising a matrix \( M \) to the power of `n`. If `n` is a power of 2, we can represent it as \( n = 2^k \). The matrix exponentiation process involves squaring the matrix \( k \) times:
\[ M^n = M^{2^k} = ((...((M^2)^2)^2...)^2) \]

![Matrix `M` in the form a tree](img/70-2.jpg)

Thus, the number of multiplication operations required is proportional to the height of the exponentiation tree, which is `log n`. Since each matrix multiplication operation is performed in constant time for a 2x2 matrix, the overall time complexity is `O(log n)`.
