# 101. Symmetric Tree

<p>Given the <code>root</code> of a binary tree, <em>check whether it is a mirror of itself</em> (i.e., symmetric around its center).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 354px; height: 291px;" src="img/101-1.jpg">
<pre><strong>Input:</strong> root = [1,2,2,3,4,4,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 308px; height: 258px;" src="img/101-2.jpg">
<pre><strong>Input:</strong> root = [1,2,2,null,3,null,3]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it both recursively and iteratively?

---

# Solution

- [Recursive Approach](#recursive-approach)

### Problem Overview: Symmetric Tree

**Objective:**  
You are tasked with determining whether a binary tree is symmetric, meaning it is a mirror of itself around its center.

#### Key Details:
1. **Input:**  
   The root of a binary tree. For example:
   - `root = [1,2,2,3,4,4,3]` (Example 1)
   - `root = [1,2,2,null,3,null,3]` (Example 2)

2. **Output:**  
   A boolean value indicating whether the tree is symmetric:
   - Example 1 Output: `true`  
   - Example 2 Output: `false`  

3. **Constraints:**  
   - The number of nodes in the binary tree ranges from 1 to 1000.
   - The value of each node lies between -100 and 100.

#### Examples:
- **Example 1:**
  ```
  Input: [1,2,2,3,4,4,3]
  Output: true
  ```
  The left and right subtrees are mirror images of each other.

- **Example 2:**
  ```
  Input: [1,2,2,null,3,null,3]
  Output: false
  ```
  The left and right subtrees are not symmetric.

#### Follow-Up Challenge:  
Solve this problem using **both recursive** and **iterative** methods.  
- **Recursive Approach:** Use a helper function to check symmetry by comparing corresponding nodes in left and right subtrees.
- **Iterative Approach:** Use a queue or stack to simulate breadth-first or depth-first traversal, ensuring symmetry at each level.

# Recursive Approach

The recursive approach leverages this intuition by **simultaneously traversing the left and right subtrees** while checking if they align like a mirror. Recursion is well-suited here because the problem can be broken down into smaller subproblems (i.e., comparing smaller subtrees).