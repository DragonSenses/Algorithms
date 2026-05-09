class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

function mergeTwoLists(
  list1: ListNode | null,
  list2: ListNode | null,
): ListNode | null {
  let sentinel = new ListNode();
  let current = sentinel;

  while (list1 != null && list2 != null) {
    if (list1.val <= list2.val) {
      current.next = list1; 
      list1 = list1.next; 
    } else {
      current.next = list2;
      list2 = list2.next;
    }

    current = current.next;
  }

  // Attach whichever list still has remaining nodes
  current.next = list1 != null ? list1 : list2;

  return sentinel.next;
}