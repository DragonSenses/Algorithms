# 21. Merge Two Sorted Lists

<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 662px; height: 302px;" src="img/21-1.jpg">
<pre><strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
  <li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>

---

# Solution

- [Recursive Approach](#recursive-approach)
  - **Time Complexity**: `O(n + m)`
  - **Space Complexity**: `O(n + m)`
- [Iterative Approach](#iterative-approach)
  - **Space Complexity**: `O(1)`

## **Problem Overview: Merge Two Sorted Lists**

This problem asks you to merge two **individually sorted** singly linked lists into a **single sorted** linked list. The merge must be done by **reusing the existing nodes**, not by creating new ones for each value. The result should preserve non‑decreasing order.

You are given:
- `list1`: head of the first sorted linked list  
- `list2`: head of the second sorted linked list  

Your task:
- Traverse both lists simultaneously  
- Select the smaller current node at each step  
- Splice nodes together to form one sorted output list  
- Return the head of the merged list  

This is structurally identical to the merge step of merge sort, but applied to linked lists instead of arrays.

### **Key Points**
- Both input lists are already sorted  
- You must merge them by pointer manipulation  
- The output must also be sorted  
- Either list may be empty  
- Values range from −100 to 100  
- Maximum combined length is 100 nodes  

### **Examples**
- Merging `[1,2,4]` and `[1,3,4]` produces `[1,1,2,3,4,4]`  
- Merging two empty lists yields an empty list  
- Merging `[]` and `[0]` yields `[0]`  

### **Why This Problem Matters**
This is one of the most fundamental linked‑list operations. It builds intuition for:
- Pointer manipulation  
- Sentinel‑node patterns  
- Iterative vs. recursive list processing  
- Merge‑sort on linked lists  

# Recursive Approach

## **Intuition**

The recursive solution leans on a simple observation:  
At any point, the head of the merged list must be the **smaller** of the two current nodes from `list1` and `list2`.

So the recursion works by repeatedly:
- Comparing the heads of both lists  
- Choosing the smaller node as the head of the merged list  
- Recursively merging the *rest* of that list with the *other* list  

This naturally decomposes the problem into smaller subproblems until one list becomes empty.  
When that happens, the remaining nodes of the other list are already sorted, so we simply return that list.

The recursion mirrors the structure of the final merged list:  
each chosen node points to the result of merging the remaining nodes.

## **Algorithm**

1. **Handle the base cases**
   - If `list1` is empty (`null`), return `list2`  
     (because all remaining nodes in `list2` are already sorted)
   - If `list2` is empty (`null`), return `list1`  
     (same reasoning)

2. **Compare the current node values**
   - If `list1.val <= list2.val`:
     - The head of the merged list must be `list1`
   - Else:
     - The head of the merged list must be `list2`

3. **Recurse on the remainder of the lists**
   - If `list1` was chosen:
     - Set `list1.next = merge(list1.next, list2)`
     - Return `list1` as the head of the merged list
   - If `list2` was chosen:
     - Set `list2.next = merge(list1, list2.next)`
     - Return `list2` as the head of the merged list

4. **Allow recursion to build the final list**
   - Each recursive call returns the correct head for its subproblem
   - As the stack unwinds, each chosen node's `.next` pointer is already set
   - The final returned node from the top-level call is the head of the fully merged list

### **Pseudocode**

```text
function merge(list1, list2):
  if list1 is null:
    return list2

  if list2 is null:
    return list1

  if list1.val <= list2.val:
    list1.next = merge(list1.next, list2)
    return list1
  else:
    list2.next = merge(list1, list2.next)
    return list2
```

**Key behaviors:**
- Base cases handle exhaustion of either list  
- The smaller node becomes the head of the merged list  
- The `.next` pointer is assigned to the result of the recursive call  
- The recursion unwinds to produce the fully merged list  

## **Implementation**

### Java

```java
class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    // Base case: if one list is empty, return the other
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    // Choose the smaller node and recursively merge the remainder
    if (list1.val <= list2.val) {
      list1.next = mergeTwoLists(list1.next, list2); // attach merged remainder
      return list1; // list1 is the new head
    } else {
      list2.next = mergeTwoLists(list1, list2.next); // attach merged remainder
      return list2; // list2 is the new head
    }
  }
}
```

### TypeScript

```typescript
class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  if (list1 == null) {
    return list2;
  }

   if (list2 == null) {
    return list1;
   }

  if (list1.val <= list2.val) {
    list1.next = mergeTwoLists(list1.next, list2);
  return list1;
  } else {
    list2.next = mergeTwoLists(list1, list2.next);
    return list2;
  }
};
```

## **Complexity Analysis**

### **Assumptions**
- Let `n` be the number of nodes in `list1`  
- Let `m` be the number of nodes in `list2`  
- Both lists are already sorted in non‑decreasing order  
- Node comparisons and pointer assignments are `O(1)`

### **Time Complexity**: `O(n + m)`

- **One Pass Through All Nodes**:  
  Each recursive call consumes exactly one node from either `list1` or `list2`.  
- **Linear Merge**:  
  Since every node is visited once, the total work is proportional to the combined length of both lists.

### **Space Complexity**: `O(n + m)`

- **Recursive Call Stack**:  
  Each merge step makes one recursive call, and the recursion depth equals the total number of nodes processed.  
- **No Extra Data Structures**:  
  Aside from the call stack, no additional memory is allocated; nodes are reused and pointers are rewired.

# Iterative Approach

## **Intuition**

The iterative method removes recursion entirely and instead builds the merged list step‑by‑step using pointer manipulation.

The key idea is to maintain a **current pointer** that always represents the *tail* of the merged list so far. At each step:

- Compare the heads of `list1` and `list2`
- Attach the smaller node to `current.next`
- Advance the pointer in the list from which the node was taken
- Move `current` forward

To simplify edge cases (especially when initializing the head), we use a **sentinel node** whose `.next` will eventually point to the real merged list. This avoids special‑case logic for the first insertion.

Once one list is exhausted, the remaining nodes of the other list are already sorted, so we simply attach the rest in one step.

This approach is clean, deterministic, and avoids the call‑stack overhead of recursion.

## **Algorithm**

1. **Create a sentinel node**
   - **Purpose:** Acts as a fixed starting point for the merged list.
   - Initialize:
     - `sentinel` = new node (value doesn't matter)
     - `current` = `sentinel`

2. **Traverse both lists while neither is empty**
   - Condition: `while list1 != null AND list2 != null`:
     1. **Compare current values**  
        - If `list1.val <= list2.val`:
          - Set `current.next = list1`
          - Move `list1` to `list1.next`
        - Else:
          - Set `current.next = list2`
          - Move `list2` to `list2.next`
     2. **Advance the merged-list tail**  
        - Move `current` to `current.next`

3. **Attach the remaining nodes**
   - After the loop, exactly one of `list1` or `list2` may be non‑null:
     - If `list1 != null`, set `current.next = list1`
     - Else, set `current.next = list2`
   - This works because the remaining nodes are already sorted.

4. **Return the head of the merged list**
   - The real head is `sentinel.next` (skip the sentinel node itself).
   - Return `sentinel.next`.

### **Pseudocode**

```text
function merge(list1, list2):
  create sentinel node
  current = sentinel

  while list1 is not null AND list2 is not null:
    if list1.val <= list2.val:
      current.next = list1
      list1 = list1.next
    else:
      current.next = list2
      list2 = list2.next

    current = current.next

  if list1 is not null:
    current.next = list1
  else:
    current.next = list2

  return sentinel.next
```

**Key behaviors:**
- The sentinel node anchors the merged list  
- `current` always points to the last node in the merged list  
- Only one pointer moves at a time (either `list1` or `list2`)  
- The loop continues until one list is empty  
- The tail of the non‑empty list is appended in constant time  

## **Implementation**

### **Java**

```java
class Solution {
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    // Sentinel node simplifies handling of the merged list head
    ListNode sentinel = new ListNode();
    ListNode current = sentinel;

    // Merge while both lists have nodes
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        current.next = list1; // attach list1 node
        list1 = list1.next; // advance list1
      } else {
        current.next = list2; // attach list2 node
        list2 = list2.next; // advance list2
      }

      current = current.next; // advance merged-list tail
    }

    // Attach whichever list still has remaining nodes
    current.next = (list1 != null) ? list1 : list2;

    // The real head is after the sentinel
    return sentinel.next;
  }
}
```

### **TypeScript**

```typescript
class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

function mergeTwoLists(
  list1: ListNode | null,
  list2: ListNode | null,
): ListNode | null {
  let sentinel = new ListNode();
  let current = sentinel;

  while (list1 != null && list2 != null) {
    if (list1.val <= list2.val) {
      current.next = list1; 
      list1 = list1.next; 
    } else {
      current.next = list2;
      list2 = list2.next;
    }

    current = current.next;
  }

  current.next = list1 != null ? list1 : list2;

  return sentinel.next;
};
```

## **Complexity Analysis**

### **Assumptions**
- Let `n` be the number of nodes in `list1`  
- Let `m` be the number of nodes in `list2`  
- Both lists are already sorted in non‑decreasing order  
- Node comparisons and pointer assignments are `O(1)`

### **Space Complexity**: `O(1)`

- No recursion means no call stack growth  
- Only a few pointers (`sentinel`, `current`, `list1`, `list2`) are used  
- All nodes are reused; no new nodes are allocated