package zl.math.leetcode;

import java.util.Arrays;

/**
 * Description :
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.04.24 13:19
 */
public class LeetCode_16 {
    public static void main(String[] args) {
        LeetCode_16 leetCode16 = new LeetCode_16();
        int closest = leetCode16.threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2);
        System.out.println(closest);
    }

    public int threeSumClosest(int[] nums, int target) {
        //首先排序
        Arrays.sort(nums);
        int arrLength = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < arrLength - 2; i++) {
            for (int j = i + 1, k = arrLength - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    j++;
                }
                if (sum > target) {
                    k--;
                }
                int diff = Math.abs(target -sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}
