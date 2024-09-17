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

