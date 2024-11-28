import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Solution class to perform an iterative in-order traversal of a binary tree.
 */
public class Solution {

  /**
   * Performs in-order traversal of a binary tree.
   * 
   * @param root The root of the binary tree.
   * @return A list containing the in-order traversal of the tree.
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      // Traverse the left subtree
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      // Visit the node
      current = stack.pop();
      result.add(current.val);

      // Traverse the right subtree
      current = current.right;
    }

    return result;
  }
}
