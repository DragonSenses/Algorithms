import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a node in a binary tree.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  /**
   * Constructor to initialize a TreeNode.
   * 
   * @param val The value of the node.
   */
  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class Solution3 {

  /**
   * Method to perform a Morris preorder traversal of a binary tree.
   * 
   * @param root The root node of the binary tree.
   * @return A list of integers representing the preorder traversal.
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    // List to store the result of the traversal
    List<Integer> answer = new ArrayList<>();
    // Start with the root node
    TreeNode curr = root;

    // Iterate until we have visited all nodes
    while (curr != null) {
      // If there is no left child, add the current node's value and move to the right
      // child
      if (curr.left == null) {
        answer.add(curr.val);
        curr = curr.right;
      } else {
        // Find the rightmost node in the left subtree
        TreeNode last = curr.left;
        while (last.right != null && last.right != curr) {
          last = last.right;
        }

        // If the rightmost node's right pointer is null, set it to the current node,
        // add the current node's value, and move to the left child
        if (last.right == null) {
          last.right = curr;
          answer.add(curr.val);
          curr = curr.left;
        } else {
          // If the rightmost node's right pointer is already pointing to the current
          // node, reset it to null and move to the right child
          last.right = null;
          curr = curr.right;
        }
      }
    }

    // Return the result list containing the preorder traversal
    return answer;
  }
}
