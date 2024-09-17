# 19. Remove Nth Node From End of List

Given the `head` of a linked list, remove the `n^th` node from the end of the list and return its head.

![](img/19-1.jpg)

#### Example 1:

Input: head = [1,2,3,4,5], n = 2

Output: [1,2,3,5]

#### Example 2:

Input: head = [1], n = 1

Output: []

#### Example 3:

Input: head = [1,2], n = 1

Output: [1]

#### Constraints:

  - The number of nodes in the list is `sz`.
  - `1 <= sz <= 30`
  - `0 <= Node.val <= 100`
  - `1 <= n <= sz`

**Follow up**: Could you do this in one pass?

# Solution

- [Two-Pass | Naive Approach](#two-pass-approach)
  - Time complexity: `O(n)`
- [One-Pass | Optimized Approach](#one-pass-approach)
  - Time complexity: `O(n)`

# Two Pass Approach

## **Intuition**

### Problem Breakdown

To solve this problem, we need to understand and apply two key concepts:

1. **Linked List Traversal**
2. **Removing the N-th Element from the End of a Linked List**

### Problem Explanation

We need to remove the `nth` node from the end of the list. This can also be viewed from a different perspective: given that `L` is the length of the list, we need to remove the `(L - n + 1)`th node from the beginning of the list.

## **Algorithm**

We will use an auxiliary sentinel node, or "dummy node", to serve as placeholders to simplify operations and handle edge cases more gracefully. While the terms can be used interchangeably, "dummy node" is often used in the context of linked lists, whereas "sentinel node" is a broader term applicable to various data structures. 

- **Dummy Node**: Typically refers to an extra node added at the beginning (or sometimes the end) of a linked list. It helps simplify operations like insertion and deletion by providing a non-null node to work with.
- **Sentinel Node**: A more general term that can refer to any special node used to simplify boundary conditions. It can be at the beginning, end, or both ends of a data structure.

### Common Uses:

- **Simplifying Edge Cases**: Both dummy and sentinel nodes help manage cases like an empty list, a single-node list, or operations at the head or tail of the list.
- **Consistent Operations**: They ensure that operations like insertion, deletion, and traversal can be performed uniformly without additional checks for null pointers.

### Steps to Remove the N-th Node from the End of a Linked List

1. **Add a Sentinel Node**
   - Create an auxiliary sentinel node.
   - Set the `next` pointer of the sentinel node to point to the head of the list.
   - This sentinel node helps simplify edge cases, such as a list with only one node or removing the head of the list.

2. **Find the Length of the List**
   - Initialize a variable `L` to store the length of the list.
   - Traverse the list to calculate its length `L`.

3. **Set a Pointer to the Sentinel Node**
   - Initialize a pointer and set it to the sentinel node.

4. **Move the Pointer to the (L - n)th Node**
   - Move the pointer through the list until it reaches the `(L - n)`th node.

5. **Relink the Next Pointer**
   - Adjust the `next` pointer of the `(L - n)`th node to point to the `(L - n + 2)`th node.

6. **Completion**
   - The node has been successfully removed from the list.

## **Implementation**

### Java

- Using `for` loops

```java
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;

    ListNode curr = head;
    int len = 0;

    // First pass to find the length of the list
    for (; curr != null; curr = curr.next) {
      len++;
    }

    // Calculate the position to remove
    len-=n;

    // Reinitialize curr to the sentinel node
    curr = sentinel;

    // Move to the (len)th node
    for (; len > 0; len--) {
      curr = curr.next;
    }

    // Remove the nth node from the end
    curr.next = curr.next.next;

    return sentinel.next;
  }
}
```

- Using `while` loops

```java
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;

    ListNode curr = head;
    int len = 0;

    // First pass to find the length of the list
    while (curr != null) {
      len++;
      curr = curr.next;
    }

    // Calculate the position to remove
    len -= n;

    // Reinitialize curr to the sentinel node
    curr = sentinel;

    // Move to the (len)th node
    while (len > 0) {
      len--;
      curr = curr.next;
    }

    // Remove the nth node from the end
    curr.next = curr.next.next;

    return sentinel.next;
  }
}
```

## **Complexity Analysis**

Let `n` be the number of nodes in the list.

### **Time complexity**: `O(n)`
  - The algorithm makes two traversal of the list:
    - First to calculate list length `L`
    - Second to find the `(L - n)`th node
    - There are `2L - n` operations and time complexity is `O(L)` which is `O(n)`

### **Space complexity**: `O(1)`
  - We use a constant amount of space to store: sentinel node, length of list, and a pointer.

# One Pass Approach

## **Intuition**

To remove the `nth` node from the end of the list, we can also think of it as removing the `(L - n + 1)`th node from the beginning of the list. The challenge is to calculate the length of the list and remove the `nth` node from the end without making a second traversal backward.

### Optimized Approach

The two-pass approach can be optimized to a one-pass approach using two pointers. Here's how:

1. **Initialize Two Pointers**
   - Use two pointers, `first` and `second`.
   - The `first` pointer will advance `n + 1` steps from the beginning.
   - The `second` pointer will start from the beginning of the list.

2. **Advance the First Pointer**
   - Move the `first` pointer `n + 1` steps ahead in the list.
   - This creates a gap of `n` nodes between the `first` and `second` pointers.

3. **Move Both Pointers Together**
   - Advance both pointers together, maintaining the gap, until the `first` pointer reaches past the last node.
   - At this point, the `second` pointer will be pointing at the `nth` node from the end.

4. **Relink the Next Pointer**
   - Adjust the `next` pointer of the node referenced by the `second` pointer to skip the `nth` node.
   - This effectively removes the `nth` node from the list.

By using two pointers with a constant gap of `n` nodes, we can efficiently remove the `nth` node from the end of the list in a single traversal. This approach avoids the need for a second pass and simplifies the process.

## **Algorithm**

### Steps to Remove the N-th Node from the End of a Linked List

1. **Initialize Two Pointers**
   - Create a sentinel (dummy) node and set its `next` pointer to the head of the list.
   - Initialize two pointers, `first` and `second`, both pointing to the sentinel node.

2. **Advance the First Pointer**
   - Move the `first` pointer `n + 1` steps ahead in the list. This creates a gap of `n` nodes between the `first` and `second` pointers.

3. **Move Both Pointers Together**
   - Move both `first` and `second` pointers one step at a time, maintaining the gap, until the `first` pointer reaches past the last node.

4. **Relink the Next Pointer**
   - The `second` pointer will now be pointing to the node just before the `nth` node from the end.
   - Adjust the `next` pointer of the node referenced by the `second` pointer to skip the `nth` node, effectively removing it from the list.

5. **Return the Modified List**
   - Return the `next` pointer of the sentinel node, which points to the head of the modified list.

