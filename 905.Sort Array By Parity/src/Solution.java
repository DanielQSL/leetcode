/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * @author DanielQSL
 * @date 2019/1/7
 */
public class Solution {

    /**
     * 思路一：
     * 定义一个新数组，偶数放在新数组的前面，奇数放在新数组的最后
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityOne(int[] A) {
        int[] arr = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                arr[begin++] = A[i];
            } else {
                arr[end--] = A[i];
            }
        }
        return arr;
    }

    /**
     * 思路二：
     * （不适用新数组，来完成目的）in-place
     * 保持两个指针i和j，循环变量j，将偶数值的索引与当前值的索引进行互换
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityTwo(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
