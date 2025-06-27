class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function reverseBetween(
  head: ListNode | null,
  left: number,
  right: number
): ListNode | null {
  let leftPointer = head;
  let stop = false;

  function recurseAndReverse(
    rightNode: ListNode | null,
    m: number,
    n: number
  ): void {
    // Base case: stop at right-th node or end of list
    if (n === 1 || rightNode === null) return;

    // Walk right pointer one step forward until it reaches (n == 1) (right boundary)
    rightNode = rightNode.next;

    // Keep moving left pointer to the right until we reach the proper node to start reversal
    if (m > 1) {
      leftPointer = leftPointer!.next;
    }

    // Recursive call with m and n reduced
    recurseAndReverse(rightNode, m - 1, n - 1);

    // Stop condition: pointers have met or crossed
    if (
      leftPointer === rightNode ||
      (rightNode !== null && leftPointer?.next === rightNode)
    ) {
      stop = true;
    }

    // Swap values unless pointers have crossed
    if (!stop && rightNode !== null) {
      const temp = leftPointer!.val;
      leftPointer!.val = rightNode.val;
      rightNode.val = temp;

      // Advance leftPointer forward
      leftPointer = leftPointer!.next;
    }
  }

}
