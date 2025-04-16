/**
 * Definition for a binary tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function isSymmetric(root: TreeNode | null): boolean {
  if (root === null) {
    return true; // An empty tree is symmetric
  }

  // Use a queue to store pairs of nodes to compare
  const queue: Array<[TreeNode | null, TreeNode | null]> = [];
  queue.push([root.left, root.right]);

  while (queue.length > 0) {
    // Dequeue a pair of nodes
    const [left, right] = queue.shift()!;

    // Base cases for symmetry checks
    if (left === null && right === null) {
      continue; // Both nodes are null, move to the next pair
    }
    if (left === null || right === null) {
      return false; // One node is null but the other is not
    }


  }

}