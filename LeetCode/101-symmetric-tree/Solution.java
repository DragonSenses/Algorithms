class Solution {
  public boolean isSymmetric(TreeNode root) {
    // An empty tree is symmetric
    if (root == null) {
      return true;
    }
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode left, TreeNode right) {

  }
}
