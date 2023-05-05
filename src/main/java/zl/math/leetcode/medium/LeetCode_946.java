package zl.math.leetcode.medium;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;

import java.util.Stack;

/**
 * Description : 基于栈的题目 先进后出
 * 1,2 ,3,4,5
 * 2,4,3,1,5
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.05.04 17:23
 */
public class LeetCode_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        LeetCode_946 leetCode_946 = new LeetCode_946();
        boolean result = leetCode_946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        MatcherAssert.assertThat(result, IsEqual.equalTo(true));
    }
}
