# 86. Partition List

<p>Given the <code>head</code> of a linked list and a value <code>x</code>, partition it such that all nodes <strong>less than</strong> <code>x</code> come before nodes <strong>greater than or equal</strong> to <code>x</code>.</p>

<p>You should <strong>preserve</strong> the original relative order of the nodes in each of the two partitions.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/86-1-partition.jpg" style="width: 662px; height: 222px;">
<pre><strong>Input:</strong> head = [1,4,3,2,5,2], x = 3
<strong>Output:</strong> [1,2,2,4,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [2,1], x = 2
<strong>Output:</strong> [1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the list is in the range <code>[0, 200]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
  <li><code>-200 &lt;= x &lt;= 200</code></li>
</ul>

<br>

---

# Solution
- [Two Pointer Approach](#two-pointer-approach)
  - **Time Complexity**: `O(N)`

### Problem Overview

The goal is to partition a linked list such that all nodes with values less than `x` come before nodes with values greater than or equal to `x`, while preserving the original relative order of the nodes in each partition. 

We refer to the partition point as the `partitionPoint` or **"split point"**, where elements before this point are smaller than `x` and elements after this point are greater than or equal to `x`.

To achieve this, we split the list into two smaller lists: one containing elements less than `x` and the other containing elements greater than or equal to `x`, then join these lists.

### Example
- **Input**: head = [1, 4, 3, 2, 5, 2], x = 3
- **Output**: [1, 2, 2, 4, 3, 5]
  
- **Input**: head = [2, 1], x = 2
- **Output**: [1, 2]

# Two Pointer Approach

## **Intuition**
We can use two pointers, `lessThanX` and `greaterOrEqualX`, to keep track of two separate linked lists for nodes less than `x` and nodes greater than or equal to `x`, respectively. These lists are then combined to form the desired partitioned list.

## **Algorithm**
1. **Initialize**:
   - Create two sentinel nodes `lessThanX` and `greaterOrEqualX` to reduce conditional checks.
   - Use pointers to traverse and build these lists.

2. **Iterate through the Original List**:
   - Use the `head` pointer to traverse the linked list.
   - If the current node's value is less than `x`, add it to the `lessThanX` list.
   - Otherwise, add it to the `greaterOrEqualX` list.

3. **Combine the Two Lists**:
   - Once traversal is complete, combine the `lessThanX` and `greaterOrEqualX` lists.
   - Ensure the sentinel nodes are not part of the final result.

### Note on Relative Order Constraint
Since we traverse the linked list from left to right, the relative order of nodes in each list remains unchanged. In the implementation, nodes are moved from the original list to the `lessThanX` or `greaterOrEqualX` lists, rather than creating new nodes, ensuring no additional space is used.

### Pseudocode
```plaintext
function partition(head, x):
    lessThanXHead = new ListNode(0)
    lessThanX = lessThanXHead
    greaterOrEqualXHead = new ListNode(0)
    greaterOrEqualX = greaterOrEqualXHead

    while head is not null:
        if head.val < x:
            lessThanX.next = head
            lessThanX = lessThanX.next
        else:
            greaterOrEqualX.next = head
            greaterOrEqualX = greaterOrEqualX.next
        head = head.next

    greaterOrEqualX.next = null
    lessThanX.next = greaterOrEqualXHead.next

    return lessThanXHead.next
```

## **Implementation**

### Java

```java
class Solution {

  public ListNode partition(ListNode head, int x) {
    // Create sentinel nodes to start the lessThanX and greaterOrEqualX lists
    ListNode lessThanXHead = new ListNode(0);
    ListNode lessThanX = lessThanXHead;
    ListNode greaterOrEqualXHead = new ListNode(0);
    ListNode greaterOrEqualX = greaterOrEqualXHead;

    // Traverse the original linked list
    while (head != null) {
      if (head.val < x) {
        // Add node to the lessThanX list
        lessThanX.next = head;
        lessThanX = lessThanX.next;
      } else {
        // Add node to the greaterOrEqualX list
        greaterOrEqualX.next = head;
        greaterOrEqualX = greaterOrEqualX.next;
      }
      head = head.next;
    }

    // Terminate the greaterOrEqualX list
    greaterOrEqualX.next = null;
    // Combine the lessThanX and greaterOrEqualX lists
    lessThanX.next = greaterOrEqualXHead.next;

    // Return the head of the new partitioned linked list
    return lessThanXHead.next;
  }
}
```

### TypeScript

```typescript
class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Partitions the linked list around a value x using the two-pointer approach.
 *
 * @param head The head of the linked list.
 * @param x The value around which the list is to be partitioned.
 * @return The head of the newly partitioned linked list.
 */
function partition(head: ListNode | null, x: number): ListNode | null {
  // Create sentinel nodes to start the lessThanX and greaterOrEqualX lists
  let lessThanXHead = new ListNode(0);
  let lessThanX = lessThanXHead;
  let greaterOrEqualXHead = new ListNode(0);
  let greaterOrEqualX = greaterOrEqualXHead;

  // Traverse the original linked list
  while (head !== null) {
    if (head.val < x) {
      // Add node to the lessThanX list
      lessThanX.next = head;
      lessThanX = lessThanX.next;
    } else {
      // Add node to the greaterOrEqualX list
      greaterOrEqualX.next = head;
      greaterOrEqualX = greaterOrEqualX.next;
    }
    head = head.next;
  }

  // Terminate the greaterOrEqualX list
  greaterOrEqualX.next = null;
  // Combine the lessThanX and greaterOrEqualX lists
  lessThanX.next = greaterOrEqualXHead.next;

  // Return the head of the new partitioned linked list
  return lessThanXHead.next;
}
```

### **Complexity Analysis**

#### **Time Complexity**: `O(N)`
- **Traversal**: The linked list is traversed once, ensuring each node is processed exactly one time.
- **Combining Lists**: Combining the `lessThanX` and `greaterOrEqualX` lists takes constant time, `O(1)`.
- **Overall**: The time complexity is `O(N)`, where `N` is the number of nodes in the linked list.

#### **Space Complexity**: `O(1)`
- **In-Place Reordering**: We use a constant amount of extra space to maintain the `lessThanX` and `greaterOrEqualX` pointers.
- **No Additional Structures**: The algorithm modifies the original list without creating new nodes.
- **Overall**: The space complexity is `O(1)` as no additional space proportional to the input size is used.
