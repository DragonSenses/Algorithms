class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode sentinel = new ListNode(0, head);
    ListNode prevNode = sentinel;  // Tracks last distinct node before duplicates

    while (head != null) {
      if (head.next != null && head.val == head.next.val) {
        // Move to end of duplicate sublist
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        // Skip all duplicates
        prevNode.next = head.next;
      }
      
      head = head.next;
    }
    
    return sentinel.next;
  }
}