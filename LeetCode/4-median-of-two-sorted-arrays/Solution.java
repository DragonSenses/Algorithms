class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    /* 1. Algorithm assumes nums1 is smaller, swap them if this is not the case */

    /* 2. Define the search space for partitioning index by setting boundaries */
    
    // Take the respective lengths of both arrays

    // Set left boundary to 0, and right boundary to length of smallest array


    /* 3. While the boundaries are within limits */
      /* 4. Compute the partition index of nums1 & nums 2.
       * - nums1: partitionA = (left + right) / 2 
       * - nums2: partitionB = [(m + n + 1) / 2] - partitionA 
       */


      /* 5. Obtain the edge elements: maxLeftA, minRightA, maxLeftB, minRightB.
       *  - Determine the maximum value of the section A_left as maxLeftA = nums1[partitionA - 1]. 
       *      - If partitionA - 1 < 0, set it as maxLeftA = float(-inf).
       *  - Determine the minimum value of the section A_right as minRightA = nums1[partitionA].
       *      - If partitionA >= m, set it as minRightA = float(inf).
       *  - Determine the maximum value of the section B_left as maxLeftB = nums2[partitionB - 1].
       *      - If partitionB - 1 < 0, set it as maxLeftB = float(-inf).
       *  - Determine the maximum value of the section B_right as minRightB = nums2[partitionB]. 
       *      - If partitionB >= n, set it as minRightB = float(inf).
       */
      
       /* 6. Compare and recalculate: Compare maxLeftA with minRightB and maxLeftB with minRightA. 
        *  - If maxLeftA > minRightB, it means the maxLeftA is too large to be in the smaller half, 
        *   so we update right = partitionA - 1 to move to the left half of the search space.
        *  - If maxLeftB > minRightA, it means that we are too far on the left side for partitionA 
        *   and we need to go to the right half of the search space by updating left = partitionA + 1.
        */

       /* 7. When both maxLeftA <= minRightB and maxLeftB <= minRightA are true: 
        *   - If (m + n) % 2 = 0, the median value is the average of the 
        * maximum value of the smaller half and the minimum value of the larger half, 
        * given by answer = (max(maxLeftA, maxLeftB) + min(minRightA, minRightB)) / 2.
        *
        *   - Otherwise, the median value is the maximum value of the smaller half, 
        *   given by answer = max(maxLeftA, maxLeftB).
        *
        */


  }
}