package binarysearch;

/**
 * 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * @author DanielQSL
 * @date 2019/2/20
 */
public class SearchInsertPosition {

    /**
     * 思路：
     * 使用二分查找。
     * 需要注意临界值
     *
     * Time: O(logn)
     * Space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low)>>1);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (target > nums[low]) {
            return low + 1;
        } else {
            return low;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        searchInsert(nums, 7);
    }
}
