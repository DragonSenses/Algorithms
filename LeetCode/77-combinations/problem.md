# 77. Combinations

<p>Given two integers <code>n</code> and <code>k</code>, return <em>all possible combinations of</em> <code>k</code> <em>numbers chosen from the range</em> <code>[1, n]</code>.</p>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 4, k = 2
<strong>Output:</strong> [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
<strong>Explanation:</strong> There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1, k = 1
<strong>Output:</strong> [[1]]
<strong>Explanation:</strong> There is 1 choose 1 = 1 total combination.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>

<br>

---

# Solution
- [Backtracking Recursive Approach](#backtracking-recursive-approach)
  - **Time Complexity**: `O(C(k, n))`
- [Lexicographic (Binary Sorted) Combinations (Iterative Approach)](#lexicographic-binary-sorted-combinations-iterative-approach)
  - **Time Complexity**: `O(C(k, n))`

## Overview of Combinations

Combinations refer to the selection of items from a larger set where the order of selection does not matter. The formula to calculate the number of combinations is given by the binomial coefficient:
\[ C(k, n) = \frac{n!}{k!(n - k)!} \]
where `n` is the total number of items, and `k` is the number of items to choose. For example, choosing 2 items from a set of 4 (like {1, 2, 3, 4}) results in combinations such as {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, and {3, 4}.

## Overview of Backtracking

Backtracking is a problem-solving algorithm that incrementally builds candidates to the solutions and abandons candidates ("backtracks") as soon as it determines that they cannot possibly lead to a valid solution. It’s particularly useful for problems involving permutations, combinations, and other constraint-satisfaction problems.

The process involves:
1. **Building Solutions**: Starting with an empty solution and adding elements one by one.
2. **Exploration**: If the current partial solution is valid, recursively continue to add elements.
3. **Backtrack**: If adding the next element leads to an invalid solution, remove the last added element (backtrack) and try the next possibility.

Backtracking helps in exploring all possible solutions in a systematic way by pruning invalid paths, making it efficient for combinatorial problems.

# Backtracking (Recursive Approach)

## **Intuition**

Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If a candidate turns out to be not a solution (or at least not the final one), the backtracking algorithm discards it by backtracking to the previous step and then trying again.

## **Algorithm**

1. **Backtrack Function**: 
   - Define a backtrack function that takes an integer `first` to start adding numbers from and the current combination `curr` as arguments: `backtrack(first, curr)`.
2. **Check Completion**: 
   - If the current combination `curr` is done (i.e., it has `k` numbers), add it to the output.
3. **Iterate and Add**:
   - Iterate over the integers from `first` to `n`.
   - Add integer `i` to the current combination `curr`.
   - Proceed to add more integers into the combination by recursively calling `backtrack(i + 1, curr)`.
4. **Backtrack**:
   - Remove integer `i` from `curr` to backtrack.

### Pseudocode

```plaintext
function backtrack(first, curr):
    if curr is complete:
        add curr to output
        return

    for i in range(first, n + 1):
        curr.add(i)
        backtrack(i + 1, curr)
        curr.remove(i)
```

### Implementation Details

1. **Define the Backtrack Function**: Define a function that will take the starting number and the current combination as parameters.

2. **Base Case**: Check if the current combination is complete, and if so, add it to the result.

3. **Iterate and Recurse**: Iterate over the possible numbers, add them to the current combination, and recurse with the next number.

4. **Backtrack**: Remove the number from the current combination to backtrack.

### Combine Function

**Combine Function**: The main function combine initializes the result array and starts the backtracking process.

### Backtrack Function

**Backtrack Function**: The inner function backtrack takes the current start number and the current combination array. It checks if the current combination is complete and adds it to the result if so. Otherwise, it iterates over the possible numbers, adds each to the current combination, recurses with the next number, and then backtracks by removing the last number.

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the problem of finding all possible combinations 
 * of k numbers chosen from the range [1, n].
 */
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n;
    int k;

    /**
     * Uses backtracking to generate all possible combinations.
     *
     * @param first The starting number to add to the current combination.
     * @param curr The current combination being constructed.
     */
    private void backtrack(int first, List<Integer> curr) {
        // If the combination is complete, add it to the output list
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }

        for (int i = first; i <= n; ++i) {
            // Add i into the current combination
            curr.add(i);

            // Use next integers to complete the combination
            backtrack(i + 1, curr);

            // Remove last element to backtrack
            curr.remove(curr.size() - 1);
        }
    }

    /**
     * Returns all possible combinations of k numbers chosen from the range [1, n].
     *
     * @param n The upper limit of the range.
     * @param k The number of elements in each combination.
     * @return A list of all possible combinations.
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new ArrayList<>());
        return output;
    }
}
```

#### Improved Java Implementation

refactor(#77): Enhance modularity & readability

Refactored the backtracking solution to improve modularity and readability. Changes include:
- Encapsulated all methods and variables within the class.
- Enhanced comments and documentation with Javadocs for better understanding.
- Improved code structure by separating concerns, making the code easier to read and maintain.
- Used ArrayList instead of LinkedList for better performance and simplicity.

```java
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the problem of finding all possible
 * combinations of k numbers chosen from the range [1, n].
 */
class Solution {
  /**
   * Returns all possible combinations of k numbers chosen from the range [1, n].
   *
   * @param n The upper limit of the range.
   * @param k The number of elements in each combination.
   * @return A list of all possible combinations.
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> output = new ArrayList<>();
    backtrack(1, n, k, new ArrayList<>(), output);
    return output;
  }

  /**
   * Uses backtracking to generate all possible combinations.
   *
   * @param start  The starting number to add to the current combination.
   * @param n      The upper limit of the range.
   * @param k      The number of elements in each combination.
   * @param curr   The current combination being constructed.
   * @param output The list to store all possible combinations.
   */
  private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> output) {
    // If the combination is complete, add it to the output list
    if (curr.size() == k) {
      output.add(new ArrayList<>(curr));
      return;
    }

    // Iterate over the range from `start` to `n`
    for (int i = start; i <= n; ++i) {
      // Add i into the current combination
      curr.add(i);

      // Use next integers to complete the combination
      backtrack(i + 1, n, k, curr, output);

      // Remove last element to backtrack
      curr.remove(curr.size() - 1);
    }
  }
}
```

### TypeScript

```typescript
function combine(n: number, k: number): number[][] {
  const result: number[][] = [];

  function backtrack(start: number, current: number[]): void {
    // If the combination is complete, add it to the result
    if (current.length === k) {
      result.push([...current]);
      return;
    }

    // Iterate over the range from `start` to `n`
    for (let i = start; i <= n; i++) {
      // Add i to the current combination
      current.push(i);

      // Use the next integers to complete the combination
      backtrack(i + 1, current);

      // Remove the last element to backtrack
      current.pop();
    }
  }

  // Start the backtracking process
  backtrack(1, []);
  return result;
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(C(k, n))`
- **Combinations**: The number of combinations `C(k, n)` is given by the binomial coefficient: \[ C(k, n) = \frac{n!}{k!(n - k)!} \]
- **Operations**: 
  - The `append` and `pop` operations (`add`/`removeLast`) are constant-time operations.
  - The most time-consuming part is appending each built combination of length `k` to the output.
- **Overall**: The time complexity is `O(C(k, n))`.

### **Space Complexity**: `O(C(k, n))`
- **Space for Output**: It uses `O(C(k, n))` space to store all the combinations.
- **Auxiliary Space**: Additional space is used for the recursion stack, which is `O(k)` in the worst case, but the dominant factor remains the space needed for the output.

In summary, both the time and space complexities are `O(C(k, n))`, where `C(k, n)` represents the number of combinations.

# Lexicographic (Binary Sorted) Combinations (Iterative Approach)

The lexicographic (binary sorted) combinations iterative algorithm is an improvement over the recursive backtracking algorithm despite having the same time complexity due to avoiding the overhead of recursive call stacks and using straightforward iteration instead. 

### Performance Comparison

- This algorithm is generally faster than the backtracking approach in languages like Python and TypeScript due to higher function call overhead.
- In Java, this effect is less pronounced due to optimized handling of recursion.

The impact of the recursive call overhead can indeed be more pronounced in languages like TypeScript and Python compared to Java. This is because:

- **Python**: Has a higher function call overhead due to its dynamic nature and interpreted execution. The global interpreter lock (GIL) can also make recursive calls less efficient.

-**TypeScript**: Similarly, being a superset of JavaScript, suffers from function call overhead in the V8 engine, and recursive calls can be more taxing.

In contrast, **Java** has:

- **Optimized Recursion**: Java compilers and the JVM are better optimized for handling recursion.

- **Tail Call Optimization**: Java can perform certain optimizations for recursive calls, reducing overhead.

Thus, the benefits of iterative approaches like the lexicographic (binary sorted) combinations are more noticeable in Python and TypeScript due to their higher function call overhead compared to Java.

## Lexicographic Binary Sorted Combinations: Key Terms

"Lexicographic binary sorted combinations" refers to generating all combinations of a set in a systematic, dictionary-like order, using an approach that resembles binary representations for easier traversal. This method ensures that all possible combinations are produced in a neat and orderly manner.

### Lexicographic
- **Definition**: Refers to the order in which words (or sequences) are arranged in a dictionary-like sequence.
- **Context**: When generating combinations, lexicographic order means producing them in a sorted manner as if they were arranged in a dictionary. For example, combinations of {1, 2, 3} from {1, 2, 3, 4} would appear as [1, 2], [1, 3], [2, 3] in lexicographic order.

### Binary Sorted
- **Definition**: A way to generate combinations where each combination is represented and generated in a binary-like fashion.
- **Context**: In this context, "binary sorted" means generating combinations in a way that reflects the binary representation of numbers. This usually helps in systematically generating and traversing all possible combinations.

### Combinations
- **Definition**: A selection of items from a larger set where the order of selection does not matter.
- **Context**: For example, given a set {1, 2, 3, 4}, the combinations of 3 elements would be {1, 2, 3}, {1, 2, 4}, {1, 3, 4}, and {2, 3, 4}. 

## **Intuition**

The goal is not only to generate all combinations but to produce them in lexicographic (binary sorted) order. This ensures that the combinations are listed in a sorted manner, which can be useful for certain applications like systematic enumeration.

## **Algorithm**

The algorithm follows these steps:

1. **Initialize**:
   - Create `nums` as a list of integers from `1` to `k`.
   - Add `n + 1` as the last element of `nums`, serving as a sentinel.
   
2. **Set Pointer**:
   - Initialize `j` to `0`, which will be used to traverse the `nums` list.
   
3. **Generate Combinations**:
   - While `j < k`:
     1. Add the first `k` elements of `nums` (excluding the sentinel) to the output.
     2. Find the first number in `nums` such that `nums[j] + 1 != nums[j + 1]`.
     3. Increase `nums[j]` by 1 to move to the next combination.
     4. Reset `j` to 0.

### Example Walkthrough

Let's consider `n = 5` and `k = 3`:

1. **Initialize**:
   - `nums = [1, 2, 3, 6]` (6 as the sentinel)

2. **Generate Combinations**:
   - Iteration 1:
     - Output: `[1, 2, 3]`
     - `nums = [1, 2, 4, 6]` (increment `nums[2]`)
     - Reset `j` to 0.
   - Iteration 2:
     - Output: `[1, 2, 4]`
     - `nums = [1, 2, 5, 6]` (increment `nums[2]`)
     - Reset `j` to 0.
   - Iteration 3:
     - Output: `[1, 2, 5]`
     - `nums = [1, 3, 4, 6]` (increment `nums[1]`)
     - Reset `j` to 0.
   - Continue this process until all combinations are generated.

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> output = new ArrayList<>();
    int[] nums = new int[k + 1];

    for (int i = 0; i < k; i++) {
      nums[i] = i + 1;
    }
    nums[k] = n + 1; // Sentinel value

    int j = 0;
    while (j < k) {
      List<Integer> combination = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        combination.add(nums[i]);
      }
      output.add(combination);

      j = 0;
      while (j < k && nums[j] + 1 == nums[j + 1]) {
        nums[j] = j + 1;
        j++;
      }
      nums[j]++;
    }
    return output;
  }
}
```

### TypeScript

```typescript
/**
 * Generates all combinations of k numbers out of the range [1, n] in lexicographic order.
 *
 * @param n - The upper limit of the range.
 * @param k - The number of elements in each combination.
 * @returns A list of all possible combinations.
 */
function combine(n: number, k: number): number[][] {
  const output: number[][] = []; // List to store all combinations
  const nums: number[] = new Array(k + 1); // Array to store the current combination and sentinel

  // Initialize the nums array with the first k elements and a sentinel value
  for (let i = 0; i < k; i++) {
    nums[i] = i + 1;
  }
  nums[k] = n + 1; // Sentinel value to mark the end

  let j = 0; // Pointer to traverse the nums array

  // Generate combinations in lexicographic order
  while (j < k) {
    // Collect the first k elements (excluding the sentinel) into a combination
    const combination: number[] = [];
    for (let i = 0; i < k; i++) {
      combination.push(nums[i]);
    }
    output.push(combination); // Add the combination to the output list

    // Find the first number in nums that can be incremented
    j = 0;
    while (j < k && nums[j] + 1 === nums[j + 1]) {
      nums[j] = j + 1; // Reset the current number to its smallest possible value
      j++;
    }
    nums[j]++; // Increment the number to move to the next combination
  }

  return output;
};
```

