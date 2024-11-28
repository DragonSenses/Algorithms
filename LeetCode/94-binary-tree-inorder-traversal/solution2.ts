/**
 * Definition for a binary tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  /**
   * Constructs a new TreeNode.
   * @param val - The value of the node.
   * @param left - The left child of the node.
   * @param right - The right child of the node.
   */
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Performs in-order traversal of a binary tree.
 * @param root - The root of the binary tree.
 * @returns An array containing the in-order traversal of the tree.
 */
function inorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];

  /**
   * Auxiliary function to perform in-order traversal recursively.
   * @param node - The current node in the binary tree.
   */
  function inorder(node: TreeNode | null): void {
    if (node === null) {
      return;
    }
    inorder(node.left); // Recursively visit left subtree first
    answer.push(node.val); // Visit root node
    inorder(node.right); // Recursively visit right subtree last
  }

  inorder(root); // Start the traversal from the root
  return answer; // Return the result of the in-order traversal
};
