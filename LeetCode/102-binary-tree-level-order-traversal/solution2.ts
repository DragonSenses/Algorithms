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
 * Performs level-order traversal of a binary tree.
 *
 * @param root - The root node of the binary tree.
 * @returns A two-dimensional array where each subarray represents
 *          the values of nodes at a specific tree level.
 */
function levelOrder(root: TreeNode | null): number[][] {
  // Initialize levels list
  const levels: number[][] = [];

  /**
   * Edge case: Return empty list if the tree is null
   */
  if (root === null) {
    return levels;
  }

  // Initialize the queue with the root node
  const queue: (TreeNode | null)[] = [root];

  while (queue.length > 0) {
    // Number of nodes in the current level
    const levelSize = queue.length;
    // Sublist for the current level
    const currentLevel: number[] = [];

    for (let i = 0; i < levelSize; i++) {
      // Remove the front node from the queue
      const node = queue.shift();

      /**
       * Explicitly check if the node is defined
       */
      if (node !== undefined && node !== null) {
        // Add the node's value to the current level
        currentLevel.push(node.val);

        // Enqueue the left child if it exists
        if (node.left !== null) {
          queue.push(node.left);
        }
        // Enqueue the right child if it exists
        if (node.right !== null) {
          queue.push(node.right);
        }
      }
    }

    // Add the current level to the levels list
    levels.push(currentLevel);
  }

  // Return the result list
  return levels;
};
