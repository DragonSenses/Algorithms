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

function levelOrder(root: TreeNode | null): number[][] {
  const levels: number[][] = []; // Initialize levels list

  // Edge case: Return empty list if the tree is null
  if (root === null) {
    return levels;
  }

  const queue: (TreeNode | null)[] = [root]; // Initialize the queue with the root node

  while (queue.length > 0) {
    const levelSize = queue.length; // Number of nodes in the current level
    const currentLevel: number[] = []; // Sublist for the current level

    for (let i = 0; i < levelSize; i++) {
      const node = queue.shift(); // Remove the front node from the queue
      // Explicitly check if node is defined
      if (node !== undefined && node !== null) {
        currentLevel.push(node.val); // Add the node's value to the current level

        // Enqueue the left and right children if they exist
        if (node.left !== null) {
          queue.push(node.left);
        }
        if (node.right !== null) {
          queue.push(node.right);
        }
      }
    }

    levels.push(currentLevel); // Add the current level to the result
  }

  return levels; // Return the result list
};
