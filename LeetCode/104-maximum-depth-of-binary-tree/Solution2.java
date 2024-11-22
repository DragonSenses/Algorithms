public class Solution2 {
  /**
   * Finds the maximum depth of a binary tree using the recursive approach.
   *
   * @param root The root node of the binary tree.
   * @return The maximum depth of the binary tree.
   */
  public int maxDepth(TreeNode root) {
    // Base case: if the current node is null, the depth is 0
    if (root == null) {
      return 0;
    }

    // Recursively find the maximum depth of the left subtree
    int leftDepth = maxDepth(root.left);

    // Recursively find the maximum depth of the right subtree
    int rightDepth = maxDepth(root.right);

    // The depth of the current node is the greater of the depths of its subtrees
    // plus one
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
