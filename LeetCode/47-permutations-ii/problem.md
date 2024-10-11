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

