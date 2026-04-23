class Solution2 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode sentinel = new ListNode();
    ListNode current = sentinel;

    while ((list1 != null) && (list2 != null)) {
      if (list1.val <= list2.val) {
        current.next = list1;
      } 

  } 
}