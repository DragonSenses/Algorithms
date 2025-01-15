function jump(nums: number[]): number {
  let curEnd = 0;
  let curFar = 0;
  let jumps = 0;

  for (let i = 0; i < nums.length - 1; i++) {
    curFar = Math.max(curFar, i + nums[i]);

    if (i === curEnd) {
      jumps++;
      curEnd = curFar;

      if (curEnd >= nums.length - 1) {
        break;
      }
    }
  }

  return jumps;
}
