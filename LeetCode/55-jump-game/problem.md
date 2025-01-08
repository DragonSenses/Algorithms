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

**Highlight the Bottom-Up Approach**: While you may not have time to fully develop the bottom-up version during the interview, it’s beneficial to mention its advantages. This demonstrates your understanding of different optimization techniques.

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
