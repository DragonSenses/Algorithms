# 90. Subsets II

<p>Given an integer array <code>nums</code> that may contain duplicates, return <em>all possible</em> <span data-keyword="subset" class=" cursor-pointer relative text-dark-blue-s text-sm"><strong>subsets</strong></span><em> (the power set)</em>.</p>

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>A <strong>subset</strong> of an array is a selection of elements (possibly none) of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,2]
<strong>Output:</strong> [[],[1],[1,2],[1,2,2],[2],[2,2]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
</ul>

---

# Solution

- [Bitmasking Approach](#bitmasking-approach)

### **Problem Overview: Generating Unique Subsets (Power Set)**

Given an integer array `nums`, which may contain duplicate values, the goal is to generate **all possible subsets** (the power set) without any duplicate subsets. The solution should be returned in **any order**.

#### Key Requirements:
- Each subset should be unique, meaning duplicate subsets must be eliminated.
- Subsets can be of any length, including the empty set `[]`.
- The order of subsets in the output does not matter.

#### Understanding Subsets:
A subset of an array is a selection of elements that maintains their relative order but does not necessarily include all elements.

#### Example Walkthrough:

##### Example 1:
**Input:** `nums = [1,2,2]`  
**Output:** `[[], [1], [1,2], [1,2,2], [2], [2,2]]`  

Here, the duplicate value `2` is handled carefully to ensure that subsets are unique.

##### Example 2:
**Input:** `nums = [0]`  
**Output:** `[[], [0]]`  

With a single element, the subsets are straightforward: the empty set and the set containing `0`.

#### Constraints:
- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`

#### Approach:
Since duplicates need to be managed carefully, common techniques for solving this problem include:
1. **Backtracking** – Generate subsets iteratively while ensuring unique results.
2. **Sorting + Recursion** – Sorting `nums` helps in identifying and skipping duplicate elements during recursive subset generation.
3. **Bitmasking** (for small values of `nums.length`) – Using binary representation to enumerate subsets.

# Bitmasking Approach

## **Intuition**

Each element in `nums` can either be included in a subset or omitted, resulting in a total of **2ⁿ** distinct subsets for an array of length `n` (assuming no duplicates). Given that `n` has a maximum value of **10**, the number of possible subsets remains manageable (at most **1024**). This allows us to efficiently represent subsets using **bitmasking**.

### **Core Idea**
- Each subset corresponds to a **bitmask** of length `n`.
- A bitmask is a binary number where each bit's state (`1` or `0`) determines whether the corresponding element in `nums` is included in the subset.
- **Example representation:**
  - `000...0` => Empty subset `[]`
  - `111...1` => Full subset containing all elements in `nums`
  - Iterating over values from `0` to `2ⁿ - 1` generates all subsets.

### **Subset Construction via Bitmasking**
For each integer `mask` in the range `[0, 2ⁿ - 1]`, the binary representation reveals which indices should be included:
- **Set bit (`1`)** => Include corresponding element in `nums`
- **Unset bit (`0`)** => Exclude the element

Given the constraint that `n ≤ 10`, an **unsigned integer** (or `long` for extended precision) is sufficient to represent all bitmask combinations.

![Visualizing Subsets Using Bitmasking: Breakdown of `nums = [1,2,2]`](img/90-1.jpg)