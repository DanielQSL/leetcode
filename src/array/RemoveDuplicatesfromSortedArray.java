package array;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * @author DanielQSL
 * @date 2019/2/19
 */
public class RemoveDuplicatesfromSortedArray {

    /**
     * 思路：
     * 与27题一样。Two Pointer。一个从头遍历，一个记录符合条件的值。
     *
     * time:O(n)
     * space:O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //因为第一个数肯定要保留，所以计数从1开始
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
