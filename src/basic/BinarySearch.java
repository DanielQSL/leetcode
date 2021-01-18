package basic;

/**
 * 二分查找写法
 *
 * @author qianshuailong
 * @date 2020/11/3
 */
public class BinarySearch {

    /**
     * 常规二分查找
     * 「搜索区间」即 [left, right]
     * 缺陷：无法探求左侧（右侧）边界值。例如，有序数组 nums = [1,2,2,2,3]，target = 2，此算法返回的索引是 2，没错。但是如果我想得到 target 的左侧边界
     *
     * @param nums
     * @param target
     * @return
     */
    private static int findBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return -1;
    }

}
