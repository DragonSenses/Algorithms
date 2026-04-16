/**
 * Represents a node in a singly linked list.
 */
class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

/**
 * Merges two sorted singly linked lists into one sorted list.
 *
 * This function performs a recursive merge:
 * - If either list is null, the other list is returned.
 * - Otherwise, the node with the smaller value becomes the head.
 * - The chosen node's `next` pointer is set to the result of merging the remaining nodes.
 *
 * Nodes are reused; no new nodes are created.
 *
 * @param list1 - Head of the first sorted linked list
 * @param list2 - Head of the second sorted linked list
 * @returns The head of the merged sorted linked list
 */
function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  // Base cases: if one list is empty, return the other
  if (list1 == null) {
    return list2;
  }
  if (list2 == null) {
    return list1;
  }

  // Choose the smaller node and recursively merge the remainder
  if (list1.val <= list2.val) {
    list1.next = mergeTwoLists(list1.next, list2);
    return list1;
  } else {
    list2.next = mergeTwoLists(list1, list2.next);
    return list2;
  }
}
