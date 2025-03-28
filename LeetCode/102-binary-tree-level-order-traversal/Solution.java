import java.util.ArrayList;
import java.util.List;

class Solution {
  // List to hold the levels
  List<List<Integer>> levels = new ArrayList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    // Edge case: Return empty list if the tree is empty
    if (root == null) {
      return levels;
    }

    return levels;
  }

  private void traverseLevels(TreeNode node, int level) {
    // Base case: if the node is null, return
    if (node == null) {
      return;
    }

    // Ensure the levels list has a sublist for the current level
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

  }
}
