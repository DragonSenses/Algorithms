# 46. Permutations

<p>Given an array <code>nums</code> of distinct integers, return all the possible <strong>permutations</strong>. You can return the answer in <strong>any order</strong>.</p>

A <strong>permutation</strong> is a rearrangement of all the elements of an array.

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> [[0,1],[1,0]]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
</ul>

<br>

---

# Solution
- [Backtracking Approach](#backtracking-approach)
  - **Time Complexity**: `O(P(N, k))`

# **Backtracking Approach**

Backtracking is a powerful algorithmic technique used to solve problems by searching through all possible configurations to find a solution. It helps keep the space complexity linear relative to the input size.

### What is Backtracking?

Backtracking is a method for incrementally finding solutions to problems, adding one piece at a time and removing those solutions that fail to satisfy the problem's constraints. It's often utilized for permutations, combinations, and other exhaustive search problems.

### How Does Backtracking Work?

1. **Choose**: Select a starting point or make an initial decision.
2. **Explore**: Move forward by making choices and recursively exploring further decisions.
3. **Check**: If the current path leads to a solution, record it. If not, backtrack by undoing the last choice and trying another path.

## **Intuition**

Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If a solution candidate turns out not to be a solution (or at least not the final one), the backtracking algorithm discards it by making some changes at the previous step (i.e., backtracks) and then tries again.

### **How Backtracking Works**

Here is a backtrack function which takes the index of the first integer to consider as an argument `backtrack(first)`:

1. **Base Case**: 
   - If the first integer to consider has index `n`, that means the current permutation is complete.
2. **Iterate**:
   - Iterate over the integers from index `first` to index `n - 1`.
     - **Swap**: Place the `i`-th integer first in the permutation, i.e., `swap(nums[first], nums[i])`.
     - **Recur**: Proceed to create all permutations starting from the `i`-th integer by calling `backtrack(first + 1)`.
     - **Backtrack**: Undo the swap by calling `swap(nums[first], nums[i])` to reset for the next iteration.

## **Algorithm**

1. Define a backtracking function that will be used to generate permutations.

2. Use a base case to check if the current permutation is complete.

3. Iterate over the elements, swapping to generate different permutations.

4. Recursively call the backtracking function to generate permutations for the next position.

5. Backtrack by swapping back to revert the changes.

### Pseudocode

```pseudo
func permute(nums):
    result = []
    backtrack(nums, 0, result)
    return result

func backtrack(nums, first, result):
    if first == length(nums):
        result.append(copy of nums)
        return
    for i = first to length(nums) - 1:
        swap(nums[first], nums[i])
        backtrack(nums, first + 1, result)
        swap(nums[first], nums[i])  // backtrack
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

  // Generates all permutations of the given array of integers
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, result);
    return result;
  }

  // Helper method to generate permutations using backtracking
  private void backtrack(int[] nums, int first, List<List<Integer>> result) {
    // Base case: If first integer has index equal to length of nums
    // then all integers are consumed
    if (first == nums.length) {
      List<Integer> currentPermutation = new ArrayList<>();
      for (int num : nums) {
        currentPermutation.add(num);
      }
      result.add(currentPermutation);
      return;
    }

    // Iterate over the integers from index 'first' to the end of the array
    for (int i = first; i < nums.length; i++) {
      // Swap the current index with the 'first' index to place the i-th integer first
      // in the permutation
      swap(nums, first, i);
      // Recursively generate permutations for the next position
      backtrack(nums, first + 1, result);
      // Backtrack by undoing the swap
      swap(nums, first, i);
    }
  }

  // Swaps two elements in the given array
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
```

### TypeScript

Similar to the Java approach but the private `swap` utility method is replaced by the more elegant Destructuring Assignment (ES6) to swap elements.

```typescript
function permute(nums: number[]): number[][] {
  const result: number[][] = [];
  backtrack(nums, 0, result);
  return result;
}

function backtrack(nums: number[], startIndex: number, result: number[][]): void {
  // Base case: If the startIndex equals the length of nums, the current permutation is complete.
  if (startIndex === nums.length) {
      result.push([...nums]);
      return;
  }

  // Iterate over the integers from startIndex to the end of the array
  for (let i = startIndex; i < nums.length; i++) {
      // Swap the current index with startIndex to place the i-th integer first in the permutation
      [nums[startIndex], nums[i]] = [nums[i], nums[startIndex]];
      // Recursively generate permutations for the next position
      backtrack(nums, startIndex + 1, result);
      // Backtrack by undoing the swap
      [nums[startIndex], nums[i]] = [nums[i], nums[startIndex]];
  }
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(P(N, k))`

The so-called \( k \)-permutations of \( n \), or partial permutations. Here, \( \text{first} + 1 = k \) for expression simplicity.

- **Formula Explanation**: For each \( k \) (each starting index), the algorithm performs \( N \times (N-1) \times \ldots \times (N-k+1) \) operations.
- **Range of Values**: \( k \) ranges from 1 to \( N \) (and \( \text{first} \) ranges from 0 to \( N-1 \)).

Rough estimation: The algorithm performs better than \( O(N \times N!) \) and a bit slower than \( O(N!) \).

### **Space Complexity**: `O(N!)`

- **Factorial Space Usage**: The algorithm has to store all \( N! \) solutions. Hence, it uses \( O(N!) \) space to keep the solutions.
