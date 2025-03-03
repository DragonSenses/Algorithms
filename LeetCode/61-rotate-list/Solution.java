class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
    this.next = null;
  }
}

public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    // Handle edge cases where no rotation is needed:
    // - Empty list (head == null)
    // - Single-node list (head.next == null)
    // - Zero rotations requested (k == 0)
    if (head == null || head.next == null || k == 0) {
      return head;
    }

    // Step 1: Calculate the length of the list and close it into a circular list
    ListNode oldTail = head;
    int length = 1;
    while (oldTail.next != null) {
      oldTail = oldTail.next;
      length++;
    }
    oldTail.next = head; // Form a circular list

    return new ListNode(0);
  }
}
