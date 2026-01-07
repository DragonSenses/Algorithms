/**
 * Represents a node in a binary tree.
 */
class TreeNode {
  /** The integer value stored in the node. */
  val: number;

  /** Reference to the left child node, or null if absent. */
  left: TreeNode | null;

  /** Reference to the right child node, or null if absent. */
  right: TreeNode | null;

  /**
   * Creates a new TreeNode instance.
   *
   * @param val - The node's value. Defaults to 0.
   * @param left - The left child node. Defaults to null.
   * @param right - The right child node. Defaults to null.
   */
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Computes the right-side view of a binary tree using BFS.
 * The right-side view consists of the last visible node at each depth level.
 *
 * @param root - The root of the binary tree.
 * @returns An array of node values representing the rightmost node at each level.
 */
function rightSideView(root: TreeNode | null): number[] {
  const rightside: number[] = [];
  if (root === null) return rightside;

  // Queue of nodes to process for the next depth level
  let nextLevel: TreeNode[] = [root];

  while (nextLevel.length > 0) {
    const currLevel = nextLevel;
    nextLevel = [];
    let node: TreeNode | null = null;

    // Traverse all nodes in the current level
    for (let i = 0; i < currLevel.length; i++) {
      node = currLevel[i];

      if (node.left) {
        nextLevel.push(node.left);
      }
      if (node.right) {
        nextLevel.push(node.right);
      }
    }

    // node now holds the rightmost node of this level
    if (node) {
      rightside.push(node.val);
    }
  }

  return rightside;
}