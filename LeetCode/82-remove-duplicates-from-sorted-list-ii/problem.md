# 82. Remove Duplicates from Sorted List II

<p>Given the <code>head</code> of a sorted linked list, <em>delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 500px; height: 142px;" src="img/82-1.jpg">
<pre><strong>Input:</strong> head = [1,2,3,3,4,4,5]
<strong>Output:</strong> [1,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 500px; height: 205px;" src="img/82-2.jpg">
<pre><strong>Input:</strong> head = [1,1,1,2,3]
<strong>Output:</strong> [2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>

---

# Solution

- [Strict Deduplication Approach](#strict-deduplication-approach)
  - **Space Complexity**: `O(1)`

## **Problem Overview: Remove Duplicates from Sorted List II**

#### **Problem Statement**
Given the `head` of a sorted linked list, the goal is to remove all nodes that appear more than once in the list, leaving only distinct values. The resulting linked list should remain sorted.

#### **Key Observations**
1. The linked list is **sorted in ascending order**, which simplifies duplicate detection.
2. The objective is to **completely remove duplicated values**—meaning any number that appears more than once should be eliminated entirely.
3. The function must return the **new head of the filtered list** after removing duplicates.

#### **Example Walkthrough**
**Example 1:**
- **Input:** `[1,2,3,3,4,4,5]`
- **Process:** `3` and `4` are duplicates, so they are removed entirely.
- **Output:** `[1,2,5]`

**Example 2:**
- **Input:** `[1,1,1,2,3]`
- **Process:** `1` appears multiple times, so it is eliminated.
- **Output:** `[2,3]`

#### **Constraints**
- `0 <= Number of nodes <= 300`
- `-100 <= Node.val <= 100`
- The list is guaranteed to be **sorted**.

#### **Approach and Complexity**
- **Iterate through the list**, tracking duplicate elements using a pointer.
- **Skip over duplicate elements** entirely rather than just linking past them.
- **Time Complexity:** `O(n)`, where `n` is the number of nodes (since each node is visited once).
- **Space Complexity:** `O(1)`, as we modify the list in place without using extra data structures.

# Strict Deduplication Approach

## **Intuition**

Since the input linked list is sorted, duplicates are always adjacent, enabling easy identification.

However the key distinction between **Problem 82** and **Problem 83** is how duplicates are handled:

- **Problem 83 (Remove Duplicates from Sorted List)**: If a node has duplicates, we preserve **one copy** of the value and remove only the additional occurrences.
  - Example: `[1,1,2,3,3] → [1,2,3]`
  - Here, duplicate values remain in the list, but only one of each.

- **Problem 82 (Remove Duplicates from Sorted List II)**: If a node has duplicates, we **remove all occurrences** of that value, leaving only distinct numbers.
  - Example: `[1,1,2,3,3] → [2]`
  - The number `1` and `3` were duplicated, so they are removed entirely.

This means Problem 83 **retains unique elements**, while Problem 82 **eliminates all instances of duplicates**, leaving only numbers that appeared exactly once.

### **Strategy**

1. **Explicit Edge Case Handling**  
   - **Empty List (`head = null`)** -> Should return `null`.
   - **List with No Duplicates (`[1,2,3]`)** -> Should remain unchanged.
   - **List with Only Duplicates (`[1,1,1,1]`)** -> Should return an empty list `[]`.

2. **In-Place Modification: Using a Sentinel Node**
   - Since the list must be modified **in place**, a **sentinel node** is a useful technique for removing nodes at the beginning without special-case handling.

3. **Traversal: Two-Pointer Approach**  
   - Using a **two-pointer approach** (current node and a `prev` pointer) ensures efficient deletion.  
   - You should only unlink nodes **after confirming** they're duplicates, instead of prematurely skipping nodes.

### **Sentinel Node**

Let's consider the challenging situation where the linked list head has to be removed.

The standard way to handle this case is using a **sentinel node**—a widely used technique in linked lists and trees—helps streamline such scenarios by acting as a **pseudo-head** without holding actual data. Its primary role is to **standardize list operations**, eliminating the need for special-case handling when modifying the head.

By initializing a sentinel node with a **neutral value (e.g., `0`)**, we ensure that any deletions occur **within the list** rather than at its boundary. 

This prevents the need for separate logic when removing the first element, as every node to delete remains *inside* the list structure.

### **Deleting Internal Nodes**

When dealing with a **sorted linked list**, duplicates appear **consecutively**, making identification straightforward. The process of deletion involves tracking and bypassing these duplicate groups while preserving unique elements.

#### **Identifying Duplicate Sublists**
- Since the list is sorted, we detect duplicates by **comparing a node's value to the next node**.
- When consecutive nodes share the same value, they form a **sublist of duplicates**.

#### **Pointer Manipulation for Deletion**
- **First Node in Duplicate Sublist:** Since every occurrence of a duplicate must be removed, the **first node** in a duplicate group is also deleted.
- **Tracking the Predecessor:**  
  - To skip over duplicates efficiently, maintain a pointer to the **node before the duplicate sublist** (the **predecessor**).
  - This allows us to unlink the entire duplicate group in **one operation**.

#### **Skipping the Duplicate Sublist**
- Once a duplicate sequence is detected, update the predecessor's pointer to **bypass the duplicate sublist entirely**.
- This ensures that only distinct numbers remain, maintaining the **sorted structure**.

#### **Illustrative Example**
For input: `[1,2,3,3,4,4,5]`
1. `3` and `4` form duplicate sublists.
2. Their **predecessor nodes** (`2` and `5`, respectively) are linked **directly to the node after** the duplicates.
3. Resulting list: `[1,2,5]`.

This approach ensures **efficient deletion** with **O(n) time complexity**, as each node is visited only once.

## **Algorithm**

Now that we've defined the **strategy** and handled the **edge cases**, let's outline the step-by-step algorithm.

#### **1. Initialize a Sentinel Node**
- Create a **sentinel node** (`dummy`) with a neutral value (e.g., `0`).
- Point `dummy.next` to the `head` of the original list.
- Use a `prev` pointer initialized to `dummy` to track the **last safe node** before duplicates.

#### **2. Traverse the List**
- Use a `current` pointer to iterate through the linked list.
- Check if the current node has **a duplicate** by comparing `current.val` to `current.next.val`.

#### **3. Skip Over Duplicate Nodes**
- If duplicates are detected, advance `current` until **all occurrences** of that value are skipped.
- Link `prev.next` directly to **the first unique node after the duplicates**.

#### **4. Continue Until the End**
- Move `prev` forward **only when no duplicate was detected** (ensuring distinct nodes remain linked).
- Return `dummy.next`, which points to the modified list.

### **Pseudocode**

```plaintext
FUNCTION deleteDuplicates(head):
  IF head IS null:
    RETURN null  // Edge case: Empty list

  sentinel = NEW NODE(0)  // Create sentinel node
  sentinel.next = head
  prev = sentinel  // Tracks last distinct node before duplicate block

  WHILE head IS NOT null:
    IF head.next EXISTS AND head.value == head.next.value:
        // Identify duplicate sublist
        WHILE head.next EXISTS AND head.value == head.next.value:
            head = head.next  // Move to end of duplicate block
        
        prev.next = head.next  // Skip entire duplicate block
      ELSE:
        prev = prev.next  // Move forward if no duplicates
          
      head = head.next  // Advance iteration
  
  RETURN sentinel.next  // Head of modified list
```

## **Implementation**

### **Java**

```java
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    // Edge Case: If the input list is empty, return null immediately.
    if (head == null) {
      return null;
    }

    // Sentinel node simplifies head removal and edge cases.
    ListNode sentinel = new ListNode(0, head);

    // Pointer tracking the last distinct node before a duplicate sequence.
    ListNode prevUnique = sentinel;

    // Traverse the linked list.
    while (head != null) {
      // If the current node is the start of a duplicate sequence:
      if (head.next != null && head.val == head.next.val) {
        // Advance hea` until the end of the duplicate sequence.
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }

        // Remove all occurrences of the duplicate value by linking past it.
        prevUnique.next = head.next;
      } else {
        // Move prevUnique forward only when head is a unique value.
        prevUnique = prevUnique.next;
      }

      // Move head forward to continue processing the list.
      head = head.next;
    }

    // Return the modified list, skipping the sentinel node.
    return sentinel.next;
  }
}
```

### **Complexity Analysis**  

#### **Assumptions**
- The linked list consists of `n` nodes.
- The input list is **sorted in ascending order**, which ensures duplicates are grouped together.
- The algorithm removes **all occurrences of duplicate values**, leaving only distinct elements.

### **Space Complexity: `O(1)`**  
Since the algorithm modifies the linked list **in place** without using auxiliary data structures, it achieves **constant space usage** (`O(1)`).  

1. **No Extra Storage for Node Values**  
   - The algorithm does not store elements in a hash set, array, or other structures—it merely **relinks existing nodes**.  

2. **Fixed Number of Pointers Used**  
   - The only extra pointers required (`sentinel`, `prev`, `head`) remain **constant regardless of `n`**.
   - No recursion is used, avoiding the potential `O(n)` space cost of recursive stack frames.  

Thus, the **space complexity remains at `O(1)`**, making this an efficient in-place approach.