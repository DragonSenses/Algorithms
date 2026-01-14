import java.util.ArrayList;
import java.util.List;

class Solution2 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightside = new ArrayList<>();
    dfs(root, 0, rightside);
    return rightside;
  }

  private void dfs(TreeNode node, int depth, List<Integer> rightside) {
    if (node == null) return;

    if (depth == rightside.size()) {
      rightside.add(node.val);
    }

    dfs(node.right, depth + 1, rightside);
    dfs(node.left, depth + 1, rightside);
  }
}