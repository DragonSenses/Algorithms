# 92. Reverse Linked List II

<p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 542px; height: 222px;" src="img/92-1.jpg">
<pre><strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
<strong>Output:</strong> [1,4,3,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [5], left = 1, right = 1
<strong>Output:</strong> [5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>n</code>.</li>
	<li><code>1 &lt;= n &lt;= 500</code></li>
	<li><code>-500 &lt;= Node.val &lt;= 500</code></li>
	<li><code>1 &lt;= left &lt;= right &lt;= n</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in one pass?

---

## **Problem Overview: Reverse Linked List II**

### Description
Given the `head` of a singly linked list and two integers `left` and `right` such that `1 <= left <= right <= n`, reverse the nodes of the list from position `left` to `right`, and return the modified list. This operation must be performed **in-place**, without creating new nodes for the reversed portion.

### Examples

#### Example 1:
**Input:**  
`head = [1,2,3,4,5]`, `left = 2`, `right = 4`  
**Output:**  
`[1,4,3,2,5]`  
**Explanation:**  
Only the sublist `[2,3,4]` is reversed to `[4,3,2]`.

#### Example 2:
**Input:**  
`head = [5]`, `left = 1`, `right = 1`  
**Output:**  
`[5]`  
**Explanation:**  
There is only one node; the list remains unchanged.

### Constraints
- The number of nodes in the list is `n`.
- `1 <= n <= 500`
- `-500 <= Node.val <= 500`
- `1 <= left <= right <= n`

### Follow-up
Can you perform the reversal in a **single traversal** of the list?