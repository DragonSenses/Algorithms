# 103. Binary Tree Zigzag Level Order Traversal

<p>Given the <code>root</code> of a binary tree, return <em>the zigzag level order traversal of its nodes' values</em>. (i.e., from left to right, then right to left for the next level and alternate between).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 277px; height: 302px;" src="img/103-1.jpg">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> [[3],[20,9],[15,7]]
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
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


---

# Solution

- [Recursive Approach](#recursive-approach)

### Problem Overview: Binary Tree Zigzag Level Order Traversal

#### **Objective**
Given the `root` of a binary tree, the goal is to return its values in a zigzag level order traversal. This traversal alternates between left-to-right and right-to-left directions for each subsequent level in the binary tree.

#### **Key Details**
1. **Traversal Pattern**: 
   - Begin with left-to-right at the first level.
   - Alternate directions for each level, forming a zigzag pattern.
2. **Input Format**: 
   - `root`, representing the binary tree's root node.
3. **Output Format**: 
   - A list of lists, where each sublist contains node values at a specific level in the zigzag order.
4. **Constraints**:
   - The total number of nodes ranges between 0 and 2000.
   - Node values fall within the range `[-100, 100]`.

#### **Examples**
- **Example 1**:
  - **Input**: `root = [3,9,20,null,null,15,7]`
  - **Output**: `[[3],[20,9],[15,7]]`
  - **Explanation**: Level 1 is `[3]` (left-to-right), level 2 is `[20,9]` (right-to-left), and level 3 is `[15,7]` (left-to-right).

- **Example 2**:
  - **Input**: `root = [1]`
  - **Output**: `[[1]]`
  - **Explanation**: With only one level, the traversal is `[1]`.

- **Example 3**:
  - **Input**: `root = []`
  - **Output**: `[]`
  - **Explanation**: No nodes are present, resulting in an empty list.

#### **Constraints**

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-100 <= Node.val <= 100`
  
#### **Challenges**
1. Handling direction alternation efficiently during traversal.
2. Managing edge cases such as:
   - An empty tree (`root = []`).
   - A single-node tree.
3. Ensuring correct grouping of nodes at each level in zigzag order.

### General Strategies to Traverse a Tree

When solving problems involving tree traversal, it's essential to understand the two main strategies: **Depth First Search (DFS)** and **Breadth First Search (BFS)**. These techniques differ in the order of node exploration and can be chosen based on the specific requirements of a problem.

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

#### **Comparison of Traversal Strategies**
The following diagram illustrates the four traversal strategies—DFS Preorder, DFS Inorder, DFS Postorder, and BFS. In this example, the nodes are numbered in the order they are visited.

![Illustration of a tree with 5 nodes, showcasing four traversal strategies: DFS Postorder, DFS Preorder, DFS Inorder, and BFS, with nodes numbered in the order of visitation for each method.](img/103-2.jpg)

#### **Tree Structure**:
```
        5
       / \
      3   7
     / \
    2   4
```

#### **Traversal Strategies**:
1. **DFS Postorder**:  
   Traverse the left subtree, then the right subtree, and finally the root.  
   **Order:** 2 → 4 → 3 → 7 → 5

2. **DFS Preorder**:  
   Visit the root first, then traverse the left subtree and the right subtree.  
   **Order:** 5 → 3 → 2 → 4 → 7

3. **DFS Inorder**:  
   Traverse the left subtree first, then visit the root, followed by the right subtree.  
   **Order:** 2 → 3 → 4 → 5 → 7

4. **BFS (Level Order)**:  
   Visit nodes level by level, from top to bottom.  
   **Order:** 5 → 3 → 7 → 2 → 4

# Recursive Approach

## **Intuition**

### Level Order Traversal (Breadth-First Search)

The level order traversal processes the nodes level by level, from the root to the deepest level of the tree. Intuitively, in a recursive approach, we can break this problem down by associating each node with its respective depth (or level) and using that information to group nodes into levels.

At each recursive step:
1. We determine the "current level" of the node being processed.
2. We add the node's value to a corresponding list for its level.
3. We recursively process the left and right children of the node, passing along their respective levels (incrementing by 1 for each recursive call).

### Zigzag Level Order Traversal (Breadth-First Search)

The zigzag level order traversal extends the level-by-level approach by alternating the direction in which node values are added to their respective levels. While the recursive technique still involves associating each node with its depth (or level), the key difference lies in maintaining the direction for each level (left-to-right or right-to-left).
