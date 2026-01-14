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

  }
}