public class Solution {
  // Initialize the diameter variable to track the longest path
  private int diameter = 0;

  /**
   * Main method to find the diameter of the binary tree.
   *
   * @param root The root node of the binary tree.
   * @return The diameter of the binary tree.
   */
  public int diameterOfBinaryTree(TreeNode root) {
    longestPath(root);
    return diameter;
  }

  /**
   * Recursive method to find the longest path from the given node to a leaf.
   *
   * @param node The current node being processed.
   * @return The longest path from the node to a leaf node.
   */
  private int longestPath(TreeNode node) {
    // Base case: If the node is null, return 0
    if (node == null) {
      return 0;
    }

    // Recursively find the longest paths of the left and right children
    int leftPath = longestPath(node.left);
    int rightPath = longestPath(node.right);

    // Update the diameter if the sum of leftPath and rightPath is larger
    diameter = Math.max(diameter, leftPath + rightPath);

    // Return the longer path plus 1
    return Math.max(leftPath, rightPath) + 1;
  }
}
