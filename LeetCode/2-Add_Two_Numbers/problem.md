# Add Two Numbers

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

```
(2) -> (4) -> (3)
(5) -> (6) -> (4)
(7) -> (0) -> (8)
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

Topics: Linked List, Math, Recursion

# Solution

**Key points**

- Given two non-empty linked lists representing two non-negative integers
- Digits stored in reverse order
- Each node contains a single digit
- Add the two numbers and return the sum as a new linked list, also in reverse order

**Approach**

1. **Simultaneous Traversal:**
   - Traverse both linked lists simultaneously, accessing each node.
   - At each iteration, consider the corresponding nodes from both lists.

2. **Compute Sum and Digit:**
   - Compute the sum of the current digits along with any carry from the previous step.
   - Extract the last digit (the result digit) from the sum.

3. **Advance Pointers:**
   - Advance the pointers to the next nodes in both linked lists.
   - Continue the traversal until both lists are exhausted.

4. **Handle Carry:**
   - Keep track of any carry resulting from the addition.
   - If there's a carry after the last iteration, create an additional node for it.

**Key steps**

1. Traverse both linked lists, adding digits and handling carry.
2. Create new nodes for the result.
3. Return the head of the resultant linked list

## Java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            curr.next = new ListNode(digit);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return sentinel.next;
    }
}
```

