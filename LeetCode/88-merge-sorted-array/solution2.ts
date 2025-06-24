function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  let p1 = m - 1; // Last element in nums1
  let p2 = n - 1; // Last element in nums2
  let p = m + n - 1; // Last position in nums1

  // Merge from the back
  while (p1 >= 0 && p2 >= 0) {
    if (nums1[p1] > nums2[p2]) {
      nums1[p--] = nums1[p1--];
    } else {
      nums1[p--] = nums2[p2--];
    }
  }


}
