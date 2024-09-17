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