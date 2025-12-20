var solution = function (isBadVersion: (version: number) => boolean) {
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

  };
};
