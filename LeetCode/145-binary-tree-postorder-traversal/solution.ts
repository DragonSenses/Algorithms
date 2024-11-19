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
 * Performs a recursive postorder traversal of a binary tree.
 *
 * @param root - The root node of the binary tree.
 * @returns An array of numbers representing the postorder traversal.
 */
function postorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];

  /**
   * Helper function to perform the postorder traversal recursively.
   *
   * @param node - The current node being visited.
   */
  function postorder(node: TreeNode | null): void {
    // Base case: If the node is null, return
    if (node === null) {
      return;
    }

    // Recursively traverse the left subtree
    postorder(node.left);

    // Recursively traverse the right subtree
    postorder(node.right);

    // Add the current node's value to the result list
    answer.push(node.val);
  }

  // Start the postorder traversal from the root
  postorder(root);
  return answer;
}
