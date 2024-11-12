/**
 * Class representing a singly-linked list node.
 */
class ListNode {
  val: number;
  next: ListNode | null;

  /**
   * Creates a ListNode.
   * @param val - The value of the node.
   * @param next - The reference to the next node.
   */
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Sorts a singly linked list using the bottom-up merge sort approach.
 * 
 * @param head - The head of the singly linked list.
 * @returns The head of the sorted singly linked list.
 */
function sortList(head: ListNode | null): ListNode | null {
  if (!head || !head.next) {
    return head; // Base case: if the list is empty or has only one node, it's already sorted.
  }

  // Find the length of the linked list
  let length = 0;
  let node: ListNode | null = head;
  while (node !== null) {
    length++;
    node = node.next;
  }

  // Sentinel node to simplify edge cases and merging
  let sentinel: ListNode = new ListNode(0);
  sentinel.next = head;

  // Bottom-up merge sort
  for (let sublistSize = 1; sublistSize < length; sublistSize *= 2) {
    let current: ListNode | null = sentinel.next;
    let prevTail: ListNode = sentinel;

    while (current !== null) {
      let left: ListNode | null = current; // Left sublist starts from current node
      let right: ListNode | null = split(left, sublistSize); // Split the list into two parts of given size
      current = split(right, sublistSize); // Update current to the next sublist to be processed

      prevTail.next = merge(left, right); // Merge the two sublists

      // Update prevTail to the end of the merged list
      while (prevTail.next !== null) {
        prevTail = prevTail.next;
      }
    }
  }

  return sentinel.next; // Return the sorted list, skipping the sentinel node
}

/**
 * Splits the list into two parts of the given size.
 *
 * @param start - The start node of the list to be split.
 * @param size - The size of the first part.
 * @returns The start node of the second part.
 */
function split(start: ListNode | null, size: number): ListNode | null {
  for (let i = 1; start !== null && i < size; i++) {
    start = start.next;
  }
  if (start === null) return null;
  let nextSubList: ListNode | null = start.next;
  start.next = null; // Split the list
  return nextSubList;
}

/**
 * Merges two sorted linked lists into one sorted list.
 *
 * @param left - The head of the first sorted linked list.
 * @param right - The head of the second sorted linked list.
 * @returns The head of the merged sorted linked list.
 */
function merge(left: ListNode | null, right: ListNode | null): ListNode | null {
  let sentinel: ListNode = new ListNode(0); // Sentinel node to simplify merging
  let current: ListNode = sentinel;

  while (left !== null && right !== null) {
    if (left.val <= right.val) {
      current.next = left;
      left = left.next;
    } else {
      current.next = right;
      right = right.next;
    }
    current = current.next;
  }

  // Append any remaining nodes
  if (left !== null) {
    current.next = left;
  } else {
    current.next = right;
  }

  return sentinel.next; // Return the merged list, skipping the sentinel node
}
