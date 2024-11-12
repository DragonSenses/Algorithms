import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class Solution {

  /**
   * Method to perform an iterative preorder traversal of a binary tree.
   * 
   * @param root The root node of the binary tree.
   * @return A list of integers representing the preorder traversal.
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    // List to store the result of the traversal.
    List<Integer> answer = new ArrayList<>();
    // Stack to store nodes to be visited.
    Stack<TreeNode> stack = new Stack<>();

    // If the root is not null, push it onto the stack.
    if (root != null) {
      stack.push(root);
    }

    // Loop until there are nodes to be processed in the stack.
    while (!stack.isEmpty()) {
      // Pop the top node from the stack.
      TreeNode currNode = stack.pop();
      if (currNode != null) {
        // Add the value of the current node to the answer list.
        answer.add(currNode.val);
        // Push the right child of the current node onto the stack (if it exists).
        if (currNode.right != null) {
          stack.push(currNode.right);
        }
        // Push the left child of the current node onto the stack (if it exists).
        if (currNode.left != null) {
          stack.push(currNode.left);
        }
      }
    }

    // Return the result list containing the preorder traversal.
    return answer;
  }
}
