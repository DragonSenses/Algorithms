# 61. Rotate List

<p>Given the <code>head</code> of a linked&nbsp;list, rotate the list to the right by <code>k</code> places.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 450px; height: 191px;" src="img/61-1.jpg">
<pre><strong>Input:</strong> head = [1,2,3,4,5], k = 2
<strong>Output:</strong> [4,5,1,2,3]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 305px; height: 350px;" src="img/62-2.jpg">
<pre><strong>Input:</strong> head = [0,1,2], k = 4
<strong>Output:</strong> [2,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the list is in the range <code>[0, 500]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
  <li><code>0 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
</ul>

---

# Solution

- [Circular Linked List Approach](#circular-linked-list-approach)
  - **Space Complexity**: `O(1)`

### Problem Overview: Rotate List

This problem involves manipulating a **singly linked list**. You are provided with the head of a linked list, and your task is to **rotate the list to the right by `k` places**. The rotation implies moving elements from the tail of the list to the head, maintaining the relative order of the rest of the elements.

#### Key Points:
1. **Inputs:**
   - `head`: The head node of a singly linked list.
   - `k`: The number of positions to rotate the list.

2. **Outputs:**
   - A singly linked list after being rotated right by `k` positions.

#### Example Walkthrough:
- **Example 1**:  
  **Input**: `head = [1,2,3,4,5], k = 2`  
  **Output**: `[4,5,1,2,3]`  
  Explanation: The last two nodes (`4` and `5`) are moved to the front of the list.

- **Example 2**:  
  **Input**: `head = [0,1,2], k = 4`  
  **Output**: `[2,0,1]`  
  Explanation: The list rotates once entirely (`k = 3` would restore the original list), and one additional rotation shifts `2` to the front.

#### Constraints:
- The number of nodes in the linked list: `0 ≤ n ≤ 500`.
- Node values range from `-100 ≤ Node.val ≤ 100`.
- `0 ≤ k ≤ 2 * 10⁹` (which may necessitate handling large values of `k` efficiently by reducing unnecessary rotations).

#### Challenges in Implementation:
- **Handling Edge Cases**:  
  - Empty list (`head == null` or `n == 0`).  
  - Single-node list (`n == 1` or `k == 0`).  
  - Large values of `k` compared to the size of the list (`k > n`).

- **Optimized Rotation**: To avoid unnecessary computational effort, calculate the effective rotations using the modulo operation: `k = k % n`.

# Circular Linked List Approach

1. **Transforming into a Circular List**: Visualize the linked list as a closed loop, where the tail connects back to the head. This transformation enables seamless rotations by allowing the starting point of the list to shift along the circle.

2. **Optimizing Rotations with Modulo**: Since rotating the list by a number `k` greater than its length (`n`) results in a repetitive configuration, the effective rotations are reduced to `k % n`, eliminating redundant operations.

3. **Identifying the Breaking Point**: The key lies in determining where to break the circular link. This is calculated based on the list's size (`n`) and the adjusted rotation count (`k % n`), ensuring the new head and tail are properly assigned.

## **Intuition**

A linked list is inherently a chain where nodes are already connected. The problem of rotating the list can be visualized as a series of steps:

#### **Core Insight**
- **Rotation Concept**: Rotating a linked list to the right by `k` places essentially means moving the last `k` nodes from the end of the list and placing them at the front, while maintaining the order of all elements.
  
#### **Step-by-Step Understanding**
1. **Close the Linked List into a Ring**:  
   Imagine the entire linked list as a **circular structure** where the last node is connected back to the first node, forming a loop.
   
2. **Locate the New Head and Tail**:  
   The new head of the rotated list will be at position **`n - k`**, where `n` is the total number of nodes in the list.  
   - **New Tail**: Located just before the new head, at position **`n - k - 1`**.

3. **Break the Ring**:  
   To complete the rotation, break the loop by severing the connection between the new tail and the new head, restoring a regular singly linked list.

#### **Key Considerations for `k`**
- **When `k < n`**: Find the new head at position `n - k`.
- **When `k >= n`**: Rotation cycles back. Large values of `k` can be reduced using modulo operation:  
  `k = k % n` 
  - `k` could be rewritten as a sum `k = (k // n) * n + k % n`, where the first term doesn't result in any rotation.
  This ensures we only consider the "net" rotations required.

#### **Example (Step Visualization)**
Let's see how this applies when `head = [1,2,3,4,5]` and `k = 2`:
- **Initial Input**: `[1,2,3,4,5]`
- **Step 1**: Close into a ring: `1 → 2 → 3 → 4 → 5 → 1`.
- **Step 2**: Identify new positions:  
  - New head = position `n - k = 5 - 2 = 3` → `4`.  
  - New tail = position `n - k - 1 = 3 - 1 = 2` → `3`.  
- **Step 3**: Break the ring at new tail → Output: `[4,5,1,2,3]`.

### **Pseudocode**

```pseudo
function rotateList(head, k):
 If head is NULL OR head.next is NULL OR k == 0:
     Return head

 // Step 1: Close the List into a Ring
 Initialize oldTail = head
 Initialize length = 1
 
 While oldTail.next is not NULL:
     oldTail = oldTail.next
     length = length + 1
 
 // Form a circular linked list
 oldTail.next = head

 // Step 2: Find the New Head and Tail
 k = k MOD length // Reduce k to avoid unnecessary rotations

 // New tail is at position (length - k - 1)
 // New head is at position (length - k)
 Initialize newTail = head
 for i from 1 to (length - k - 1):
     newTail = newTail.next
 
 Initialize newHead = newTail.next

 // Step 3: Break the Ring
 newTail.next = NULL // Sever the circular link

 return newHead
```

## **Complexity Analysis**

### **Assumptions**
- **Size**: The linked list contains `n` nodes.
- **Rotations**: The number of rotations is `k`.

### **Space Complexity**: `O(1)`
- **In-place operations**: The algorithm modifies pointers in the existing nodes without creating new data structures, using only a few variables like `oldTail`, `newTail`, `length`, and `stepsToNewTail`.
- **Pointer updates**: Changing the `next` pointers does not require extra memory.

*Overall*: Since the algorithm operates entirely in place, the space complexity is **`O(1)`**.
