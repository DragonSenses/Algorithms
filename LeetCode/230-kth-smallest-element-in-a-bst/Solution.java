class Solution {
  private int count = 0;
  private int result = -1;

  public int kthSmallest(TreeNode root, int k) {
    return -1;
  }

  private void inorder(TreeNode node, int k) {
    if (node == null || result != -1) {
      return;
    }

    inorder(node.left, k);

    count++;
    if (count == k) {
      result = node.val;
      return;
    }

  }
}
