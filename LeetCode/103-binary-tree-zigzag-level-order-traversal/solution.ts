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

  }

  return result;
};