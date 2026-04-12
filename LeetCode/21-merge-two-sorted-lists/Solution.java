/**
 * Merges two sorted singly linked lists into one sorted list.
 *
 * This method performs a recursive merge:
 * - If either list is empty, the other list is returned immediately.
 * - Otherwise, the node with the smaller value becomes the head of the merged list.
 * - The chosen node's next pointer is set to the result of merging the remaining nodes.
 *
 * The merge is done by reusing existing nodes; no new nodes are allocated.
 *
 * @param list1 the head of the first sorted linked list
 * @param list2 the head of the second sorted linked list
 * @return the head of the merged sorted linked list
 */
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
