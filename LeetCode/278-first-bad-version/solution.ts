var solution = function (isBadVersion: (version: number) => boolean) {
  return function (n: number): number {
    let left: number = 1;
    let right: number = n;

    while (left < right) {
      // Safe midpoint calculation to avoid overflow
      const mid: number = left + Math.floor((right - left) / 2);

    }

  };
};
