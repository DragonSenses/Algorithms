public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

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
