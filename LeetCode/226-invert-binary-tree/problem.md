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

### Proper and Improper Binary Trees

- **Proper Binary Tree**: Each node has either zero or two children.
  - Also known as a **full binary tree**.
  - Every internal node has exactly two children.
- **Improper Binary Tree**: A binary tree that is not proper.

### Properties of Binary Trees

Binary trees have several interesting properties related to the relationships between their heights and the number of nodes.
- **Level d**: The set of all nodes of a tree `T` at the same depth `d`.
  - Level 0 has at most one node (the root).
  - Level 1 has at most two nodes (the children of the root).
  - Level 2 has at most four nodes, and so on.
  - In general, **level d** has at most \(2^d\) nodes.

### Binary Tree Traversals

Understanding how to traverse a binary tree is crucial for many programming problems. There are three common types of traversals:
1. **In-order Traversal**: Visit the left subtree, the root, and then the right subtree.
2. **Pre-order Traversal**: Visit the root, the left subtree, and then the right subtree.
3. **Post-order Traversal**: Visit the left subtree, the right subtree, and then the root.

### Binary Search Tree (BST)

A special kind of binary tree where:
- The left subtree of a node contains only nodes with values less than the node's value.
- The right subtree of a node contains only nodes with values greater than the node's value.
- Both the left and right subtrees must also be binary search trees.