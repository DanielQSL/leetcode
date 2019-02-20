package binarysearch;

/**
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
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
     *
     * Time: O(logn)
     * Space: O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            //找到中间索引
            int mid = left + (right - left) >> 1;

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
