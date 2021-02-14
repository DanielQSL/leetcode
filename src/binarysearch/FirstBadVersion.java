package binarysearch;

/**
 * 278. 第一个错误的版本
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 *
 * @author DanielQSL
 * @date 2019/2/20
 */
public class FirstBadVersion {

    /**
     * 思路：
     * 使用二分查找进行判断
     * 需要注意的是：如果发现当前版本是好的，则需要将left指向mid的下一个位置。
     * <p>
     * Time: O(logn)
     * Space: O(1)
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // 找到中间索引。由于(left+right)/2会有整数溢出的情况，故用一下方法代替
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static boolean isBadVersion(int version) {
        return true;
    }
}
