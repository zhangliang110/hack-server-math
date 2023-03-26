package zl.math.zuochengyun;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 494
 * Description: 给定一个数组arr （整数序列），你可以在每个数字之前决定 + 或者 - 但是必须所有数字都参与 。再给定一个target，请问最后算出target的方法数是多少？
 * Copyright (c) Feifan
 * <p>
 * <p>
 * 优化点： 1 数组的符号不影响结果 毕竟可以选择+ 或 -
 * 2 非负的相加 不能大于 target 不然 结果为0
 * 3 sum 和target 的奇 偶 性必须一致
 * 4 结果转换 求 target 等于 求数组中有集合P  集合P中的数相加 = (target + sum) / 2
 * 5 二维动态规划的空间压缩技巧
 *
 * @version 1.0 2023/3/15 21:13 by zl 创建
 **/
public class Code7_calculateTarget {

    static Map<String, Integer> targetMap = new HashMap<>();

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 5, 10};
        int total = findTargetSumWayFinal(ints, 10);
        System.out.println(total);
    }

    /**
     * @param target 目标值
     * @param nums   提供的数组
     * @return
     * @create 2023/3/20 22:49 张亮
     */
    public static int calculateTarget(int[] nums, int target) {
        return simpleCalculateTarget(nums, 0, target);
    }

    //暴力解法，计算每一种情况，使用递归如果最终能等于target算一种解法
    public static int simpleCalculateTarget(int[] nums, int index, int target) {
        String pathKey = index + "_" + target;
        if (targetMap.containsKey(pathKey)) {
            return targetMap.get(pathKey);
        }
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        //节省后面 不可能存在等于target的情况
        int absSum = 0;
        for (int i = index; i < nums.length; i++) {
            absSum += Math.abs(nums[i]);
        }
        if (absSum < target) {
            return 0;
        }
        int res = simpleCalculateTarget(nums, index + 1, target - nums[index]) + simpleCalculateTarget(nums, index + 1, target + nums[index]);
        targetMap.put(pathKey, res);
        return res;

    }

    /**
     * 最终优化方案
     *
     * @return
     * @create 2023/3/20 23:39 张亮 a
     */
    public static int findTargetSumWayFinal(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            //nums 可以取绝对值变为非负数
            sum += n;
        }
        return sum < target || ((target & 1) ^ (sum & 1)) != 0 ? 0 : subSet(nums, (sum + target) / 2);
    }

    public static int subSet(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];

    }

}
