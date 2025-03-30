import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>(); // Initialize levels list

    // Edge case: If the tree is empty, return an empty list
    if (root == null) {
      return levels;
    }

    Queue<TreeNode> queue = new LinkedList<>(); // Initialize the queue
    queue.add(root); // Add the root node to the queue

    return null;
  }
}
