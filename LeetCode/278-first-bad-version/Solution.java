/**
 * Solution class that extends VersionControl to determine the first bad version.
 *
 * This class uses a binary search approach to minimize the number of calls to the isBadVersion API.
 * The algorithm narrows down the search space by checking the midpoint of the current interval
 * until the first bad version is found.
 */
public class Solution extends VersionControl {

  /**
   * Finds the first bad version among versions 1 through n.
   *
   * The method applies binary search: - If isBadVersion(mid) is true, the first bad version lies in
   * [left, mid]. - If isBadVersion(mid) is false, the first bad version lies in [mid + 1, right].
   *
   * The loop continues until left == right, at which point both pointers converge on the first bad
   * version.
   *
   * @param n the total number of versions
   * @return the version number of the first bad version
   */
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right) {
      // Safe midpoint calculation to avoid integer overflow
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
