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
  // Initialize levels list
  const levels: number[][] = [];

  // Edge case: If the root is null, return an empty list
  if (root === null) {
    return levels;
  }

  const traverseLevels = (node: TreeNode | null, level: number): void => {
    if (node === null) {
      return; // Base case: if the node is null, stop recursion
    }

    // Ensure there's a sublist for the current level
    if (levels.length === level) {
      levels.push([]);
    }

    // Add the current node's value to the appropriate level
    levels[level].push(node.val);

    // Recursively traverse the left and right subtrees
    traverseLevels(node.left, level + 1);
    traverseLevels(node.right, level + 1);
  };

  return levels;
};
