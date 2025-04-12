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

  }
}
