public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right) {
      // Safe midpoint calculation to avoid overflow
      int mid = left + (right - left) / 2;

    }

  }
}
