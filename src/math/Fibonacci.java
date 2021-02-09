package math;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author qianshuailong
 * @date 2021/2/9
 */
public class Fibonacci {

    /**
     * 递归实现
     * 缺点：当n比较大时，会有很多重复计算，效率低下
     */
    public int fibonacciV1(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciV1(n - 1) + fibonacciV1(n - 2);
    }

    /**
     * 非递归方式实现
     * 为什么要模1000000007。参考https://www.liuchuo.net/archives/645。
     * 大数阶乘，大数的排列组合等为什么要取模：
     * 1000000007是一个质数（素数），对质数取余能最大程度避免冲突
     * int32位的最大值为2147483647，所以对于int32位来说1000000007足够大。
     * int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出。
     * 所以在大数相乘的时候，因为(a∗b)%c=((a%c)∗(b%c))%c，所以相乘时两边都对1000000007取模，再保存在int64里面不会溢出。
     */
    public int fibonacciV2(int n) {
        if (n < 2) {
            return n;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            // 在循环的过程中即进行取模处理，以防止大数溢出
            result = (first + second) % 1000000007;
            first = second;
            second = result;
        }
        return result;
    }
}
