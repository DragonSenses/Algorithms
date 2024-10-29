# 78. Subsets

<p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <strong>subsets</strong> <em>(the power set)</em>.</p>

- A **subset** of an array is a selection of elements (possibly none) of the array.

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
</ul>

<br>

---

# Solution
- [Lexicographic (Binary Sorted) Subsets](#lexicographic-binary-sorted-subsets)
  - **Time Complexity**: `O(N × 2^N)`
- [Cascading (Iterative) Approach](#cascading-approach)
  - **Time Complexity**: `O(N × 2^N)`
- [Backtracking (Recursive) Approach](#backtracking-recursive-approach)
  - **Time Complexity**: `O(N × 2^N)`

## **Problem Overview**

### Introduction
Given an integer array `nums` of **unique** elements, the task is to return all possible **subsets** (the power set). A subset of an array is a selection of elements (possibly none) of the array. The solution set **must not** contain duplicate subsets and can be returned in **any order**.

### Example
- **Example 1**:
  - **Input**: nums = [1,2,3]
  - **Output**: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]

- **Example 2**:
  - **Input**: nums = [0]
  - **Output**: [[], [0]]

### Constraints
- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- All elements in `nums` are **unique**.

## Problem Comparison: Permutations, Combinations, Subsets
Let's review the problems of Permutations, Combinations, and Subsets as they are quite similar and share common strategies:

### Solution Space
- **Permutations**: \( N! \)
- **Combinations**: \( C(k, n) = \frac{n!}{k!(n - k)!} \)
- **Subsets**: \( 2^N \) (each element could be absent or present)

Given their exponential solution space, ensuring that generated solutions are complete and non-redundant is challenging. A clear and easy-to-reason strategy is essential.

### Common Strategies
1. **Iterative**
2. **Recursion/Backtracking**
3. **Lexicographic Generation**: Based on mapping binary bitmasks to the corresponding permutations/combinations/subsets.

### Preferred Method
- The **Lexicographic Generation** method can be a good candidate, especially for interviews. It simplifies the problem to the generation of binary numbers, making implementation and verification easier.
- Additionally, it generates lexicographically sorted output for sorted inputs.

### Summary
Understanding these strategies and their implications helps tackle problems related to Permutations, Combinations, and Subsets effectively. The Lexicographic Generation method stands out due to its simplicity and efficiency.

# Lexicographic (Binary Sorted) Subsets

The idea of this solution is originated from [**Donald E. Knuth**](https://www-cs-faculty.stanford.edu/~knuth/taocp.html).

## **Intuition**

The idea is to map each subset to a bitmask of length `n`, where `1` on the `i`th position in the bitmask means the presence of `nums[i]` in the subset, and `0` means its absence.

### Example
For `nums = [1, 2, 3]`:
- **bitmask**: `[0, 0, 0]` | **subset**: `[ , , ]`
- **bitmask**: `[0, 0, 1]` | **subset**: `[ , , 3]`
- **bitmask**: `[0, 1, 0]` | **subset**: `[ , 2, ]`
- **bitmask**: `[1, 1, 1]` | **subset**: `[1, 2, 3]`

### Concept
- The bitmask `0..00` (all zeros) corresponds to an empty subset.
- The bitmask `1..11` (all ones) corresponds to the entire input array `nums`.

### Goal
To solve the problem, generate `2^n` bitmasks from `0..00` to `1..11`.

### Challenges
Generating binary numbers involves dealing with zero left padding, as bitmasks must have a fixed length (e.g., `001` instead of `1`).

### Solution
**Standard Bit Manipulation Trick**:
```java
int nthBit = 1 << n;
for (int i = 0; i < (int)Math.pow(2, n); ++i) {
    // generate bitmask, from 0..00 to 1..11
    String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
}
```

or keep it simple and shift iteration limits:

```java
for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
  // generate bitmask, from 0..00 to 1..11
  String bitmask = Integer.toBinaryString(i).substring(1);
```

## **Algorithm**

### Steps

1. **Generate Bitmasks**:
   - Generate all possible binary bitmasks of length `n`.
   - This ranges from `0..00` to `1..11`.

2. **Map Subsets**:
   - For each bitmask:
     - `1` on the `i`th position in the bitmask means the presence of `nums[i]` in the subset.
     - `0` means its absence.

3. **Return Output**:
   - Collect all mapped subsets and return them as the output list.

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    int n = nums.length;

    for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList<>();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1')
          curr.add(nums[j]);
      }
      output.add(curr);
    }
    return output;
  }
}
```

### TypeScript

```typescript
function subsets(nums: number[]): number[][] {
    let n = nums.length;
    let output: number[][] = [];
    for (let i = Math.pow(2, n); i < Math.pow(2, n + 1); ++i) {
        // generate bitmask, from 0..00 to 1..11
        let bitmask = (i >>> 0).toString(2).substring(1);
        // append subset corresponding to that bitmask
        let curr: number[] = [];
        for (let j = 0; j < n; ++j) {
            if (bitmask.charAt(j) == "1") curr.push(nums[j]);
        }
        output.push(curr);
    }
    return output;
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(N × 2^N)`
- **Generating Subsets**: `O(N × 2^N)` to generate all subsets and copy them into the output list.
- **Overall**: The time complexity is `O(N × 2^N)`.

### **Space Complexity**: `O(N)`
- **Space for Bitset**: `O(N)` to store the bitset of length `N`.
- **Output Space**: For space complexity analysis, the output array is ignored as it is used for returning the final result.
- **Overall**: The space complexity is `O(N)`.

# Cascading Approach

### Cascading in this Context

In this context, **cascading** refers to the process of building new subsets by taking each element and generating new subsets based on the existing ones. It's like a domino effect where each step builds on the previous steps, resulting in all possible combinations.

Therefore the cascading approach is an **iterative approach**. Here's why:
- You start with an initial state (the empty subset).
- For each element in the array, you iterate through the existing subsets and generate new subsets by including the current element.
- This process is repeated for every element in the array until all possible subsets are generated.

This method ensures you comprehensively generate all subsets without any duplicates, building up from smaller to larger subsets in an orderly manner.

## **Intuition**

Start from an empty subset in the output list. At each step, take a new integer into consideration and generate new subsets from the existing ones.

1. **Start** from an empty subset.
   - `nums = [1, 2, 3]`
   - Initial output: `[]`

2. **Take 1** into consideration and add new subsets by updating existing ones.
   - Current output: `[], [1]`

3. **Take 2** into consideration and add new subsets by updating existing ones.
   - Current output: `[], [1], [2], [1, 2]`

4. **Take 3** into consideration and add new subsets by updating existing ones.
   - Final output: `[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]`

This cascading approach helps you build subsets step-by-step by progressively adding each element to the existing subsets. This ensures you cover all possible combinations without duplicating subsets.

## **Algorithm**

### Algorithm Steps

1. **Initialize the Output List**: Start with a list that contains an empty subset.

2. **Iterate Over Each Element in Input Array**: For each element in the input array, perform the following steps.

  a. **Capture Current Size of Output List**: Record the current size of the output list.

  b. **Generate New Subsets**: For each existing subset in the output list, create a new subset by adding the current element.

  c. **Add New Subsets to Output List**: Append all newly generated subsets to the output list.

3. **Return the Output List**: Once all elements have been processed, return the output list containing all subsets.

### Pseudocode

```pseudo
function findSubsets(nums):
    output = [[]]
    for each num in nums:
        currentSize = size(output)
        for i from 0 to currentSize - 1:
            newSubset = copy(output[i])
            add num to newSubset
            add newSubset to output
    return output
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    output.add(new ArrayList<>()); // Start with the empty subset

    for (int num : nums) {
      int currentSize = output.size();
      for (int i = 0; i < currentSize; i++) {
        List<Integer> newSubset = new ArrayList<>(output.get(i));
        newSubset.add(num);
        output.add(newSubset);
      }
    }

    return output;
  }
}
```

### TypeScript

```typescript
/**
 * Finds all possible subsets of the given integer array using a cascading 
 * iterative approach.
 *
 * @param {number[]} nums - An array of unique integers.
 * @returns {number[][]} A list of all possible subsets.
 */
function subsets(nums: number[]): number[][] {
  const output: number[][] = [];
  output.push([]); // Start with the empty subset

  for (const num of nums) {
    const currentSize = output.length;
    for (let i = 0; i < currentSize; i++) {
      const newSubset = output[i].slice(); // Create a new subset from an existing subset
      newSubset.push(num); // Add the current number to the new subset
      output.push(newSubset); // Add the new subset to the output list
    }
  }

  return output;
};
```

## **Complexity Analysis**

### **Time Complexity**: `O(N × 2^N)`
- **Generating Subsets**: The time complexity is `O(N × 2^N)` to generate all subsets and copy them into the output list.
- **Overall**: The time complexity remains `O(N × 2^N)`.

### **Space Complexity**: `O(N × 2^N)`
- **Explanation**: The space complexity is `O(N × 2^N)`. This is due to the number of solutions for subsets multiplied by the number `N` of elements to keep for each subset. For a given number, it could be present or absent (i.e., a binary choice) in a subset solution. As a result, for `N` numbers, we would have a total of `2^N` choices (solutions).
- **Overall**: The space complexity is `O(N × 2^N)`.

# Backtracking (Recursive) Approach

**Backtracking** is an algorithm for finding all solutions by exploring all potential candidates. If a candidate turns out to be not a solution (or at least not the last one), the backtracking algorithm discards it by making some changes on the previous step, i.e., backtracks and then tries again.

## **Intuition**
A power set is all possible combinations of elements in the array, ranging from 0 to n in length. Given the definition, the problem can also be interpreted as finding the power set from a sequence. This time, we loop over the length of the combination, rather than the candidate numbers, and generate all combinations for a given length using the backtracking technique.

### Steps:
1. **Start with an empty subset.**
2. **Iterate over all possible lengths**: from 0 to n.

For example, with `nums = [1, 2, 3]`:
- All subsets of length 0: `[]`
- All subsets of length 1: `[1], [2], [3]`
- All subsets of length 2: `[1, 2], [2, 3], [1, 3]`
- All subsets of length 3: `[1, 2, 3]`

### Detailed Algorithm:
1. **Initialization**: Start with an empty list to hold all subsets.
2. **Iterate over lengths**: Loop from 0 to the length of the input array.
3. **Backtracking to generate combinations**: For each length, use backtracking to generate all possible combinations of that length.

By following these steps, the backtracking approach explores all subsets, ensuring no duplicates and covering all possible lengths.

This refined approach helps systematically explore and generate the power set using the backtracking method.

## **Algorithm**

### Steps:
1. **Initialize Output List**: Start with an empty subset.
2. **Iterate Over All Lengths**: From 0 to the length of the input array.
3. **Backtracking Function**: Generate all combinations of the current length.
   - Add the current element to the subset.
   - Recursively generate combinations by moving to the next element.
   - Backtrack by removing the last added element from the subset.

### Pseudocode
```plaintext
function backtrack(first, curr):
    if the current combination is complete:
        add curr to output
        return
    for i from first to n:
        add nums[i] to curr
        backtrack(i + 1, curr)
        remove nums[i] from curr

function findSubsets(nums):
    output = []
    for k from 0 to length(nums):
        backtrack(0, [])
    return output
```

### Backtracking Walkthrough Example

#### Steps:
1. **First Element**:
    - Take `nums[0] = 1` as the first element.

2. **Complete Subset**:
    - Use the next elements: `nums[1]` and `nums[2]` to complete the subset.
        - **Use `nums[1] = 2`**:
            - The subset `[1, 2]` is complete.
        - **Backtrack**:
            - Pop `nums[1]` out.
        - **Use `nums[2] = 3`**:
            - The subset `[1, 3]` is complete.

3. **Resulting Subsets**:
    - `[1, 2]`
    - `[1, 3]`

4. **Next Element**:
    - Take `nums[1] = 2` as the first element.

5. **Complete Subset**:
    - Use the next element: `nums[2]` to complete the subset.
        - **Use `nums[2] = 3`**:
            - The subset `[2, 3]` is complete.

6. **Resulting Subsets**:
    - `[2, 3]`

### Backtracking Function
We define a backtrack function named `backtrack(first, curr)` which takes the index of the first element to add and a current combination as arguments.

- **Complete Combination**:
    - If the current combination is done, add the combination to the final output.
- **Iterate Over Indices**:
    - Iterate over the indices `i` from `first` to the length of the entire sequence `n`.
    - **Add Element**:
        - Add integer `nums[i]` into the current combination `curr`.
    - **Recursively Add More Elements**:
        - Proceed to add more integers into the combination: `backtrack(i + 1, curr)`.
    - **Backtrack**:
        - Backtrack by removing `nums[i]` from `curr`.

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

  private void backtrack(int first, List<Integer> curr, int[] nums, List<List<Integer>> output, int k) {
    // If the current combination is done
    if (curr.size() == k) {
      output.add(new ArrayList<>(curr));
      return;
    }
    for (int i = first; i < nums.length; i++) {
      // Add nums[i] into the current combination
      curr.add(nums[i]);
      // Use next integers to complete the combination
      backtrack(i + 1, curr, nums, output, k);
      // Backtrack by removing nums[i]
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    // Iterate over all possible lengths
    for (int k = 0; k <= nums.length; k++) {
      backtrack(0, new ArrayList<>(), nums, output, k);
    }
    return output;
  }
}
```
