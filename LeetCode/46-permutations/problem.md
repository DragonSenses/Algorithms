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
