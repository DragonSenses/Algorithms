# 230. Kth Smallest Element in a BST

<p>Given the <code>root</code> of a binary search tree, and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>smallest value (<strong>1-indexed</strong>) of all the values of the nodes in the tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 212px; height: 301px;" src="img/230-1.jpg">
<pre><strong>Input:</strong> root = [3,1,4,null,2], k = 1
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 382px; height: 302px;" src="img/230-2.jpg">
<pre><strong>Input:</strong> root = [5,3,6,2,4,null,null,1], k = 3
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the tree is <code>n</code>.</li>
  <li><code>1 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li>
  <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?</p>

# Problem Overview: Kth Smallest Element in a BST

## Description

Given the `root` of a Binary Search Tree (BST) and an integer `k`, the task is to return the `k`th smallest value (1-indexed) among all the node values in the tree.

A BST is a binary tree in which for every node:
- The left subtree contains only nodes with values less than the node’s value.
- The right subtree contains only nodes with values greater than the node’s value.

This property allows for efficient in-order traversal to retrieve sorted node values.

## Examples

### Example 1

**Input:**  
`root = [3,1,4,null,2]`, `k = 1`  
**Output:**  
`1`  

### Example 2

**Input:**  
`root = [5,3,6,2,4,null,null,1]`, `k = 3`  
**Output:**  
`3`  

## Constraints

- The number of nodes in the tree is `n`.
- \( 1 \leq k \leq n \leq 10^4 \)
- \( 0 \leq \text{Node.val} \leq 10^4 \)

## Follow-Up

If the BST is frequently modified (insertions and deletions), and you need to find the kth smallest element often, consider optimizing with one of the following strategies:

- **Augmented BST:** Store the size of each subtree at every node to allow O(log n) kth smallest queries.
- **Balanced BST with Order Statistics:** Use data structures like AVL trees or Red-Black trees augmented with subtree sizes.
- **Segment Trees or Binary Indexed Trees (Fenwick Trees):** Useful if values are bounded and frequency-based queries are needed.
