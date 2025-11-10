/**
 * Class representing a tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  /**
   * Creates an instance of TreeNode.
   * @param {number} [val=0] - The value of the node.
   * @param {TreeNode | null} [left=null] - The left child of the node.
   * @param {TreeNode | null} [right=null] - The right child of the node.
   */
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Finds the kth smallest element in a Binary Search Tree (BST).
 * Assumes the BST property: left subtree < root < right subtree.
 * Uses recursive inorder traversal to visit nodes in ascending order.
 *
 * @param root - The root node of the BST.
 * @param k - The 1-indexed position of the desired smallest element.
 * @returns The value of the kth smallest node.
 */
function kthSmallest(root: TreeNode | null, k: number): number {
  // Tracks how many nodes have been visited so far
  let count = 0;

  // Stores the kth smallest value once found
  let result = -1;

  /**
   * Performs recursive inorder traversal (left → root → right).
   * Stops early once the kth smallest element is found.
   *
   * @param node - The current node being visited.
   */
  function inorder(node: TreeNode | null): void {
    // Base case: null node or early exit if result already found
    if (!node || result !== -1) return;

    // Traverse left subtree first
    inorder(node.left);

    // Visit current node
    count++;
    if (count === k) {
      result = node.val; // Found kth smallest
      return;
    }

    // Traverse right subtree
    inorder(node.right);
  }

  // Start traversal from root
  inorder(root);

  // Return the result after traversal
  return result;
}
