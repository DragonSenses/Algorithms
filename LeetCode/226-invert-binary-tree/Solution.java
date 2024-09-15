class Solution {
  /**
   * Inverts a binary tree by swapping the left and right children of all nodes.
   *
   * @param root the root of the binary tree
   * @return the root of the inverted binary tree
   */
  public TreeNode invertTree(TreeNode root) {
    // Base case: If the current node is null, return null
    if (root == null) {
      return null;
    }

    // Swap the left and right children
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Recursively invert the left and right subtrees
    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}
