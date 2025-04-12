/**
 * Solution class to check if a binary tree is symmetric.
 */
class Solution {

  /**
   * Determines whether a binary tree is symmetric around its center.
   *
   * @param root The root of the binary tree.
   * @return True if the tree is symmetric, false otherwise.
   */
  public boolean isSymmetric(TreeNode root) {
    // An empty tree is symmetric
    if (root == null) {
      return true;
    }
    // Check if the left and right subtrees are mirror reflections
    return isMirror(root.left, root.right);
  }

  /**
   * Auxiliary function to check if two subtrees are mirror reflections of each other.
   *
   * @param left The root of the left subtree.
   * @param right The root of the right subtree.
   * @return True if the two subtrees are mirrors, false otherwise.
   */
  private boolean isMirror(TreeNode left, TreeNode right) {
    // Base cases
    // Both subtrees are empty
    if (left == null && right == null) {
      return true;
    }

    // One subtree is empty
    if (left == null || right == null) {
      return false;
    }

    // Root values of the subtrees do not match
    if (left.val != right.val) {
      return false;
    }

    // Recursively check if:
    // 1. The left child of the left subtree is a mirror of the right child of the right subtree
    // 2. The right child of the left subtree is a mirror of the left child of the right subtree
    return isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }
}
