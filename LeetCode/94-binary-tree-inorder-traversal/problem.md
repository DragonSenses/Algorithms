# 94. Binary Tree Inorder Traversal

<p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes' values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="img/94-1.jpg" style="width: 200px; height: 264px;"></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,2,6,5,7,1,3,9,8]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="img/94-2.jpg" style="width: 350px; height: 286px;"></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = []</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

<br>

---

# Solution

- [Recursive Approach](#recursive-approach)
  - **Time Complexity**: `O(n)`
- [Iterative Approach](#iterative-approach)
  - **Time Complexity**: `O(n)`
- [Morris Traversal for In-Order Traversal](#morris-traversal-for-in-order-traversal)
  - **Time Complexity**: `O(n)`
- [Comparison: Iterative vs. Recursive In-Order Traversal](#comparison-iterative-vs-recursive-in-order-traversal)

## Binary Tree Overview

**Key Points**:

- **Root Node**: The topmost node of the tree.
- **Child Nodes**: Each node can have up to two children, referred to as the left and right child.
- **Leaf Nodes**: Nodes with no children.
- **Depth/Height**: The length of the path from the root to the deepest leaf node.
- **Binary Search Tree (BST)**: A special type of binary tree where the left child's value is less than the parent's value, and the right child's value is greater than the parent's value.
- **Traversal Methods**: Methods to visit nodes in a binary tree, including In-order, Pre-order, and Post-order.

### Binary Tree in Array Form

A binary tree can be represented using an array, where the array elements correspond to the nodes of the tree. This representation is particularly useful for complete binary trees.

Representing a binary tree in array form is a simple and efficient method for complete binary trees. It leverages the properties of array indexing to quickly access parent and child nodes, making it suitable for certain applications where the tree structure is predictable and does not change dynamically.

#### Key Points:

1. **Root Node**:
   - The root node of the binary tree is stored at index 0 of the array.

2. **Left Child**:
   - For a node at index `i`, its left child is located at index `2i + 1`.

3. **Right Child**:
   - For a node at index `i`, its right child is located at index `2i + 2`.

4. **Parent Node**:
   - For a node at index `i`, its parent is located at index `(i - 1) / 2`.

#### Example:

Consider the following binary tree:

```code
      1
    /   \
   2     3
  / \   / \
 4   5 6   7
```

This binary tree can be represented in an array as:

```code
[1, 2, 3, 4, 5, 6, 7]
```

#### Detailed Explanation:

1. **Index 0**: The root node `1` is stored at index `0`.
2. **Indices 1 & 2**: The left child `2` and right child `3` of the root node are stored at indices `1` and `2` respectively.
3. **Indices 3 & 4**: The left child `4` and right child `5` of node `2` are stored at indices `3` and `4` respectively.
4. **Indices 5 & 6**: The left child `6` and right child `7` of node `3` are stored at indices `5` and `6` respectively.

#### Benefits:

- **Memory Efficiency**: For complete binary trees, this representation avoids the need for storing pointers to child nodes.
- **Ease of Access**: It allows for direct access to nodes using array indexing, which can simplify algorithms for traversal and manipulation.

#### Limitations:

- **Sparse Trees**: For binary trees that are not complete, this representation may lead to wasted space in the array.
- **Fixed Size**: The size of the array needs to be known in advance, which can be a limitation for dynamically growing trees.

# Recursive Approach

## **Intuition**

In an in-order traversal, we recursively visit the left subtree, then the root node, and finally the right subtree. The key idea is to recursively solve for the left subtree first, then handle the root node, and finally recursively solve for the right subtree.

## **Algorithm**

1. Initialize an empty list `answer` to store the in-order traversal.
2. Define a recursive helper function `inorder(node)` that:
   - If `node` is `null`, return.
   - Recursively call `inorder(node.left)` to traverse the left subtree.
   - Add the value of `node` to `answer`.
   - Recursively call `inorder(node.right)` to traverse the right subtree.
3. Call the helper function `inorder` starting from the `root` node.
4. Return the `answer` list containing the in-order traversal.

### Pseudocode

```plaintext
function inorderTraversal(root):
    answer = []

    function inorder(node):
        if node is null:
            return
        inorder(node.left)
        answer.append(node.val)
        inorder(node.right)

    inorder(root)
    return answer
```

## **Implementation**

#### Implementation Details

- **Initialization**: Initialize an empty `ArrayList` to store the in-order traversal result.

- **Recursive Helper Function**: The `inorder` function recursively traverses the left subtree, adds the current node's value to the `answer` list, and then traverses the right subtree.

- **Start Traversal**: The traversal starts with the root node by calling `inorder(root, answer)`.

- **Return Result**: Finally, the list containing the in-order traversal result is returned.

##### Binary Tree Definition

```java
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

```typescript
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
```

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    inorder(root, answer);
    return answer;
  }

  private void inorder(TreeNode node, List<Integer> answer) {
    if (node == null) {
      return;
    }

    inorder(node.left, answer);
    answer.add(node.val);
    inorder(node.right, answer);
  }
}
```

### TypeScript

```typescript
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

function inorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];

  function inorder(node: TreeNode | null): void {
    if (node === null) {
      return;
    }
    inorder(node.left);  // Visit left subtree first
    answer.push(node.val);  // Visit root node
    inorder(node.right);  // Visit right subtree last
  }

  inorder(root);
  return answer;
};
```

## **Complexity Analysis**

Let `n` be the number of nodes in the tree.

### **Time Complexity**: `O(n)`

- **Single Pass**: Each node is visited exactly once, and constant work is performed at each node.
- **Explanation**: Since the traversal visits each node exactly once, the total time taken is proportional to the number of nodes in the tree.
- **Master's Theorem Notation**: The recurrence relation for this recursive function is `T(n) = 2 * T(n/2) + 1`, which simplifies to `O(n)`.

### **Space Complexity**: `O(n)`

- **Recursive Call Stack**: The space required is proportional to the maximum depth of the recursion stack.
  - **Depth of the Tree**: The recursion internally uses a call stack that takes up space equivalent to the depth of the tree.
- **Average-Case**: `O(log n)` when the tree is balanced.
- **Worst-Case Scenario**: `O(n)` when the tree is skewed (either left or right).

#### **Summary**
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)` (worst-case), `O(log n)` (average-case for balanced trees)

# Iterative Approach

## **Intuition**

To perform an in-order traversal of a binary tree iteratively, we can use a stack to simulate the recursive traversal process. In in-order traversal, we visit the left subtree first, then the root node, and finally the right subtree. By using a stack, we can ensure that nodes are visited in this order without using recursion.

### **Algorithm**

1. Initialize an empty list `result` to store the in-order traversal.
2. Initialize an empty stack `stack` to aid in traversal.
3. Set `current` to the root node.
4. While `current` is not `null` or the `stack` is not empty:
   - While `current` is not `null`:
     - Push `current` onto the stack.
     - Move to the left child of `current`.
   - Pop an element from the stack, set it as `current`.
   - Add the value of `current` to `result`.
   - Move to the right child of `current`.
5. Return the `result` list containing the in-order traversal.

### **Pseudocode**

```plaintext
function inorderTraversal(root):
    result = []
    stack = []
    current = root

    while current is not null or stack is not empty:
        while current is not null:
            stack.push(current)
            current = current.left

        current = stack.pop()
        result.append(current.val)
        current = current.right

    return result
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Solution class to perform an iterative in-order traversal of a binary tree.
 */
public class Solution {

  /**
   * Performs in-order traversal of a binary tree.
   * 
   * @param root The root of the binary tree.
   * @return A list containing the in-order traversal of the tree.
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      // Traverse the left subtree
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      // Visit the node
      current = stack.pop();
      result.add(current.val);

      // Traverse the right subtree
      current = current.right;
    }

    return result;
  }
}
```

### TypeScript

```typescript
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
 * Performs in-order traversal of a binary tree.
 * @param root - The root of the binary tree.
 * @returns An array containing the in-order traversal of the tree.
 */
function inorderTraversal(root: TreeNode | null): number[] {
  const result: number[] = [];
  const stack: TreeNode[] = [];
  let current: TreeNode | null = root;

  while (current !== null || stack.length > 0) {
    // Traverse the left subtree
    while (current !== null) {
      stack.push(current);
      current = current.left;
    }

    // Visit the node
    current = stack.pop()!;
    result.push(current.val);

    // Traverse the right subtree
    current = current.right;
  }

  return result;
};
```

## **Complexity Analysis**

Let `n` be the number of nodes in the tree.

### **Time Complexity**: `O(n)`

- **Single Pass**: Each node in the tree is visited exactly once during the traversal.
- **Explanation**: The while loop ensures that each node is pushed onto the stack once and popped from the stack once. Thus, the time taken is proportional to the number of nodes in the tree.

### **Space Complexity**: `O(n)`

- **Auxiliary Stack Space**: The space required is proportional to the maximum depth of the stack.
  - **Worst-Case Scenario**: In the worst-case scenario, the tree is skewed (either left or right), and the depth of the tree (and thus the stack) is `n`, leading to `O(n)` space complexity.
  - **Balanced Tree**: In a balanced binary tree, the height of the tree is `O(log n)`, which would result in an average space complexity of `O(log n)`. However, we consider the worst-case scenario for space complexity analysis.
- **Result List**: An additional space of `O(n)` is required to store the traversal result.

#### **Summary**
- **Time Complexity**: `O(n)`
  - Each node is processed once.
- **Space Complexity**: `O(n)`
  - Worst-case due to the depth of the stack, especially in skewed trees.

## **Comparison: Iterative vs. Recursive In-Order Traversal**

### **Advantages of the Iterative Approach**

1. **Space Efficiency**:
   - **Reduced Call Stack**: The iterative approach does not rely on the call stack to handle recursion. Instead, it uses an explicit stack (usually implemented with a data structure like an array or a stack). This can save space, especially for trees with a large depth.
   - **Controlled Memory Usage**: In deeply nested recursive calls, the call stack can grow significantly and might lead to a stack overflow. The iterative approach mitigates this risk by controlling memory usage.

2. **Performance Consistency**:
   - **Avoid Stack Overflow**: For very deep or unbalanced trees, recursive calls can result in a stack overflow due to the limited size of the call stack. The iterative approach avoids this issue by using a manually managed stack.
   - **Predictable Space Complexity**: While the worst-case space complexity of an iterative approach can still be `O(n)` for skewed trees, it is often more predictable and manageable compared to the call stack growth in recursion.

3. **Easier Debugging**:
   - **Step-by-Step Execution**: Iterative code can be easier to debug and trace since it explicitly shows the state changes of variables and the stack at each step.
   - **Readability and Maintenance**: For some developers, iterative code might be easier to read and maintain, especially when dealing with languages that lack optimized recursion handling.

### **Comparison Example**

#### **Recursive Approach**:
- **Space Complexity**: `O(n)` in the worst case due to the call stack.
- **Risk**: Potential stack overflow for deep trees.

#### **Iterative Approach**:
- **Space Complexity**: `O(n)` in the worst case due to the auxiliary stack.
- **Benefit**: Avoids stack overflow, more predictable memory usage, and easier debugging.

### **Conclusion**

While the recursive approach is often more elegant and easier to implement for tree traversal problems, the iterative approach provides better control over memory usage and avoids the risks associated with deep recursion. It can be particularly useful in environments with limited stack space or when dealing with very large and unbalanced trees.

# **Morris Traversal for In-Order Traversal**

## **Intuition**

The Morris Traversal algorithm modifies the tree structure during the traversal to create temporary links (threads) that allow it to traverse the tree in-order without using additional space. The key idea is to find the inorder predecessor of the current node and establish a temporary thread from the predecessor to the current node. This allows us to return to the current node after finishing the left subtree traversal.

## **Algorithm**

1. Initialize `current` to the root of the tree.
2. While `current` is not `null`:
   - If `current` has no left child:
     - Visit `current` (add its value to the result).
     - Move to the right child of `current`.
   - Else:
     - Find the inorder predecessor of `current` (rightmost node in the left subtree of `current`).
     - If the predecessor's right child is `null`:
       - Set the predecessor's right child to `current` (create a thread).
       - Move to the left child of `current`.
     - Else (the thread already exists):
       - Remove the thread (set the predecessor's right child to `null`).
       - Visit `current` (add its value to the result).
       - Move to the right child of `current`.
3. Return the result containing the in-order traversal.

### **Pseudocode**

```plaintext
function morrisTraversal(root):
    result = []
    current = root

    while current is not null:
        if current.left is null:
            result.append(current.val)
            current = current.right
        else:
            predecessor = current.left
            while predecessor.right is not null and predecessor.right is not current:
                predecessor = predecessor.right

            if predecessor.right is null:
                predecessor.right = current
                current = current.left
            else:
                predecessor.right = null
                result.append(current.val)
                current = current.right

    return result
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;

    while (current != null) {
      if (current.left == null) {
        result.add(current.val);
        current = current.right;
      } else {
        TreeNode predecessor = current.left;
        while (predecessor.right != null && predecessor.right != current) {
          predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
          predecessor.right = current;
          current = current.left;
        } else {
          predecessor.right = null;
          result.add(current.val);
          current = current.right;
        }
      }
    }

    return result;
  }
}
```

### TypeScript

```typescript
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function inorderTraversal(root: TreeNode | null): number[] {
  const result: number[] = [];
  let current: TreeNode | null = root;

  while (current !== null) {
    if (current.left === null) {
      result.push(current.val);
      current = current.right;
    } else {
      let predecessor = current.left;
      while (predecessor.right !== null && predecessor.right !== current) {
        predecessor = predecessor.right;
      }

      if (predecessor.right === null) {
        predecessor.right = current;
        current = current.left;
      } else {
        predecessor.right = null;
        result.push(current.val);
        current = current.right;
      }
    }
  }

  return result;
}
```

## **Complexity Analysis**

#### **Time Complexity**: `O(n)`

- **Traversal Process**: Each node is visited at most twice (once to create a thread and once to remove it).
- **Reasoning**: The while loop ensures that each node is processed for creating and removing threads, leading to a total time complexity of `O(n)`.

#### **Space Complexity**: `O(1)`

- **Auxiliary Space**: No additional space is used apart from a few pointers.
  - **Reasoning**: Morris Traversal modifies the tree temporarily to create threads, thus not using extra space for recursion or a stack.
- **Result List**: An additional space of `O(n)` is required to store the traversal result.

#### **Summary**
- **Time Complexity**: `O(n)`
  - Each node is processed at most twice.
- **Space Complexity**: `O(1)` (excluding the result list)
  - Minimal extra space is used due to the threaded binary tree approach.
