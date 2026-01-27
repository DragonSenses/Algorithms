# 297. Serialize and Deserialize Binary Tree

<p>Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.</p>

<p>Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.</p>

<p><strong>Clarification:</strong> The input/output format is the same as how LeetCode serializes a binary tree (see below example). You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 442px; height: 324px;" src="img/297-1.jpg">
<pre><strong>Input:</strong> root = [1,2,3,null,null,4,5]
<strong>Output:</strong> [1,2,3,null,null,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

<strong>Serialized Format:</strong>
<ul style="padding-left: 0px; margin-top: 2px;">
<li>
<div>
<code>[1, null, 2, 3]</code> is <strong>not</strong> an array but a way to represent a binary tree in a printable format using <strong>level order traversal</strong>. In level order traversal, the tree is traversed level by level, from top to bottom and left to right.</div>
</li>
<li>
<div>The <code>null</code> value is used to indicate where a node is missing in the tree. It shows that there is no node present in that position, which helps you understand the overall shape of the tree, especially when some branches are incomplete.</div>
</li>
<li>
<div>
<code>[]</code> is not an empty array but represents an empty binary tree, where the root is a reference to <code>NULL</code> (C/C++), <code>null</code> (Java/C#/JavaScript), <code>None</code> (Python), or <code>nil</code> (Ruby).</div>
</li>
</ul>
<p><strong>Note:</strong> Always use the provided <code>TreeNode</code> class/type, and do not define it yourself.</p>

---

## **Problem Overview: Serialize and Deserialize Binary Tree**

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

## Examples

* Example 1:

  ```
  Input: root = [1,2,3,null,null,4,5]
  Output: [1,2,3,null,null,4,5]
  ```

* Example 2:

  ```
  Input: root = []
  Output: []
  ```

## Constraints

Constraints:

  * The number of nodes in the tree is in the range [0, 104].
  * -1000 <= `Node.val` <= 1000

### Problem Essence  
You must design a reversible encoding for a binary tree. The serialized form must contain enough structure information to reconstruct the exact original tree, including null children. There is no required format; any representation is valid as long as serialization and deserialization are inverses.

Two broad strategies dominate:  
1. **Preorder DFS with null markers**  
2. **Level‑order BFS with null markers**

Both approaches rely on the same principle:  
A binary tree cannot be reconstructed from values alone; you must encode structure explicitly. Null placeholders are the simplest way to preserve shape.

### Key Requirements  
- Handle empty trees.  
- Support up to 10⁴ nodes efficiently.  
- Node values range from −1000 to 1000.  
- Output must be a string; input to deserializer is that same string.  
- The reconstructed tree must be structurally identical to the original.

### Why Null Markers Matter  
Consider the tree:

```
    1
   / \
  2   3
     / \
    4   5
```

If you only serialize values, you lose the fact that 2 has no children and 3 has two. Null markers preserve this:

```
1,2,null,null,3,4,null,null,5,null,null
```

This is a preorder DFS representation.

