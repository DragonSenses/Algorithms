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

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  if (list1 == null) {
    return list2;
  }

   if (list2 == null) {
    return list1;
   }

  if (list1.val <= list2.val) {
    return list1;
  } 
};