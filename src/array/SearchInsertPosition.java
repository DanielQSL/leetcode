package array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * @author qianshuailong
 * @date 2021/2/20
 */
public class SearchInsertPosition {

    /**
     * 循环暴力解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 分别处理如下三种情况
            // 目标值在数组所有元素之前
            // 目标值等于数组中某一个元素
            // 目标值插入数组中的位置
            if (target <= nums[i]) {
                return i;
            }
        }
        // 目标值在所有数组最后
        return nums.length;
    }

    /**
     * 二分查找
     * （注意边界）
     */
    public int searchInsertV2(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (nums[length - 1] < target) {
            return length;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
