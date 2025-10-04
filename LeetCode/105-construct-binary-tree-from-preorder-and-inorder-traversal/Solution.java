import java.util.HashMap;
import java.util.Map;

class Solution {
  private int preorderIndex = 0;
  private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }
    return null;
  }

}
