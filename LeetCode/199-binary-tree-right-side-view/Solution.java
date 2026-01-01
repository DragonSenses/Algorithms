import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightside = new ArrayList<>();
    if (root == null) return rightside;

    Queue<TreeNode> nextLevel = new LinkedList<>();
    nextLevel.add(root);

    while (!nextLevel.isEmpty()) {
      Queue<TreeNode> currLevel = nextLevel;
      nextLevel = new LinkedList<>();
      TreeNode node = null;

      while (!currLevel.isEmpty()) {
        node = currLevel.poll();

        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }

      rightside.add(node.val);
    }

  }
}