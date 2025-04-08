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

function zigzagLevelOrder(root: TreeNode | null): number[][] {
  const result: number[][] = [];

  // Auxiliary function for recursive traversal
  function traverse(node: TreeNode | null, level: number): void {
    if (node === null) {
      return; // Base case: no node to process
    }

    // Ensure the result array has a subarray for the current level
    if (result.length === level) {
      result.push([]);
    }

    // Add the node's value to the appropriate subarray based on zigzag direction
    if (level % 2 === 0) {
      // Even level: append value to the subarray
      result[level].push(node.val);
    } else {
      // Odd level: prepend value to the subarray
      result[level].unshift(node.val);
    }

    // Recursively process the left and right children
    traverse(node.left, level + 1);
    traverse(node.right, level + 1);
  }

  return result;
};