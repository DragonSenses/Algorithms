# 47. Permutations II

<p>Given a collection of numbers, <code>nums</code>,&nbsp;that might contain duplicates, return <em>all possible unique permutations <strong>in any order</strong>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong>
[[1,1,2],
 [1,2,1],
 [2,1,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 8</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
</ul>

<br>

---

# Solution
- [Backtracking Approach](#backtracking-approach)
  - **Time Complexity**: `O(P(N, k))`

# Backtracking Approach

## **Overview**

Backtracking explores all potential candidates for solutions. If a candidate is not a solution, the algorithm discards it and tries another path by backtracking.

**Note**: This problem extends the permutation challenge by allowing the input array to contain ***duplicates***. Therefore, we must adapt our backtracking algorithm to ensure the *generated* solutions are unique and free from duplicates.

### **What is Backtracking?**

Backtracking incrementally finds solutions, adding one piece at a time and removing those that fail to satisfy constraints. It's often used for permutations, combinations, and other exhaustive search problems.

### **How Does Backtracking Work?**

1. **Choose**: Select a starting point or initial decision.
2. **Explore**: Move forward by making choices and exploring further decisions recursively.
3. **Check**: If the current path leads to a solution, record it. If not, backtrack by undoing the last choice and trying another path.

## **Intuition**

To understand permutations, let’s review the concept with an example. Given the input array `[1, 1, 2]`, we aim to generate all possible permutations using the **Depth-First Search** (DFS) approach, specifically the backtracking technique.

### **Concept**

The main idea is to pick the numbers one by one. For a permutation of length `N`, we need `N` stages to generate a valid permutation. At each stage, we pick one number from the remaining available numbers.

### **Process**

1. **Stage Division**: 
   - For a permutation of length `N`, divide the process into `N` stages.

2. **Picking Numbers**:
   - At each stage, pick one number from the remaining available options.

3. **Exploring Choices**:
   - Explore all available choices at each stage by progressively building up candidates for the solution.
   - Revert each choice with another alternative until no more choices are available.

### **Example**

Given the array `[1, 1, 2]`:
- Start with an empty permutation.
- Pick a number, proceed to the next stage, and repeat until a complete permutation is formed.
- Backtrack when no valid choices are left at a stage, and try another path.

### **Detailed Walkthrough**

#### **Initial Stage**

- **Input**: `[1, 1, 2]`
- At the first stage, we have 2 choices to pick a number as the first number in the final permutation: `1` and `2`.
- **Choice 1**: Pick `1`
  - **Remaining Numbers**: `[1, 2]`

**Note**: The reason we have only 2 choices instead of 3 is due to the duplicate `1` in the input. Picking either duplicate `1` first leads to the same permutation.

#### **Second Stage**

- With `[1, 2]` remaining, we again have  2 choices for the next number.
- **Choice 1**: Pick `1`
  - **Remaining Number**: `[2]`

#### **Third Stage**

- With `[2]` remaining, we only have one candidate left.
- **Choice**: Pick `2`
  - **Final Permutation**: `[1, 1, 2]`

#### **Backtracking**

- After generating `[1, 1, 2]`, we backtrack to previous stages and make different choices to explore all possibilities.
- The process of reverting choices and trying alternatives is known as **backtracking**.

#### **Illustration of Exploration**

Below is a graphical representation where each node depicts a choice at a specific stage.

![Graphical representation of backtracking without duplicates on input array [1,1,2], where each node represents a choice at a specific stage](img/47-1.jpg)

**Key Insight**: To avoid generating **redundant** permutations, consider only each **unique** number as a true candidate at each step.

For instance, with the input `[1, 1, 2]`, we have two true candidates (`1` and `2`) at the start, instead of three.

## **Algorithm**

### **Step 1: Build the Hash Map**

Create a hash map (`numsMap`) with each unique number as the key and its occurrence as the corresponding value.

### **Step 2: Define the Backtracking Function**

Define a function `backtrack(currCombination, numsMap)` that generates all permutations.

#### **Backtracking Function**

1. **Base Case**: 
   - If the length of `currCombination` equals the length of the input array, add `currCombination` to the result.
   
2. **Iterate Over numsMap**:
   - For each unique number in `numsMap`, check if it can be used in the current combination.
   
3. **Add to Current Combination**:
   - Add the number to `currCombination`.
   - Decrease its count in `numsMap`.

4. **Recursive Call**:
   - Call `backtrack` with the updated `currCombination` and `numsMap`.

5. **Backtrack**:
   - Remove the number from `currCombination`.
   - Restore its count in `numsMap`.

### **Step 3: Initialize and Invoke the Function**

Invoke the `backtrack` function with an empty `currCombination` and the hash map `numsMap` built from the input array to solve the problem.

## Implementation

### Java

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();

    // Count the occurrence of each number
    HashMap<Integer, Integer> numsMap = new HashMap<>();
    for (int num : nums) {
      numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
    }

    LinkedList<Integer> currCombination = new LinkedList<>();
    this.backtrack(currCombination, nums.length, numsMap, results);
    return results;
  }

  protected void backtrack(
      LinkedList<Integer> currCombination,
      Integer N,
      HashMap<Integer, Integer> numsMap,
      List<List<Integer>> results) {

    // If the combination is done, add it to the results
    if (currCombination.size() == N) {
      results.add(new ArrayList<>(currCombination)); // Make a deep copy of the resulting permutation
      return;
    }

    // Iterate over the numsMap
    for (Integer num : numsMap.keySet()) {
      int count = numsMap.get(num);
      if (count == 0)
        continue;

      // Add this number into the current combination
      currCombination.add(num);
      numsMap.put(num, count - 1);

      // Continue the exploration
      backtrack(currCombination, N, numsMap, results);

      // Revert the choice for the next exploration
      currCombination.removeLast();
      numsMap.put(num, count);
    }
  }
}
```

### TypeScript

```typescript
function backtrack(
  currCombination: number[],
  N: number,
  numsMap: Map<number, number>,
  results: number[][]
): void {
  // If the combination is done, add it to the results
  if (currCombination.length === N) {
    results.push([...currCombination]); // Make a deep copy of the resulting permutation
    return;
  }

  // Iterate over the numsMap
  for (const [num, count] of numsMap.entries()) {
    if (count === 0) continue;

    // Add this number into the current combination
    currCombination.push(num);
    numsMap.set(num, count - 1);

    // Continue the exploration
    backtrack(currCombination, N, numsMap, results);

    // Revert the choice for the next exploration
    currCombination.pop();
    numsMap.set(num, count);
  }
}

function permuteUnique(nums: number[]): number[][] {
  const results: number[][] = [];

  // Count the occurrence of each number
  const numsMap = new Map<number, number>();
  for (const num of nums) {
    numsMap.set(num, (numsMap.get(num) || 0) + 1);
  }

  const currCombination: number[] = [];
  backtrack(currCombination, nums.length, numsMap, results);
  return results;
};
```

## **Complexity Analysis**

### **Time Complexity**: `O(P(N, k))`

The so-called \( k \)-permutations of \( n \), or partial permutations. Here, \( \text{first} + 1 = k \) for simplicity.

- **Formula Explanation**: For each \( k \) (each starting index), the algorithm performs \( N \times (N-1) \times \ldots \times (N-k+1) \) operations.
- **Range of Values**: \( k \) ranges from 1 to \( N \) (and \( \text{first} \) ranges from 0 to \( N-1 \)).

The execution of the backtracking algorithm unfolds as a tree, where each node is an invocation of the recursive function `backtrack(currCombination, numsMap)`. The total number of steps to complete the exploration is the number of nodes in the tree, directly linking the time complexity to the tree's size.

#### **Estimating Nodes in the Tree**

Each level of the tree corresponds to a stage of exploration. At each stage, the number of candidates is **bounded**:
- **First Stage**: At most \( N \) candidates to explore.
- **Next Stages**: Each node at stage one has \( N-1 \) child nodes, so on and so forth.

By summing all nodes across stages, the total number of nodes is:
\[ \sum_{i=1}^{k} P(N, k) \]
where \( P(N, k) = \frac{N!}{(N-k)!} \).

Thus, the exact time complexity of the algorithm is:
\[ O \left( \sum_{i=1}^{N} \frac{N!}{(N-i)!} \right) \]

#### **Upper Bound**

A loose upper bound: It takes \( N \) steps to generate a single permutation. With \( N! \) permutations in total, it would take at most \( N \times N! \) steps, assuming no overlapping effort.

![](img/47-2.jpg)

### **Space Complexity**: `O(N)`

1. **Hash Table**: We build a hash table from the input numbers. In the worst case, where each number is unique, we need `O(N)` space.
2. **Recursion Stack**: Applying recursion consumes extra space in the function call stack, requiring another `O(N)` space.
3. **Current Permutation**: During exploration, we keep a candidate permutation, which requires yet another `O(N)`.

Summing these, the total space complexity is:
\[ O(N) + O(N) + O(N) = O(3N) = O(N) \]

**Note**: This does not include space for the results. Including results storage, space complexity would be:
\[ O(N \times N!) \]
