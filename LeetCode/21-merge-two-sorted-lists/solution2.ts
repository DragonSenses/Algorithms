class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

/**
 * Merges two sorted singly linked lists into one sorted list
 * using an iterative approach with a sentinel (dummy) node.
 *
 * The algorithm repeatedly selects the smaller head node from
 * the two lists, appends it to the merged list, and advances
 * the pointer in the list from which the node was taken.
 *
 * Once one list is exhausted, the remainder of the other list
 * is attached. No new nodes are created; existing nodes are reused.
 *
 * @param list1 - Head of the first sorted linked list
 * @param list2 - Head of the second sorted linked list
 * @returns The head of the merged sorted linked list
 */
function mergeTwoLists(
  list1: ListNode | null,
  list2: ListNode | null,
): ListNode | null {
  // Sentinel node simplifies head handling
  let sentinel = new ListNode();
  let current = sentinel;

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
  current.next = list1 != null ? list1 : list2;

  // The merged list starts after the sentinel
  return sentinel.next;
}