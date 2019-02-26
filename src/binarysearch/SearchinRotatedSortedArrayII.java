package binarysearch;

/**
 * 81. Search in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * @author DanielQSL
 * @date 2019/2/25
 */
public class SearchinRotatedSortedArrayII {

    /**
     * 思路：
     * 如果target比A[mid]值要小
     * 如果A[mid]右边有序（A[mid]<A[high])
     * 那么target肯定不在右边（target比右边的都得小），在左边找
     * 如果A[mid]左边有序
     * 那么比较target和A[low]，如果target比A[low]还要小，证明target不在这一区，去右边找；反之，左边找。
     * 如果target比A[mid]值要大
     * 如果A[mid]左边有序（A[mid]>A[low]）
     * 那么target肯定不在左边（target比左边的都得大），在右边找
     * 如果A[mid]右边有序
     * 那么比较target和A[high]，如果target比A[high]还要大，证明target不在这一区，去左边找；反之，右边找。
     * <p>
     * Time: O(logn)
     * Space: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target < nums[mid]) {
                if (nums[mid] < nums[high]) {
                    high = mid - 1;
                } else {
                    if (target < nums[low]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else if (target > nums[mid]) {
                if (nums[mid] > nums[low]) {
                    low = mid + 1;
                } else {
                    if (target > nums[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
