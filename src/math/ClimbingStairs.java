package math;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * @author qianshuailong
 * @date 2021/2/9
 */
public class ClimbingStairs {

    /**
     * 斐波那契数列
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int climbingStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列优化版
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int climbingStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 题目做了修改（限制条件做了修改，加了第二个限制条件）： 1、每次你可以爬 1 或 2 个台阶。 2、不能连续跳两个台阶
     */
    public int climbingStairsChange(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

}
