class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Detects whether a singly linked list contains a cycle.
 *
 * A cycle exists if any node can be reached more than once by
 * following next pointers. This implementation uses a Set to
 * record visited nodes and checks for repeats.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @param head The head of the linked list.
 * @returns True if a cycle exists, false otherwise.
 */
function hasCycle(head: ListNode | null): boolean {
  // Tracks nodes that have already been visited
  const visited = new Set<ListNode>();

  // Cursor used to traverse the list
  let current = head;

  // Traverse until reaching null or detecting a repeat
  while (current !== null) {
    // If current node was seen before, a cycle exists
    if (visited.has(current)) {
      return true;
    }

    // Mark node as visited
    visited.add(current);

    // Advance to next node
    current = current.next;
  }

  // Reached end of list without repeats
  return false;
};