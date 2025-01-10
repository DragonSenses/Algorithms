# 55. Jump Game

<p>You are given an integer array <code>nums</code>. You are initially positioned at the array's <strong>first index</strong>, and each element in the array represents your maximum jump length at that position.</p>

<p>Return <code>true</code><em> if you can reach the last index, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> true
<strong>Explanation:</strong> Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,1,0,4]
<strong>Output:</strong> false
<strong>Explanation:</strong> You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
  <li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

# Solution

- [Backtracking Approach](#backtracking-approach)
  - **Time Complexity**: `O(2^n)`
  - **Space Complexity**: `O(n)`
- [Dynamic Programming **Top-Down** Approach](#dynamic-programming-top-down-approach)
  - **Time Complexity**: `O(n^2)`
  - **Space Complexity**: `O(n)`
- [Dynamic Programming **Bottom-Up** Approach](#dynamic-programming-bottom-up-approach)
  - **Time Complexity**: `O(n^2)`
  - **Space Complexity**: `O(n)`


## Problem Overview

This problem involves determining if you can reach the last index of an integer array `nums`. Each element in the array represents your maximum jump length at that position. Starting at the first index, you need to decide if it's possible to jump to the last index.

### Example 1:
**Input**: `nums = [2, 3, 1, 1, 4]`  
**Output**: `true`  
**Explanation**: Jump 1 step from index 0 to 1, then 3 steps to the last index.

### Example 2:
**Input**: `nums = [3, 2, 1, 0, 4]`  
**Output**: `false`  
**Explanation**: You will always arrive at index 3, which has a maximum jump length of 0, making it impossible to reach the last index.

### 4-Step Process of a Dynamic Programming Problem

To solve and fully understand a dynamic programming problem, follow these four steps:

1. **Start with the recursive backtracking solution**: Identify the simplest recursive solution, exploring all possible jump combinations.
2. **Optimize using a memoization table (top-down dynamic programming)**: Store intermediate results to avoid redundant calculations and improve efficiency.
3. **Remove the need for recursion (bottom-up dynamic programming)**: Transform the recursive solution into an iterative one, building the solution from the ground up.
4. **Apply final tricks to reduce time/memory complexity**: Refine the solution further by optimizing time and space complexity.

The solutions presented below vary in runtime and memory requirements, but all produce the correct result.

### Interview Tips

When approaching such a question in an interview scenario, it's important to consider your strategy carefully. The perfect solution is often the most concise and efficient, but it may not be immediately obvious.

**Start with the Recursive Backtracking Solution**: This is typically the easiest to conceptualize and explain. Mentioning this solution verbally can serve as a good warm-up before tackling more complex approaches. 

**Discuss Dynamic Programming Solutions**: If the interviewer doesn't specifically ask for the recursive solution, suggest that a dynamic programming approach might be more efficient. Explain how you could use a memoization table to optimize the solution. If you manage to work out this approach and the interviewer is interested in the top-down method, proceed with that. 

**Highlight the Bottom-Up Approach**: While you may not have time to fully develop the bottom-up version during the interview, it's beneficial to mention its advantages. This demonstrates your understanding of different optimization techniques.

**Practice Makes Perfect**: Converting from top-down dynamic programming (naturally expressed in recursion) to a bottom-up approach can be challenging. Regular practice with similar problems will help you become more adept at this transition.

By following this structured approach, you can effectively demonstrate your problem-solving skills and knowledge of dynamic programming techniques during an interview.

# Backtracking Approach

## **Intuition**

Backtracking is a problem-solving technique where you try every possible path to find a solution. In this context, we attempt every jump pattern from the first position to the last. The idea is to explore each reachable index from the current position recursively until we either reach the last index or exhaust all possibilities.

This approach involves:
1. **Exploring All Options**: From each position, jump to every possible next position.
2. **Recursive Exploration**: For each new position, repeat the process until the last index is reached.
3. **Backtracking**: If a jump sequence doesn't lead to a solution, backtrack to explore other possible paths.

This method ensures that all potential jump sequences are considered, although it is inefficient due to its exhaustive nature.

## **Algorithm**

1. **Initialize**: Start at the first index.
2. **Jump**: From the current index, jump to every index that is reachable within the maximum jump length.
3. **Recursive Call**: For each new index, recursively attempt to reach the last index.
4. **Backtrack**: If stuck, backtrack and try the next possible jump.

### **Pseudocode**

```pseudo
function canJump(nums):
    return backtrack(0, nums)

function backtrack(index, nums):
    if index == length(nums) - 1:
        return true
    furthestJump = min(index + nums[index], length(nums) - 1)
    for nextIndex from index + 1 to furthestJump:
        if backtrack(nextIndex, nums):
            return true
    return false
```

This pseudocode outlines the backtracking approach:
- The `canJump` function initializes the process.
- The `backtrack` function recursively checks each reachable position from the current index. If the last index is reached, it returns true. Otherwise, it backtracks to explore other paths.

## **Implementation**

### Java

```java
public class Solution {

  /**
   * Determines if you can jump from a given position to the last index in the array.
   */
  public boolean canJumpFromPosition(int position, int[] nums) {
    // Base case: If the current position is the last index, return true.
    if (position == nums.length - 1) {
      return true;
    }

    // Calculate the furthest position we can jump to from the current position.
    int furthestJump = Math.min(position + nums[position], nums.length - 1);

    // Try to jump to each position from the next position up to the furthest jump position.
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      // Recursively check if we can jump from the next position to the last index.
      if (canJumpFromPosition(nextPosition, nums)) {
        return true;
      }
    }

    // If none of the jumps work, return false.
    return false;
  }

  /**
   * Determines if you can jump from the first index to the last index in the array.
   */
  public boolean canJump(int[] nums) {
    // Start the jump check from the first position in the array.
    return canJumpFromPosition(0, nums);
  }
}
```

#### Optimization: Check `nextPosition` from right to left

One effective optimization for the code above is to check `nextPosition` from right to left. While the theoretical worst-case performance remains the same, this approach can enhance runtime for certain examples. The idea is to always attempt the largest possible jump first, aiming to reach the end as quickly as possible.

The required change is:

```java
// Previous Approach
for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)

// Optimized Approach
for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
```

The optimized implementation:

```java
public class Solution {
  /**
   * Determines if you can jump from a given position to the last index in the array.
   */
  public boolean canJumpFromPosition(int position, int[] nums) {
    // Base case: If the current position is the last index, return true.
    if (position == nums.length - 1) {
      return true;
    }

    // Calculate the furthest position we can jump to from the current position.
    int furthestJump = Math.min(position + nums[position], nums.length - 1);

    // Try to jump to each position from the furthest jump position down to the next position.
    for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
      // Recursively check if we can jump from the next position to the last index.
      if (canJumpFromPosition(nextPosition, nums)) {
        return true;
      }
    }

    // If none of the jumps work, return false.
    return false;
  }

  /**
   * Determines if you can jump from the first index to the last index in the array.
   */
  public boolean canJump(int[] nums) {
    // Start the jump check from the first position in the array.
    return canJumpFromPosition(0, nums);
  }
}
```

By implementing this change, the algorithm prioritizes the longest jumps first, potentially reducing the number of iterations needed to reach a solution.

##### Best and Worst Cases for the Backtracking Optimization

###### Best Case:

For example, with `nums = [1, 5, 2, 1, 0, 2, 0]`, starting from index 0:
- Jump from index 0 to index 1.
- From index 1, jump 5 steps to reach the end at index 6.
- This completes the task in 3 iterations.

###### Worst Case:

For `nums = [5, 4, 3, 2, 1, 0, 0]`:
- From index 0, you can jump to any of the indices 1 to 5.
- At index 5, you can only jump to index 6, which has a jump length of 0.
- Since the last index cannot be reached from any position, the algorithm must explore all combinations before concluding it is impossible, leading to the worst-case performance.

### TypeScript

```typescript
function canJump(nums: number[]): boolean {
  return backtrack(0, nums);
}

function backtrack(position: number, nums: number[]): boolean {
  if (position === nums.length - 1) {
    return true;
  }

  const furthestJump = Math.min(position + nums[position], nums.length - 1);
  for (
    let nextPosition = position + 1;
    nextPosition <= furthestJump;
    nextPosition++
  ) {
    if (backtrack(nextPosition, nums)) {
      return true;
    }
  }

  return false;
};
```

## **Complexity Analysis**

### Assumptions

- `n` is the length of the array `nums`.

### **Time Complexity**: `O(2^n)`

- **Exponential Possibilities**: In the worst case, there are `2^n` possible ways to jump from the first position to the last. This is because, from each index, we can either move forward by making a jump or backtrack to explore other possibilities. As a result, the time complexity can be described as `O(2^n)`. This exponential time complexity arises from the recursive calls that explore each potential jump combination.

### **Space Complexity**: `O(n)`

- **Depth of Recursion Call Stack**: The space complexity is `O(n)` due to the depth of the recursion call stack. Each recursive call adds a new frame to the stack, and in the worst case, the depth of the recursion can be equal to the length of the array `nums` (i.e., `n`). Therefore, the additional memory required for the stack frames is proportional to the length of the input array.

# Dynamic Programming Top-Down Approach

## **Intuition**

### **What is Top-Down?**

The top-down approach, also known as memoized recursion, involves solving a problem by breaking it down into simpler subproblems and storing the results of these subproblems to avoid redundant computations. This is achieved by leveraging recursion and a memoization table to cache results.

In the context of dynamic programming, the top-down approach can be viewed as an optimized version of backtracking. It relies on the observation that once we determine whether a specific index is valid or invalid, this result will never change. By storing these results, we can avoid recomputing them multiple times, significantly improving the performance.

### **Applying Top-Down Approach**

To apply the top-down approach to the "Jump Game" problem, we use a memoization table, `memo`, to store the validity of each index. The values in this table can be either `VALID`, `INVALID`, or `UNKNOWN`.

For each position in the array, we remember whether the index is valid or invalid. If we determine that an index can reach the last position, it is marked as `VALID`. Conversely, if it cannot reach the last position, it is marked as `INVALID`. Initially, all positions are marked as `UNKNOWN`.

An example of a memoization table for the input array `nums = [2, 4, 2, 1, 0, 2, 0]` can be illustrated as follows:
- Indices 2, 3, and 4 are marked as `INVALID` because we cannot start from these indices and eventually reach the last index (6).
- Indices 0, 1, 5, and (trivially) 6 are marked as `VALID` because they can reach the last index.

By using memoization, we optimize the backtracking algorithm by avoiding redundant checks and leveraging previously computed results.

## **Algorithm**

1. **Initialization**:
   - All elements of the `memo` table are `UNKNOWN`, except for the last one, which is (trivially) `VALID` (it can reach itself).

2. **Modification of Backtracking Algorithm**:
   - The recursive step first checks if the index is known (`VALID` or `INVALID`).
   - If it is known, then return `True` or `False`.
   - Otherwise, perform the backtracking steps as before.

3. **Memoization**:
   - Once we determine the value of the current index, we store it in the `memo` table.

### **Pseudocode**

```pseudo
function canJumpFromPosition(position, nums, memo):
    if memo[position] != UNKNOWN:
        return memo[position] == VALID

    furthestJump = min(position + nums[position], length(nums) - 1)
    for nextPosition = position + 1 to furthestJump:
        if canJumpFromPosition(nextPosition, nums, memo):
            memo[position] = VALID
            return True

    memo[position] = INVALID
    return False

function canJump(nums):
    memo = array of length(nums) filled with UNKNOWN
    memo[length(nums) - 1] = VALID
    return canJumpFromPosition(0, nums, memo)
```

## **Implementation**

### Java

```java
enum Index {
  VALID, INVALID, UNKNOWN
}

public class Solution2 {
  private Index[] memo;

  public boolean canJumpFromPosition(int position, int[] nums) {
    // Check if this position has already been evaluated
    if (memo[position] != Index.UNKNOWN) {
      return memo[position] == Index.VALID;
    }

    // Calculate the furthest position we can jump to from the current position
    int furthestJump = Math.min(position + nums[position], nums.length - 1);

    // Try to jump to each position from the next position up to the furthest jump position
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      // Recursively check if we can jump from the next position to the last index
      if (canJumpFromPosition(nextPosition, nums)) {
        memo[position] = Index.VALID;
        return true;
      }
    }

    // If none of the jumps work, mark this position as invalid
    memo[position] = Index.INVALID;
    return false;
  }

  public boolean canJump(int[] nums) {
    memo = new Index[nums.length];
    // Initialize all positions as UNKNOWN except the last one, which is VALID
    for (int i = 0; i < nums.length; i++) {
      memo[i] = Index.UNKNOWN;
    }
    memo[nums.length - 1] = Index.VALID;

    // Start the jump check from the first position in the array
    return canJumpFromPosition(0, nums);
  }
}
```

### TypeScript

```typescript
enum Index {
  VALID,
  INVALID,
  UNKNOWN
}

function canJumpFromPosition(position: number, nums: number[], memo: Index[]): boolean {
  // Check if this position has already been evaluated
  if (memo[position] !== Index.UNKNOWN) {
    return memo[position] === Index.VALID;
  }

  // Calculate the furthest position we can jump to from the current position
  const furthestJump = Math.min(position + nums[position], nums.length - 1);

  // Try to jump to each position from the next position up to the furthest jump position
  for (let nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
    // Recursively check if we can jump from the next position to the last index
    if (canJumpFromPosition(nextPosition, nums, memo)) {
      memo[position] = Index.VALID;
      return true;
    }
  }

  // If none of the jumps work, mark this position as invalid
  memo[position] = Index.INVALID;
  return false;
}

function canJump(nums: number[]): boolean {
  const memo: Index[] = new Array(nums.length).fill(Index.UNKNOWN);
  // Initialize the last position as VALID
  memo[nums.length - 1] = Index.VALID;

  // Start the jump check from the first position in the array
  return canJumpFromPosition(0, nums, memo);
}
```

## **Complexity Analysis**

### Assumptions
- `n` is the length of the input array `nums`.

### **Time Complexity**: `O(n^2)`

- **Initialization**: Initializing the memoization table with `UNKNOWN` values takes `O(n)` time.
- **Recursive Backtracking with Memoization**:
  - For each position, we may recursively check up to `nums[i]` positions to its right.
  - In the worst case, this can lead to a nested loop where the inner loop runs up to `n` times for each of the `n` elements.
- **Memoization**: Using memoization helps avoid redundant calculations, but in the worst-case scenario, we still have to evaluate each position and its possible jumps at least once.
- **Total Time Complexity**: Therefore, the total time complexity is `O(n * n)` or `O(n^2)`, as we might need to check up to `n` elements for each of the `n` positions.

### **Space Complexity**: `O(n)`

- **Memo Table Usage**: We use a memoization table of size `n` to store the validity of each index, leading to a space complexity of `O(n)`.
- **Recursion Call Stack**: In the worst case, the depth of the recursion tree can go up to `n`, leading to an additional space complexity of `O(n)` due to the recursion call stack.
- **Total Space Complexity**: Therefore, the total space complexity is `O(n) + O(n)` which simplifies to `O(2n)` or `O(n)`.

# Dynamic Programming Bottom-Up Approach

This bottom-up approach eliminates recursion and processes the array from right to left, ensuring that each position is evaluated based on previously computed results.

## **Intuition**

### What is Bottom-Up?

The bottom-up approach involves building up a solution from the smallest subproblems to the larger ones. This is done iteratively, starting from the base cases and combining them to solve the larger problems. Unlike the top-down approach that relies on recursion and memoization to break down problems, the bottom-up approach iteratively solves the problem by reversing the order of computation and leveraging previously computed results.

### Converting from Top-Down to Bottom-Up

Top-down to bottom-up conversion is done by eliminating recursion. In practice, this achieves better performance as we no longer have the method stack overhead and might even benefit from some caching. More importantly, this step opens up possibilities for future optimization. The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.

The observation to make here is that we only ever jump to the right. This means that if we start from the right of the array, every time we query a position to our right, that position has already been determined as being `VALID` or `INVALID`. This means we don't need to recurse anymore, as we will always hit the memo table.

## **Algorithm**

1. **Initialization**:
   - Create a memoization table `memo` where each entry is initially set to `UNKNOWN`.
   - The last position in the array is always `VALID` because it can reach itself.

2. **Bottom-Up Processing**:
   - Iterate from the second-to-last position to the first position.
   - For each position, check the range of jumps that can be made from that position.
   - If any of the jumps lead to a `VALID` position, mark the current position as `VALID` and break the loop.
   - If no valid jumps are found, mark the current position as `INVALID`.

3. **Result**:
   - The result is stored in the first position of the memo table, indicating whether we can jump from the first position to the last.

### **Pseudocode**

```pseudo
function canJump(nums):
    n = length(nums)
    memo = array of size n filled with UNKNOWN
    memo[n - 1] = VALID

    for i = n - 2 to 0:
        furthestJump = min(i + nums[i], n - 1)
        for j = i + 1 to furthestJump:
            if memo[j] == VALID:
                memo[i] = VALID
                break
        if memo[i] != VALID:
            memo[i] = INVALID

    return memo[0] == VALID
```

## **Implementation**

### Implementation Details

- Initialize memoization table.
- Process the array from right to left.
- Check for valid jumps.
- Mark positions as `VALID` or `INVALID` accordingly.
- If the first position is `VALID`, it means we can jump from the first position to the last.

### Java

```java
enum Index {
  VALID, INVALID, UNKNOWN
}

public class Solution3 {

  public boolean canJump(int[] nums) {
    Index[] memo = new Index[nums.length];
    
    // Initialize memo array
    for (int i = 0; i < memo.length; i++) {
      memo[i] = Index.UNKNOWN;
    }

    // The last position is always VALID
    memo[memo.length - 1] = Index.VALID;

    // Bottom-up processing
    for (int i = nums.length - 2; i >= 0; i--) {
      int furthestJump = Math.min(i + nums[i], nums.length - 1);
      for (int j = i + 1; j <= furthestJump; j++) {
        if (memo[j] == Index.VALID) {
          memo[i] = Index.VALID;
          break;
        }
      }
      if (memo[i] != Index.VALID) {
        memo[i] = Index.INVALID;
      }
    }

    // The result is whether the first position is valid
    return memo[0] == Index.VALID;
  }
}
```

### TypeScript

```typescript
enum Index {
  VALID,
  INVALID,
  UNKNOWN
}

function canJump(nums: number[]): boolean {
  const n = nums.length;
  const memo: Index[] = new Array(n).fill(Index.UNKNOWN);

  // The last position is always VALID
  memo[n - 1] = Index.VALID;

  // Bottom-up processing
  for (let i = n - 2; i >= 0; i--) {
    const furthestJump = Math.min(i + nums[i], n - 1);
    for (let j = i + 1; j <= furthestJump; j++) {
      if (memo[j] === Index.VALID) {
        memo[i] = Index.VALID;
        break;
      }
    }
    if (memo[i] !== Index.VALID) {
      memo[i] = Index.INVALID;
    }
  }

  // The result is whether the first position is valid
  return memo[0] === Index.VALID;
}
```

## **Complexity Analysis**

### Assumptions
- `n` is the length of the input array `nums`.

### **Time Complexity**: `O(n^2)`

- **Initialization**: Setting up the memoization table takes `O(n)` time since we initialize an array of size `n`.
- **Bottom-Up Processing**:
  - For each element in the array (from right to left), we potentially examine up to `nums[i]` elements to its right.
  - In the worst case, `nums[i]` can be as large as `n`, leading to a nested loop where the inner loop runs up to `n` times for each of the `n` elements.
- **Total Time Complexity**: This results in a total time complexity of `O(n * n)` or `O(n^2)`, as we might need to check up to `n` elements for each of the `n` positions.

### **Space Complexity**: `O(n)`

- **Memo Table Usage**: We use a memoization table of size `n` to store the validity of each index, leading to a space complexity of `O(n)`.
- **Recursion Call Stack**: Since the bottom-up approach eliminates recursion, we do not need to consider the recursion call stack in this analysis.
- **Total Space Complexity**: Therefore, the total space complexity is `O(n)`.

## **Greedy Algorithm Overview**

### **Definition**
A greedy algorithm is an approach for solving optimization problems by making the most optimal choice at each step as you progress toward a global solution. The choice is "greedy" because it looks for the local best option with the hope that this will lead to the optimal global solution.

### **What is the Greedy Approach?**
The Greedy Algorithm Approach involves making a series of local decisions to find a global solution. For the "Jump Game" problem, this means iteratively determining whether we can jump to a `VALID` position and keeping track of the left-most `VALID` position.
