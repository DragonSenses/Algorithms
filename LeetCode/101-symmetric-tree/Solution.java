class Solution {
  public boolean isSymmetric(TreeNode root) {
    // An empty tree is symmetric
    if (root == null) {
      return true;
    }
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode left, TreeNode right) {
    // Base cases
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }

    if (left.val != right.val) {
      return false;
    }

    // Recursively check if:
    // 1. The left child of the left subtree is a mirror of the right child of the right subtree
    // 2. The right child of the left subtree is a mirror of the left child of the right subtree
    return isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }
}
