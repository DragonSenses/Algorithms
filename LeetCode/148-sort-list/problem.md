# 148. Sort List

<p>Given the <code>head</code> of a linked list, return <em>the list after sorting it in <strong>ascending order</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/148-1.jpg" style="width: 450px; height: 194px;">
<pre><strong>Input:</strong> head = [4,2,1,3]
<strong>Output:</strong> [1,2,3,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="img/148-2.jpg" style="width: 550px; height: 184px;">
<pre><strong>Input:</strong> head = [-1,5,3,4,0]
<strong>Output:</strong> [-1,0,3,4,5]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the list is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li>
  <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you sort the linked list in <code>O(n logn)</code> time and <code>O(1)</code> memory (i.e. constant space)?</p>

<br>

---

# Solution
- [Merge Sort Top Down Approach]()

# Merge Sort Top Down Approach

## Intuition

Merge sort is a well-known algorithm that follows the Divide and Conquer strategy. This strategy can be split into two main phases:

1. **Divide Phase**: Divide the problem into smaller subproblems.
2. **Conquer Phase**: Repeatedly solve each subproblem independently and combine the results to form the original problem.

In the Top-Down approach for merge sort:
- The original list is recursively split into sublists of equal sizes.
- Each sublist is sorted independently.
- The sorted sublists are eventually merged back together.

Let's look at the algorithm to implement merge sort in the Top-Down fashion.

## **Algorithm**

1. **Recursively Split the List**:
    - Recursively split the original list into two halves. This splitting continues until there is only one node in each linked list (Divide Phase).
    - To split the list into two halves, find the middle of the linked list using the Fast and Slow pointer approach.

2. **Merge Sorted Sublists**:
    - Recursively sort each sublist and combine them into a single sorted list (Merge Phase).
    - This is similar to merging two sorted linked lists.

The process continues until we get the original list in sorted order.

### Detailed Steps:
1. **Base Case**: If the list is empty or has only one node, it's already sorted.
2. **Find the Middle**: Use the Fast and Slow pointer approach to find the middle of the list.
3. **Split the List**: Split the list into two halves from the middle.
4. **Recursively Sort**: Recursively sort each half.
5. **Merge**: Merge the two sorted halves into a single sorted list.

### Example Walkthrough:

For the linked list [10, 1, 60, 30, 5]:

1. **Initial List**: `[10, 1, 60, 30, 5]`
2. **Divide Phase**:
    - Split into `[10, 1, 60]` and `[30, 5]`
    - Further split `[10, 1, 60]` into `[10, 1]` and `[60]`
    - Split `[10, 1]` into `[10]` and `[1]`
3. **Conquer Phase**:
    - Merge `[10]` and `[1]` to form `[1, 10]`
    - Merge `[1, 10]` and `[60]` to form `[1, 10, 60]`
    - Merge `[30]` and `[5]` to form `[5, 30]`
4. **Merge Sorted Sublists**:
    - Merge `[1, 10, 60]` and `[5, 30]` to form `[1, 5, 10, 30, 60]`

