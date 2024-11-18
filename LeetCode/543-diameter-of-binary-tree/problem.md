# 543. Diameter of Binary Tree

<p>Given the <code>root</code> of a binary tree, return <em>the length of the <strong>diameter</strong> of the tree</em>.</p>

<p>The <strong>diameter</strong> of a binary tree is the <strong>length</strong> of the longest path between any two nodes in a tree. This path may or may not pass through the <code>root</code>.</p>

<p>The <strong>length</strong> of a path between two nodes is represented by the number of edges between them.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/543-1.jpg" style="width: 292px; height: 302px;">
<pre><strong>Input:</strong> root = [1,2,3,4,5]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 is the length of the path [4,2,1,3] or [5,2,1,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1,2]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<br>

---

# Solution
- [Depth-First Search (DFS) Approach](#depth-first-search-approach)

# Depth-First Search Approach

## **Intuition**

### **Understanding the Longest Path in a Tree**

#### **Leaf Nodes Definition**
- A leaf node is defined as any node with a degree of 1, including the root node if it has a degree of 1 or less.

#### **Key Observation**
- The longest path in a tree must be between two leaf nodes. 

**Proof by Contradiction**:
1. Assume the longest path is not between two leaf nodes.
2. We can extend this path by adding the child node of one of the end nodes (since they aren't both leaves, at least one must have a child).
3. This extension contradicts the assumption that our path is the longest.
4. Therefore, the longest path must be between two leaf nodes.

#### **Longest Path Structure**
- In a tree, each node is connected to its parent and up to two children.
- The longest path consists of a node, its longest left branch, and its longest right branch.
- To find the node where the sum of its longest left and right branches is maximized, we apply Depth-First Search (DFS).

#### **Depth-First Search (DFS) Approach**
- DFS is a common graph traversal algorithm. We use DFS to count each node's branch lengths, starting from the leaves and working upwards.
- If unfamiliar with DFS, refer to resources like Explore Cards to learn preorder, inorder, and postorder traversal.

### **Applying DFS to Find the Longest Path**

1. **Recursive Function `longestPath`**:
   - Input: A TreeNode
   - Output: The longest path from this node to a leaf node.
   - Approach: Recursively visit children nodes, retrieve the longest paths, and return the longer one plus one.

2. **Handling Special Cases in DFS**:
   - The longest path might include both left and right branches of the current node.
   - The longest path might include only one of the current node's left or right branches.

![Two cases of the longest path for a binary tree during Depth-First Search](img/543-2.jpg)

## **Algorithm**

**Algorithm to Find the Longest Path Using DFS:**

#### **Initialize Variables**
- **Diameter**: Initialize an integer variable `diameter` to keep track of the longest path found during the DFS traversal.

#### **Recursive Function `longestPath`**
- **Function Definition**: Implement a recursive function `longestPath` that takes a `TreeNode` as input and explores the entire tree rooted at the given node.

**Steps in `longestPath` Function**:
1. **Base Case**:
   - If the node is `None`, it means we have reached the end of the tree. Return `0`.

2. **Recursive Exploration**:
   - Recursively explore the left and right children of the node by calling `longestPath` on them.
   - Store the results in `leftPath` and `rightPath`.

3. **Update Diameter**:
   - If the sum of `leftPath` and `rightPath` is greater than the current longest diameter found, update the diameter.

4. **Return Value**:
   - Return the longer one of `leftPath` and `rightPath`. Add `1` to account for the edge connecting the node with its parent.

#### **Main Function**
- Call the `longestPath` function with the root node to start the DFS traversal and calculate the longest path.

### **Detailed Steps**

#### **Initialization**:
- `diameter = 0`: Keep track of the maximum diameter found during the DFS.

#### **Recursive Function**:

- **Base Case**: If the node is `None`, return `0`.

- **Recursive Calls**: Calculate the longest path of the left and right children.

- **Update Diameter**: Update the diameter if the current path is longer.

- **Return Statement**: Return the longer path plus `1`.

#### **Call the Recursive Function**:
- Begin the DFS traversal by calling `longestPath(root)`.

### **Pseudocode**

```plaintext
initialize diameter as 0

function longestPath(TreeNode node):
    if node is None:
        return 0
    leftPath = longestPath(node.left)
    rightPath = longestPath(node.right)
    diameter = max(diameter, leftPath + rightPath)
    return max(leftPath, rightPath) + 1

longestPath(root)
```

#### **Example Code**

```plaintext
function longestPath(TreeNode node):
    if node is null:
        return 0
    leftPath = longestPath(node.left)
    rightPath = longestPath(node.right)
    update longest path if leftPath + rightPath is greater
    return max(leftPath, rightPath) + 1
```
