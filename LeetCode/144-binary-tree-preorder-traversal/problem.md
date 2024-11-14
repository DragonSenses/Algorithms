# 144. Binary Tree Preorder Traversal

<p>Given the <code>root</code> of a binary tree, return <em>the preorder traversal of its nodes' values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,3]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="img/144-1.jpg" style="width: 200px; height: 264px;"></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,4,5,6,7,3,8,9]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="img/144-2.jpg" style="width: 350px; height: 286px;"></p>
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
<p><strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</p>

<br>

---

# Solution

- [Iterative Approach](#iterative-approach)
  - **Time Complexity**: `O(n)`
- [Recursive Approach](#recursive-approach)
  - **Time Complexity**: `O(n)`
- [Morris Traversal Approach](#morris-traversal-approach)
  - **Time Complexity**: `O(n)`

# Iterative Approach

## **Intuition**

To perform a preorder traversal of a binary tree iteratively, we can use a stack to mimic the behavior of the call stack in the recursive solution. In preorder traversal, we visit the root node first, then the left subtree, and finally the right subtree. By using a stack, we can ensure that we access nodes in this order.

Since stacks follow a last-in-first-out order, we need to push the right child onto the stack first, and then the left child. This ensures that when we pop nodes from the stack, we process the left child before the right child.

![Depth-First Search Iterative Binary Tree Preorder Traversal](img/144-5.jpg)

## **Algorithm**

1. Initialize an empty array `answer` to store the preorder traversal.
2. Initialize an empty stack `stack`.
3. Add the `root` node to the `stack`.
4. While the `stack` is not empty, do the following:
   - Pop the top node `currNode` from the `stack`.
   - If `currNode` is not `null`:
     - Add `currNode`'s value to the `answer`.
     - Push `currNode`'s right child onto the `stack`.
     - Push `currNode`'s left child onto the `stack`.
5. Repeat step 4 until the `stack` is empty.
6. Return `answer` after the `stack` is empty.

### Example

Let's go through an example with the input `root = [1, null, 2, 3]`.

1. **Initialization**:
   - `answer = []`
   - `stack = [1]`

2. **First iteration**:
   - Pop `1` from the stack: `stack = []`
   - Add `1` to `answer`: `answer = [1]`
   - Push `2` (right child of `1`) onto the stack: `stack = [2]`

3. **Second iteration**:
   - Pop `2` from the stack: `stack = []`
   - Add `2` to `answer`: `answer = [1, 2]`
   - Push `3` (left child of `2`) onto the stack: `stack = [3]`

4. **Third iteration**:
   - Pop `3` from the stack: `stack = []`
   - Add `3` to `answer`: `answer = [1, 2, 3]`

The stack is now empty, so we return `answer = [1, 2, 3]`.

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    if (root != null) {
      stack.push(root);
    }

    while (!stack.isEmpty()) {
      TreeNode currNode = stack.pop();
      if (currNode != null) {
        answer.add(currNode.val);
        if (currNode.right != null) {
          stack.push(currNode.right);
        }
        if (currNode.left != null) {
          stack.push(currNode.left);
        }
      }
    }

    return answer;
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

function preorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];
  const stack: (TreeNode | null)[] = [];

  if (root !== null) {
    stack.push(root);
  }

  while (stack.length > 0) {
    const currNode = stack.pop();
    if (currNode !== null) {
      answer.push(currNode.val);
      if (currNode.right !== null) {
        stack.push(currNode.right);
      }
      if (currNode.left !== null) {
        stack.push(currNode.left);
      }
    }
  }

  return answer;
}
```

## **Complexity Analysis**

Let `n` be the number of nodes in the tree.

### **Time Complexity**: `O(n)`

- **Stack Operations**: We use a stack to store all nodes to be visited. Each of the `n` nodes is added to and popped from the stack once, which takes `O(1)` time.
  - **Key Point**: Adding and removing each node from the stack is done in constant time.

- **Node Processing**: All other work done at each node is `O(1)`, so the overall time complexity is `O(n)`.
  - **Key Point**: Each node is processed once, and the operations performed at each node (like adding its value to the answer list) are constant time operations.

### **Space Complexity**: `O(n)`

- **Stack Usage**: We use a stack to store all the nodes to be visited. Similar to the previous approach, the stack takes up space equivalent to the depth of the tree. The max depth of the tree could be `O(n)` in the worst-case scenario when the tree is skewed.
  - **Key Point**: In the worst case of a skewed tree, the stack could grow to contain all `n` nodes, leading to a linear space complexity.

# Recursive Approach

## **Intuition**

In a preorder traversal, we visit the root node first, then recursively traverse the left subtree, and finally the right subtree. The key idea is to handle the root node and then recursively solve for its left and right subtrees. This method follows a depth-first search (DFS) approach.

![Depth-First Search Recursive Binary Tree Preorder Traversal where left and right subtrees are subproblems to be recursively solved](img/144-3.jpg)
![Depth-First Search Recursive Binary Tree Preorder Traversal steps](img/144-4.jpg)

## **Algorithm**

1. Initialize an empty list `answer` to store the preorder traversal.
2. Define a recursive helper function `preorder(node)` that:
   - If `node` is `null`, return.
   - Add the value of `node` to `answer`.
   - Recursively call `preorder(node.left)` to traverse the left subtree.
   - Recursively call `preorder(node.right)` to traverse the right subtree.
3. Call the helper function `preorder` starting from the `root` node.
4. Return the `answer` list containing the preorder traversal.

### Pseudocode

```plaintext
function preorderTraversal(root): answer = []

function preorder(node): if node is null: return answer.append(node.val) preorder(node.left) preorder(node.right)

preorder(root) return answer
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  /**
   * Method to perform a recursive preorder traversal of a binary tree.
   * 
   * @param root The root node of the binary tree.
   * @return A list of integers representing the preorder traversal.
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    preorder(root, answer);
    return answer;
  }

  /**
   * Helper method to perform the preorder traversal recursively.
   * 
   * @param node   The current node being visited.
   * @param answer The list storing the preorder traversal result.
   */
  private void preorder(TreeNode node, List<Integer> answer) {
    if (node == null) {
      return;
    }
    answer.add(node.val);
    preorder(node.left, answer);
    preorder(node.right, answer);
  }
}
```

### TypeScript

```ts
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
 * Performs a recursive preorder traversal of a binary tree.
 * 
 * @param root - The root node of the binary tree.
 * @returns An array of numbers representing the preorder traversal.
 */
function preorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];

  /**
   * Helper function to perform the preorder traversal recursively.
   * 
   * @param node - The current node being visited.
   */
  function preorder(node: TreeNode | null): void {
    if (node === null) {
      return;
    }
    answer.push(node.val);
    preorder(node.left);
    preorder(node.right);
  }

  preorder(root);
  return answer;
}
```

## **Complexity Analysis**

Let `n` be the number of nodes in the tree.

### **Time Complexity**: `O(n)`

- **Single Pass**: We visit each node once and perform a constant amount of work at each node.
  - Summary: `O(1)` work per node.

### **Space Complexity**: `O(n)`

- **Recursive Call Stack**: The space is taken up by the recursive call stack.
  - Key Point: The recursion internally uses a call stack that takes up space equivalent to the depth of the tree.
  - Summary: Depth of the tree dictates the space complexity.
- **Worst-Case Scenario**: The max depth of the tree could be `O(n)` when the tree is skewed.
  - Summary: Worst-case space complexity is linear.

# Morris Traversal Approach

The Morris Traversal is a method for traversing a binary tree using only constant space. Traditionally, tree traversals require O(n) space to maintain a stack or recursion stack. The Morris Traversal modifies the tree in place to avoid using extra space. The idea is to link the rightmost node of a node's left subtree to the node itself, creating a temporary "thread". This allows us to traverse back to a node after finishing its left subtree, enabling a traversal without extra space.

**Interview Note:** This approach is an extension and wouldn't be expected to come up in an interview.

## **Intuition**

Here we briefly introduce the Morris Traversal which only takes constant space.

Recall the previous solutions which have `O(n)` space complexity, let's think about why we need that much space:

Imagine we are in the middle of a traversal, and the current root node `root` has left and right subtrees. As we finish visiting the last node last of the left subtree, we would like to continue visiting the right subtree of `root` , but how?

![](img/144-6.jpg)

This approach takes `O(n)` space because we need to track all the previous root nodes so that we can always return to each root and visit the right child once we have finished visiting its left child.

We can modify the tree in place instead of using extra space. Note that the `last` node has no right child, so we can `let` root be its right child. Therefore, whenever we finished visiting `last`, we can just visit its right child and return to `root`.

![](img/144-7.jpg)

For each unvisited node `curr` , we can find the `last` node if it exists, so once we finish iterating over the left subtree, we can always return to `curr` by visiting `last.right`.

![](img/144-8.jpg)

Take the following figure as an example of how we can calculate the preorder traversal of `root` using the Morris Traversal Approach and only taking constant space.

![](img/144-9.jpg)


## **Algorithm**

1. Initialize an empty list `answer` to store the preorder traversal.
2. Set `curr` to the root node.
3. While `curr` is not null:
   - If `curr` has no left child:
     - Add `curr`'s value to `answer`.
     - Move to `curr`'s right child (`curr = curr.right`).
   - Otherwise:
     - Find the rightmost node in `curr`'s left subtree (`last`).
     - If `last`'s right is null:
       - Set `last`'s right to `curr` (create a temporary thread).
       - Add `curr`'s value to `answer`.
       - Move to `curr`'s left child (`curr = curr.left`).
     - If `last`'s right is `curr`:
       - Remove the temporary thread (`last.right = null`).
       - Move to `curr`'s right child (`curr = curr.right`).
4. Return `answer`.

### Pseudocode

```plaintext
function morrisPreorderTraversal(root):
    answer = []
    curr = root

    while curr is not null:
        if curr.left is null:
            answer.append(curr.val)
            curr = curr.right
        else:
            last = curr.left
            while last.right is not null and last.right is not curr:
                last = last.right

            if last.right is null:
                last.right = curr
                answer.append(curr.val)
                curr = curr.left
            else:
                last.right = null
                curr = curr.right

    return answer
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

  /**
   * Method to perform a Morris preorder traversal of a binary tree.
   * 
   * @param root The root node of the binary tree.
   * @return A list of integers representing the preorder traversal.
   */
  public List<Integer> morrisPreorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null) {
      if (curr.left == null) {
        answer.add(curr.val);
        curr = curr.right;
      } else {
        TreeNode last = curr.left;
        while (last.right != null && last.right != curr) {
          last = last.right;
        }

        if (last.right == null) {
          last.right = curr;
          answer.add(curr.val);
          curr = curr.left;
        } else {
          last.right = null;
          curr = curr.right;
        }
      }
    }

    return answer;
  }
}
```

## **Complexity Analysis**

Let `n` be the number of nodes in the tree.

### **Time Complexity**: `O(n)`

- **Traversal**: Each edge in the tree is visited at most twice: once to find the `last` node and once when traversing nodes.
  - This ensures every node is processed efficiently, resulting in `O(n)` time complexity.

- There are `n - 1` edges in a tree (by definition). Each edge is visited at most two times: first, when we find `last` and second when we traverse the nodes.

- We visited each node at most 2 times, which takes `O(n)` time. Refer to the picture below, the colored edges
stand for the revisited edges when finding the 'last' nodes.

![](img/144-10.jpg)

- When visisting each node, other than traversing edges we do `O(1)` work, so the time complexity is `O(n)`

### **Space Complexity**: `O(1)`

- **Efficient Space Usage**: Morris Traversal modifies the tree in place and uses only two pointers (`curr` and `last`), thus requiring constant space.
  - By leveraging the tree's structure and creating temporary threads, the traversal is achieved without additional memory overhead.
  - The algorithm uses constant space because it does not rely on additional data structures like stacks or queues.

Morris Traversal achieves an efficient traversal with `O(n)` time complexity and `O(1)` space complexity.
