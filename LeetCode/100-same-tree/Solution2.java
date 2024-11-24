class Solution2 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // Base case: Both trees are null
    if (p == null && q == null) {
      return true;
    }
    // Base case: One tree is null and the other is not
    if (p == null || q == null) {
      return false;
    }
    // If the values of the nodes are not equal
    if (p.val != q.val) {
      return false;
    }
    // Recursively check the left and right subtrees
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}