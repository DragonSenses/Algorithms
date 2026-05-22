import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean hasCycle(ListNode head) {
    Set<ListNode> visited = new HashSet<>();
    while (head != null) {
      if (visited.contains(head)) {
        return true;
      }

    }
  }
}