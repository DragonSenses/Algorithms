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
- [Cascading (iterative) Approach](#cascading-approach)

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

