package array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * （26题的变形版本）
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Given nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * @author DanielQSL
 * @date 2019/2/19
 */
public class RemoveDuplicatesfromSortedArrayII {

    /**
     * 思路：
     * 与26题思路一致，同时是Two Pointer。
     * 由于题意是重复不能超过两个，那我们的第一个指针可以直接从2开始，
     * 因为前两个肯定会留下来，之后的数值，与i-2的位置进行比较，是否相同
     * <p>
     * time:O(n)
     * space:O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }

        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
