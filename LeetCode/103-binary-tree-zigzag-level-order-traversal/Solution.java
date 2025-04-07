import java.util.ArrayList;
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

  }
}