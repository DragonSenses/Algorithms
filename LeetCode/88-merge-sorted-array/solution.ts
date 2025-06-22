function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  // Step 1: Copy the first m elements of nums1
  const nums1Copy = nums1.slice(0, m);

    // Step 2: Initialize pointers
  let p1 = 0; // Pointer for nums1Copy
  let p2 = 0; // Pointer for nums2
  let p = 0;  // Write pointer for nums1

  // Step 3: Merge nums1Copy and nums2 into nums1
  while (p1 < m && p2 < n) {
    if (nums1Copy[p1] <= nums2[p2]) {
      nums1[p++] = nums1Copy[p1++];
    } else {
      nums1[p++] = nums2[p2++];
    }
  }
};