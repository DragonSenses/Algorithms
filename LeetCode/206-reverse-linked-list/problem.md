# 206. Reverse Linked List

<p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 542px; height: 222px;" src="img/206-1.jpg">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [5,4,3,2,1]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 182px; height: 222px;" src="img/206-2.jpg">
<pre><strong>Input:</strong> head = [1,2]
<strong>Output:</strong> [2,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
  <li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>


---

# Solution

- [Recursive Approach](#recursive-approach)

---

## **Problem Overview: Reverse Linked List**

## Problem Statement
Given the `head` of a singly linked list, reverse the list and return the new head of the reversed list.

This task involves in-place manipulation of the list's pointers to reverse its order.

## Input
- A singly linked list represented by its head node.
- Each node contains:
  - An integer value: `Node.val`
  - A reference to the next node: `Node.next`

## Output
- The head node of the reversed list.

## Examples

| Input List        | Reversed Output |
|------------------|-----------------|
| [1, 2, 3, 4, 5]   | [5, 4, 3, 2, 1] |
| [1, 2]            | [2, 1]          |
| []                | []              |

## Constraints
- Number of nodes: `0 <= n <= 5000`
- Node values: `-5000 <= Node.val <= 5000`

## Follow-up Challenge
Implement two versions:
- Iterative reversal using pointer manipulation
- Recursive reversal using the call stack

## Tip
Redirect each node's `.next` pointer to reverse the chain, being mindful of edge cases like an empty list or a single node.

---

# Recursive Approach

## **Intuition**

The recursive strategy treats the problem as breaking down the list into smaller sublists. We recurse to the end of the list, then rewire the pointers on the way back. Each recursive call returns the reversed head of the sublist that starts at the next node, allowing the current node to link itself to the end of this reversed sublist.  
Think of it as a stack of deferred operations: we only start rewiring when we've hit the base case — an empty list or a single node.

## **Algorithm**

1. Base Case: If `head` is `null` or only one node, return `head` — nothing to reverse.
2. Recurse on `head.next` — get the reversed sublist starting from the next node.
3. After recursion, the `head.next` node is at the tail of the reversed sublist.
4. Set `head.next.next = head` to reverse the link.
5. Set `head.next = null` to break the old forward link.
6. Return the new head of the reversed list.

### **Pseudocode**

```plaintext
function reverseList(node):
 if node is null or node.next is null: return node

 reversedHead = reverseList(node.next)
 node.next.next = node
 node.next = null

return reversedHead
```

## **Implementation**

### Java

```java
class Solution {
  public ListNode reverseList(ListNode head) {
    // Base case: empty list or single node — already reversed
    if (head == null || head.next == null) {
      return head;
    }

    // Recurse on the rest of the list
    ListNode reversedHead = reverseList(head.next);

    // Make the following node point back to current head
    head.next.next = head;

    // Disconnect current head from the rest of the list
    head.next = null;

    // Return new head found at the tail of the original list
    return reversedHead;
  }
}
```
