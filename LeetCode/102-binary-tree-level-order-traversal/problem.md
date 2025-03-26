# 102. Binary Tree Level Order Traversal

<p>Given the <code>root</code> of a binary tree, return <em>the level order traversal of its nodes' values</em>. (i.e., from left to right, level by level).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 277px; height: 302px;" src="img/102-1.jpg">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> [[3],[9,20],[15,7]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1]
<strong>Output:</strong> [[1]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
  <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

---

### Problem Overview: Binary Tree Level Order Traversal

#### **Description**
Given the root of a binary tree, the task is to perform a **level-order traversal** of the tree's nodes. In a level-order traversal, nodes are visited level by level from left to right. The output should be a list of lists, where each list represents the node values at a particular level.

#### **Examples**
- **Example 1:**
  - **Input:** `root = [3,9,20,null,null,15,7]`
  - **Output:** `[[3],[9,20],[15,7]]`
  - **Explanation:** The tree levels are:
    - Level 1: [3]
    - Level 2: [9, 20]
    - Level 3: [15, 7]

- **Example 2:**
  - **Input:** `root = [1]`
  - **Output:** `[[1]]`
  - **Explanation:** The single-node tree only has one level.

- **Example 3:**
  - **Input:** `root = []`
  - **Output:** `[]`
  - **Explanation:** An empty tree has no levels to traverse.

#### **Constraints**
1. The number of nodes in the tree lies within the range: `0 ≤ nodes ≤ 2000`.
2. Node values are integers within the range `-1000 ≤ Node.val ≤ 1000`.

#### **Key Notes**
- A binary tree is structured such that each node may have up to two children (left and right).
- **Level Order Traversal** is also called **Breadth-First Search (BFS)**.

#### **1. Depth First Search (DFS)**
In DFS, the traversal prioritizes depth, meaning we explore as far as possible along a branch before backtracking. Starting from the root node, we go down to a leaf node, then backtrack to explore other branches.

##### **Variants of DFS**
The DFS approach can be categorized into three distinct strategies based on the order of visiting nodes:
- **Preorder Traversal:** Visit the root node first, followed by the left subtree, and finally the right subtree.
- **Inorder Traversal:** Visit the left subtree first, then the root node, and finally the right subtree.
- **Postorder Traversal:** Visit the left subtree, then the right subtree, and finally the root node.

#### **2. Breadth First Search (BFS)**
In BFS, nodes are explored level by level, starting from the topmost level (root) and proceeding downward. Nodes at a given level are visited from left to right before moving to the next level.

##### **Split-Level BFS Traversal**
The problem at hand requires implementing a BFS traversal with split-level outputs, where each level is represented as a separate list:
Example: `[[1], [2, 3], [4, 5]]`
