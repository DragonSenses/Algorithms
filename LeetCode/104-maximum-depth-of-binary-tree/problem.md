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
  - **Time Complexity**: `O(n)`

# Recursive Approach

## **Intuition**

By definition, the maximum depth of a binary tree is the maximum number of steps to reach a leaf node from the root node. The idea is to traverse the tree and keep track of the maximum depth encountered.

We can traverse the tree using either Depth-First Search (DFS) or Breadth-First Search (BFS) strategies. Here, we'll use a DFS approach implemented with recursion.

The intuition behind the recursive approach is as follows:
- At each node, compute the depth of its left subtree and its right subtree.
- The maximum depth at the current node is the greater of the two depths plus one (to account for the current node).

## **Algorithm**

1. **Base Case**: If the current node is null, return 0.
2. **Recursive Case**: 
   - Recursively calculate the maximum depth of the left subtree.
   - Recursively calculate the maximum depth of the right subtree.
   - The depth of the current node is the greater of the depths of its left and right subtrees plus one.

## **Implementation**

### Java

```java
public class Solution {
  /**
   * Finds the maximum depth of a binary tree using the recursive approach.
   *
   * @param root The root node of the binary tree.
   * @return The maximum depth of the binary tree.
   */
  public int maxDepth(TreeNode root) {
    // Base case: if the current node is null, the depth is 0
    if (root == null) {
      return 0;
    }

    // Recursively find the maximum depth of the left subtree
    int leftDepth = maxDepth(root.left);

    // Recursively find the maximum depth of the right subtree
    int rightDepth = maxDepth(root.right);

    // The depth of the current node is the greater of the depths of its subtrees plus one
    return Math.max(leftDepth, rightDepth) + 1;
  }
}

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
```

### TypeScript

```typescript
/**
 * Definition for a binary tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Finds the maximum depth of a binary tree.
 *
 * @param root The root node of the binary tree.
 * @returns The maximum depth of the binary tree.
 */
function maxDepth(root: TreeNode | null): number {
  if (root === null) {
    return 0;
  }

  const leftDepth = maxDepth(root.left);
  const rightDepth = maxDepth(root.right);

  return Math.max(leftDepth, rightDepth) + 1;
}
```

## **Complexity Analysis**

Let `n` be the number of nodes in the tree.

### **Time Complexity**: `O(n)`

- **Traversal of Nodes**: Each node in the binary tree is visited exactly once during the traversal. 
  - During the recursive traversal, we make a call to each node, process it, and move on to its children.
- **Linear Time**: Therefore, the time complexity is `O(n)`, where `n` is the number of nodes in the tree.

### **Space Complexity**: `O(n)`

- **Function Call Stack**: In the worst case, the maximum depth of the binary tree can be `n` (in the case of a skewed tree where each node only has one child). Thus, the function call stack can grow up to `n` calls deep.
  - For a balanced binary tree, the depth would be closer to `log(n)`, but we consider the worst-case scenario for space complexity.
- **Overall Space Complexity**: Combining these two factors, the overall space complexity is `O(n)`, as we have to account for the space required by the function call stack during recursion.

By visiting each node once and accounting for the space required by the recursive call stack, the algorithm achieves `O(n)` time and `O(n)` space complexity.

