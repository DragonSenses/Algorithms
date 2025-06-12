import java.util.ArrayList;
import java.util.List;

class Solution3 {
  public List<Integer> grayCode(int n) {
    int sequenceLength = 1 << n;
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < sequenceLength; i++) {
      result.add(i ^ (i >> 1));
    }

    return result;
  }
}