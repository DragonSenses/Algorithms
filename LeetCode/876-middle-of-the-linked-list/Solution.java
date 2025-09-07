class Solution {
  /**
   * Returns the middle node of a singly linked list using the two-pointer technique.
   * This method employs a slow and fast pointer: - The slow pointer advances one node per iteration. - The fast pointer advances two nodes per iteration. When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
   * If the list has an even number of nodes, the method returns the second middle node.
   *
   * @param head the head of the singly linked list
   * @return the middle node of the list (includes all subsequent nodes)
   */
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
