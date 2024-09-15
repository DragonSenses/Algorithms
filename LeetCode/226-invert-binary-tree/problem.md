# 226. Invert Binary Tree

Given the `root` of a binary tree, invert the tree, and return *its root*.

#### Example 1:

Input: root = [4,2,7,1,3,6,9]

Output: [4,7,2,9,6,3,1]

![](img/226-1.jpg)

#### Example 2:

Input: root = [2,1,3]

Output: [2,3,1]

![](img/226-2.jpg)

#### Example 3:

Input: root = []

Output: []

#### Constraints:

  - The number of nodes in the tree is in the range `[0, 100]`.
  - `-100 <= Node.val <= 100`

#### Definitions

```java
// Definition for a binary tree node.
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) { this.val = val; }
  
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
```

## Binary Tree Overview

### Tree Structure

A tree is a nonlinear data structure that stores elements hierarchically.
- **Nonlinear**: Refers to an organizational relationship that is richer than "before" and "after" between objects in sequences.
- **Hierarchical Relationships**: Some objects are "above" and some "below" others.
- **Root**: The top element of the tree.
- **Parent and Children**: Each element (except the root) has a parent element and zero or more children.

### Binary Tree

A **binary tree** is an ordered tree with the following properties:
1. Every node has at most two children.
2. Each child node is labeled as either a **left child** or a **right child**.
3. A left child precedes a right child in the order of children of a node.

The subtree rooted at a left or right child of an internal node, `v`, is called a **left subtree** or **right subtree**, respectively, of `v`.