function majorityElement(nums: number[]): number {
  const frequencyMap = new Map<number, number>();
  const threshold = Math.floor(nums.length / 2);

  for (const num of nums) {
    const count = (frequencyMap.get(num) || 0) + 1;
    frequencyMap.set(num, count);
  }

}