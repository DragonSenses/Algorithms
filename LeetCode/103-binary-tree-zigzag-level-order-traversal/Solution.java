import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // Result list to store the zigzag level order traversal
    List<List<Integer>> result = new ArrayList<>();
    // Start the recursive traversal
    traverse(root, 0, result);
    return result;
  }

  private void traverse(TreeNode node, int level, List<List<Integer>> result) {
    if (node == null) {
      return; // Base case: No node to process
    }

    // If the result list doesn't have a list for the current level, create it
    if (result.size() <= level) {
      result.add(new LinkedList<>());
    }

    // Add the node's value to the correct list based on the zigzag direction
    if (level % 2 == 0) {
      // Even level (left-to-right), add to the end of the list
      result.get(level).add(node.val);
    }
  }
}