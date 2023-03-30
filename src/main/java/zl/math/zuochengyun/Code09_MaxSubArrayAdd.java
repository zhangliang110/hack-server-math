package zl.math.zuochengyun;

/**
 * Description: 最大子数组累加和
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/29 22:56 by zl 创建
 **/
public class Code09_MaxSubArrayAdd {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, -1, 10};
        int total = maxSubArrayAdd(arr);
        System.out.println(total);
    }

    /**
     * 最大子数组累加和
     *
     * @param array 给定数组
     * @create 2023/3/29 22:57 张亮
     */
    public static int maxSubArrayAdd(int[] array) {
        if (null == array || array.length <= 0) {
            return 0;
        }
        int length = array.length;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < length; i++) {
            cur += array[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    /**
     * 最大子数组累加和
     *
     * @param array 给定数组
     * @create 2023/3/29 22:57 张亮
     */
    public static int maxSubArrayAddV2(int[] array) {
        if (null == array || array.length <= 0) {
            return 0;
        }
        int length = array.length;
        int max = array[0];
        int pre = array[0];
        for (int i = 1; i < length; i++) {
            //i 位置假定有最大的子数组的话，那可能性有： 1 和前面的值的最大子数组相加得到最大。 2 自己一个数的数组组成最大
            pre = Math.max(array[i] + pre, array[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
