package zl.math.leetcode;

/**
 * Description: 算法题目 水桶装水题目
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/28 22:18 by zl 创建
 **/
public class LeetCode_11 {

    public int maxArea(int[] height) {
        if (null == height || height.length <= 0) {
            return 0;
        }
        int start = 0;
        int max = height.length - 1;
        int maxArea = 0;
        while (start < max) {
            maxArea = Math.max(maxArea, Math.min(height[start], height[max]) * (max - start));
            if (height[start] < height[max]) {
                start++;
            } else {
                max--;
            }
        }
        return maxArea;
    }
}
