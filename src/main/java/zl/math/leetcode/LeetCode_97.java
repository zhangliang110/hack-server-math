package zl.math.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Description:
 * <p>
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings
 * respectively, such that:
 * <p>
 * ex:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Explanation: One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 * <p>
 * ex:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 * <p>
 * ex:
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * <p>
 * Copyright (c) Feifan
 * <p>
 * <p>
 * 属于：动态规划 样本对应模型
 *
 * @version 1.0 2023/4/1 18:08 by zl 创建
 **/
public class LeetCode_97 {
    public static void main(String[] args) {
        String s1 = "", s2 = "", s3 = "a";
        LeetCode_97 leetCode97 = new LeetCode_97();
        boolean interleave = leetCode97.isInterleave(s1, s2, s3);
        assertThat(interleave, equalTo(true));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (str1[i - 1] != str3[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (str2[j - 1] != str3[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        //dp[i][j] 表示 str1 拿出前 i 个字母 能与 str2 拿出前j 个字母 组成 str3 前 i+j 字母的答案。
        //所以dp[i][j] = dp[i -1][j] && str[i - 1] == str3[i-1+j] || dp[i][j-1] && str2[j-1] ==str3[j-1 + i]
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((str1[i - 1] == str3[i - 1 + j] && dp[i - 1][j]) || (str2[j - 1] == str3[j - 1 + i] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[str1.length][str2.length];
    }


}

