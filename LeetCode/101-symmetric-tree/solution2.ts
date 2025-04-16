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

/**
 * Checks whether a binary tree is symmetric around its center.
 * Uses an iterative approach with a queue for efficient traversal.
 *
 * @param root - The root node of the binary tree.
 * @returns True if the tree is symmetric, false otherwise.
 */
function isSymmetric(root: TreeNode | null): boolean {
  // An empty tree is symmetric
  if (root === null) {
    return true;
  }

  // Initialize a queue to store pairs of nodes for comparison
  const queue: Array<[TreeNode | null, TreeNode | null]> = [];

  // Add the first pair (left and right children of the root)
  queue.push([root.left, root.right]);

  // Process node pairs iteratively
  while (queue.length > 0) {
    // Dequeue a pair of nodes for comparison
    const [left, right] = queue.shift()!;

    // If both nodes are null, move to the next pair
    if (left === null && right === null) {
      continue;
    }

    // If one node is null but the other is not, the tree is asymmetric
    if (left === null || right === null) {
      return false;
    }

    // If node values do not match, the tree is asymmetric
    if (left.val !== right.val) {
      return false;
    }

    // Add mirror pairs of child nodes to the queue for further comparisons
    queue.push([left.left, right.right]);
    queue.push([left.right, right.left]);
  }

  // All pairs passed the symmetry checks; return true
  return true;
}
