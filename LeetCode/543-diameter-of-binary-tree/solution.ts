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

class Solution {
  private diameter: number = 0;

  /**
   * Main method to find the diameter of the binary tree.
   *
   * @param root The root node of the binary tree.
   * @return The diameter of the binary tree.
   */
  diameterOfBinaryTree(root: TreeNode | null): number {
    this.longestPath(root);
    return this.diameter;
  }

  /**
   * Recursive method to find the longest path from the given node to a leaf.
   *
   * @param node The current node being processed.
   * @return The longest path from the node to a leaf node.
   */
  private longestPath(node: TreeNode | null): number {
    // Base case: If the node is null, return 0
    if (node === null) {
      return 0;
    }

    // Recursively find the longest paths of the left and right children
    const leftPath: number = this.longestPath(node.left);
    const rightPath: number = this.longestPath(node.right);

    // Update the diameter if the sum of leftPath and rightPath is larger
    this.diameter = Math.max(this.diameter, leftPath + rightPath);

    // Return the longer path plus 1
    return Math.max(leftPath, rightPath) + 1;
  }
};
