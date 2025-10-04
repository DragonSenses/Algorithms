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

  private TreeNode arrayToTree(int[] preorder, int left, int right) {
    if (left > right) {
      return null;
    }

    int rootValue = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootValue);

    int rootIndex = inorderIndexMap.get(rootValue);
    root.left = arrayToTree(preorder, left, rootIndex - 1);
    root.right = arrayToTree(preorder, rootIndex + 1, right);

    return root;
  }

}
