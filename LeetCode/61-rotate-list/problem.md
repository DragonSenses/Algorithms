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

- [Cyclic Shift Approach](#cyclic-shift-approach)

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

# Cyclic Shift Approach

The idea revolves around understanding the **cyclic nature of the rotation** and reducing unnecessary computation through smart observations:

1. **Circular Transformation**: Think of the linked list as forming a loop or circle. This helps in visualizing the rotation process as simply moving the "start" of the list to a new point on the circle.

2. **Modulo Optimization**: Recognizing that rotations beyond the size of the list (i.e., `k >= n`) return us to a previously seen configuration. Using the modulo operation simplifies the rotation to only what's needed.

3. **New Break Point**: The trick lies in identifying where to "cut" the loop to form the new head and tail, which depends on the size of the list (`n`) and the reduced value of `k`.

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
FUNCTION rotateList(head, k):
    IF head IS NULL OR head.next IS NULL OR k == 0:
        RETURN head  // No rotation needed

    // Step 1: Calculate the length of the list and close it into a circular linked list
    SET length = 1
    SET tail = head
    WHILE tail.next IS NOT NULL:
        length = length + 1
        tail = tail.next
    END WHILE
    tail.next = head  // Form a circular list

    // Step 2: Find the effective number of rotations
    k = k MOD length

    // Step 3: Determine the new head and tail
    SET stepsToNewTail = length - k - 1
    SET newTail = head
    FOR i FROM 0 TO stepsToNewTail:
        newTail = newTail.next
    END FOR
    SET newHead = newTail.next

    // Step 4: Break the circular list
    newTail.next = NULL

    RETURN newHead
END FUNCTION
```
