import java.util.HashMap;
import java.util.Map;

/**
 * Constructs a binary tree from preorder and inorder traversal arrays.
 */
class Solution {
  /**
   * Tracks the current index in the preorder array.
   */
  private int preorderIndex = 0;

  /**
   * Maps each value in the inorder array to its index for fast lookup.
   */
  private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

  /**
   * Builds the binary tree from preorder and inorder traversal arrays.
   *
   * @param preorder the preorder traversal of the tree
   * @param inorder the inorder traversal of the tree
   * @return the root node of the reconstructed binary tree
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Build a hashmap to store value -> index relations for inorder traversal
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }
    return arrayToTree(preorder, 0, inorder.length - 1);
  }

  /**
   * Recursively constructs the binary tree using preorder and inorder boundaries.
   *
   * @param preorder the preorder traversal array
   * @param left the left boundary index in inorder
   * @param right the right boundary index in inorder
   * @return the root node of the current subtree
   */
  private TreeNode arrayToTree(int[] preorder, int left, int right) {
    // If there are no elements to construct the tree
    if (left > right) {
      return null;
    }

    // Select the preorderIndex element as the root and increment it
    int rootValue = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootValue);

    // Build left and right subtree
    // Exclude inorderIndexMap.get(rootValue) element because it's the root
    int rootIndex = inorderIndexMap.get(rootValue);
    root.left = arrayToTree(preorder, left, rootIndex - 1);
    root.right = arrayToTree(preorder, rootIndex + 1, right);

    return root;
  }
}
