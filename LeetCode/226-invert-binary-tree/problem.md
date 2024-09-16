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

# Solution

To invert a binary tree, you need to swap the left and right children of every node in the tree.

- [Recursive Approach](#recursive)
  - Time complexity: `O(n)`
- [Iterative Approach](#iterative)
  - Time complexity: `O(n)`

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

### Common Operations

Some common operations on binary trees include:
- **Insertion**: Adding a new node to the tree.
- **Deletion**: Removing a node from the tree.
- **Searching**: Finding a node with a specific value.
- **Traversal**: Visiting all the nodes in a specific order.

### Applications

Binary trees are used in various applications, such as:
- **Expression Trees**: Used in compilers to represent expressions.
- **Binary Search Trees**: Used for efficient searching and sorting.
- **Heaps**: Used in priority queues.

### Common Operations and Their Runtimes

1. **Insertion**
   - **Average Case**: \(O(\log n)\)
   - **Worst Case**: \(O(n)\)
   - **Explanation**: In a balanced binary tree, insertion takes \(O(\log n)\) time. However, in an unbalanced tree (like a skewed tree), it can take \(O(n)\) time.

2. **Deletion**
   - **Average Case**: \(O(\log n)\)
   - **Worst Case**: \(O(n)\)
   - **Explanation**: Similar to insertion, deletion in a balanced tree takes \(O(\log n)\) time, but in an unbalanced tree, it can take \(O(n)\) time.

3. **Searching**
   - **Average Case**: \(O(\log n)\)
   - **Worst Case**: \(O(n)\)
   - **Explanation**: Searching for a node in a balanced binary tree takes \(O(\log n)\) time. In an unbalanced tree, it can take \(O(n)\) time.

4. **Traversal (In-order, Pre-order, Post-order)**
   - **Average Case**: \(O(n)\)
   - **Worst Case**: \(O(n)\)
   - **Explanation**: Traversing all the nodes in a binary tree requires visiting each node once, resulting in \(O(n)\) time complexity.

### Additional Notes

- **Balanced Binary Trees**: Trees like AVL trees or Red-Black trees maintain balance, ensuring that operations like insertion, deletion, and searching have \(O(\log n)\) time complexity.

- **Unbalanced Binary Trees**: In the worst case, an unbalanced binary tree can resemble a linked list, leading to \(O(n)\) time complexity for insertion, deletion, and searching.

# Recursive

- **Recursive Approach**: Simple and elegant, but uses the call stack.

## **Intuition**

A binary tree is typically represented using a class for the nodes and a class for the tree itself. Each node contains a value and references to its left and right children. 

Here's the basic implementation we are given in Java:

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

## **Algorithm**

The inverse of an empty tree is still an empty tree.

For a tree with a root node `r` and subtrees `left` and `right`, the inverse is a tree with root `r`, where the left subtree is the inverse of `right`, and the right subtree is the inverse of `left`.

#### Recursive Approach

1. **Base Case**: If the current node is `null`, return `null`.
  
2. **Recursive Case**: Swap the left and right children of the current node, then recursively invert the left and right subtrees.

## **Implementation**

### Java

```java
class Solution {
  public TreeNode invertTree(TreeNode root) {
    // Base case: If the current node is null, return null
    if (root == null) {
      return null;
    }

    // Swap the left and right children
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Recursively invert the left and right subtrees
    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}
```

## **Complexity Analysis**

Let `n` be the number of nodes in tree `T` with height `h`, rooted at `root`.

### **Time complexity**: `O(n)`
  - ***Single Pass:*** We iterate through every node in tree `T` exactly once.

### **Space complexity**: `O(n)`
  - Due to recursion, `O(h)` function calls will be placed on the runtime stack in the worst case, where `h` is the height of the tree.
  - Because `h` is an element of `O(n)`, the space complexity is `O(n)`.

# Iterative

- **Iterative Approach**: Uses a queue for level-order traversal, avoiding the call stack.

## **Intuition**

We can solve the problem iteratively by using a queue to perform a level-order traversal, which is similar to a breadth-first search.

In fact, they are essentially the same concept applied to different contexts:

- **Level-order traversal** is a term typically used in the context of trees. It means visiting all the nodes at each level of the tree before moving on to the next level.

- **Breadth-first search (BFS)** is a term used in the context of graphs. It means exploring all the nodes at the present depth level before moving on to nodes at the next depth level.

Both methods use a queue to keep track of the nodes to be visited next, ensuring that nodes are processed in the correct order. So, when you perform a level-order traversal on a tree, you are essentially performing a BFS.
