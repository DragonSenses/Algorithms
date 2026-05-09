/**
 * Merges two sorted singly linked lists into one sorted list using an iterative approach with a
 * sentinel (dummy) node.
 *
 * The algorithm repeatedly selects the smaller head node from the two lists, attaches it to the
 * merged list, and advances the pointer in the list from which the node was taken. Once one list is
 * exhausted, the remainder of the other list is appended.
 *
 * No new nodes are created; existing nodes are reused.
 *
 * @param list1 the head of the first sorted linked list
 * @param list2 the head of the second sorted linked list
 * @return the head of the merged sorted linked list
 */
class Solution2 {
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
