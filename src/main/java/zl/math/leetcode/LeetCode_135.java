package zl.math.leetcode;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Description: 分糖果问题
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/4/1 16:50 by zl 创建
 **/
public class LeetCode_135 {
    public static void main(String[] args) {
        LeetCode_135 leetCode135 = new LeetCode_135();
        int ans = leetCode135.candyV1(new int[]{1, 2, 2});
        assertThat(ans, equalTo(3));
    }


    //TODO 最优解 不需要辅助数组 left 和right 。直接使用ratings 数组和几个有限的变量就能处理
    public int candyV1(int[] ratings) {
        if(Objects.isNull(ratings) || ratings.length <= 0){
            return 0;
        }
        int length = ratings.length;
        int[] left = new int[length];
        for (int i = 1; i < length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            //保证与自己不会比相邻的孩子拿糖少
            ans += Math.max(left[i], right[i]);
        }
        return ans + length;
    }


}
