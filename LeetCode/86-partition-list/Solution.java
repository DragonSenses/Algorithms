/**
 * This class provides a solution to partition a linked list around a value x,
 * such that all nodes with values less than x come before nodes with values
 * greater than or equal to x. The relative order of nodes in each partition
 * is preserved.
 */
class Solution {

  /**
   * Partitions the linked list around a value x using the two-pointer approach.
   * 
   * @param head The head of the linked list.
   * @param x    The value around which the list is to be partitioned.
   * @return The head of the newly partitioned linked list.
   */
  public ListNode partition(ListNode head, int x) {
    // Create sentinel nodes to start the lessThanX and greaterOrEqualX lists
    ListNode lessThanXHead = new ListNode(0);
    ListNode lessThanX = lessThanXHead;
    ListNode greaterOrEqualXHead = new ListNode(0);
    ListNode greaterOrEqualX = greaterOrEqualXHead;

    // Traverse the original linked list
    while (head != null) {
      if (head.val < x) {
        // Add node to the lessThanX list
        lessThanX.next = head;
        lessThanX = lessThanX.next;
      } else {
        // Add node to the greaterOrEqualX list
        greaterOrEqualX.next = head;
        greaterOrEqualX = greaterOrEqualX.next;
      }
      head = head.next;
    }

    // Terminate the greaterOrEqualX list
    greaterOrEqualX.next = null;
    // Combine the lessThanX and greaterOrEqualX lists
    lessThanX.next = greaterOrEqualXHead.next;

    // Return the head of the new partitioned linked list
    return lessThanXHead.next;
  }
}
