/**
 * Creates a function that determines the first bad version using the provided API.
 *
 * The returned function applies a binary search strategy to minimize calls to
 * `isBadVersion`. Since all versions after a bad version are also bad, the search
 * space can be halved each iteration until the first bad version is found.
 *
 * @param isBadVersion - A function that returns true if the given version is bad.
 * @returns A function that, given `n`, returns the first bad version in the range [1, n].
 */
var solution = function (isBadVersion: (version: number) => boolean) {
  /**
   * Finds the first bad version among versions 1 through n.
   *
   * Uses binary search:
   * - If `isBadVersion(mid)` is true, the first bad version lies in [left, mid].
   * - If false, it lies in [mid + 1, right].
   *
   * The loop terminates when `left === right`, which is the first bad version.
   *
   * @param n - Total number of versions.
   * @returns The version number of the first bad version.
   */
  return function (n: number): number {
    let left: number = 1;
    let right: number = n;

    while (left < right) {
      // Safe midpoint calculation to avoid overflow
      const mid: number = left + Math.floor((right - left) / 2);

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
  };
};
