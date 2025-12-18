public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right) {
      // Safe midpoint calculation to avoid overflow
      int mid = left + (right - left) / 2;

      if (isBadVersion(mid)) {
        // Mid could be the first bad version, so keep it
        right = mid;
      } else {
        // Mid is good, so the first bad must be after mid
        left = mid + 1;
      }
    }

    // At termination, left == right and points to the first bad version
    return left;
  }
}
