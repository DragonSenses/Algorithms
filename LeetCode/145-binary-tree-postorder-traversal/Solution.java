import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    if (root == null) {
      return answer;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    Deque<TreeNode> output = new ArrayDeque<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode currNode = stack.pop();
      output.push(currNode);

      if (currNode.left != null) {
        stack.push(currNode.left);
      }
      if (currNode.right != null) {
        stack.push(currNode.right);
      }
    }

    while (!output.isEmpty()) {
      answer.add(output.pop().val);
    }

    return answer;
  }

  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}