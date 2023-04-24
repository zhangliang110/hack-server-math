package zl.math.leetcode.easy;

import java.util.Arrays;

/**
 * Description : 
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.04.24 17:10
 */
public class LeetCode_27 {
    public static void main(String[] args) {
        LeetCode_27 leetCode27 = new LeetCode_27();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = leetCode27.removeElement(nums, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int notEqualNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[notEqualNum] = nums[i];
                notEqualNum++;
            }
        }
        return notEqualNum;
    }
}
