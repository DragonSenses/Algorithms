# 104. Maximum Depth of Binary Tree

<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree's <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/104-1.jpg" style="width: 400px; height: 277px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<br>

---

# Solution

- [Recursive Approach](#recursive-approach)

# Recursive Approach

## **Intuition**

By definition, the maximum depth of a binary tree is the maximum number of steps to reach a leaf node from the root node. The idea is to traverse the tree and keep track of the maximum depth encountered.

We can traverse the tree using either Depth-First Search (DFS) or Breadth-First Search (BFS) strategies. Here, we'll use a DFS approach implemented with recursion.

The intuition behind the recursive approach is as follows:
- At each node, compute the depth of its left subtree and its right subtree.
- The maximum depth at the current node is the greater of the two depths plus one (to account for the current node).
