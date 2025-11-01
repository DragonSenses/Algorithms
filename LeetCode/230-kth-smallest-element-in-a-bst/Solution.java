/**
 * Solution class to find the kth smallest element in a Binary Search Tree (BST).
 * Uses recursive inorder traversal to visit nodes in ascending order.
 */
class Solution {
  // Tracks how many nodes have been visited during inorder traversal
  private int count = 0;

  // Stores the kth smallest value once found
  private int result = -1;

  /**
   * Returns the kth smallest element in the BST.
   *
   * @param root the root node of the BST
   * @param k the 1-indexed position of the desired smallest element
   * @return the value of the kth smallest node
   */
  public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return result;
  }

  /**
   * Performs recursive inorder traversal to find the kth smallest element.
   * Traverses left subtree, processes current node, then right subtree.
   * Stops early once the kth element is found.
   *
   * @param node the current node being visited
   * @param k the target position of the smallest element
   */
  private void inorder(TreeNode node, int k) {
    // Base case: null node or early exit if result already found
    if (node == null || result != -1) {
      return;
    }

    // Traverse left subtree first (inorder: left → root → right)
    inorder(node.left, k);

    // Process current node
    count++;
    if (count == k) {
      result = node.val; // Found kth smallest element
      return;
    }

    // Traverse right subtree
    inorder(node.right, k);
  }
}