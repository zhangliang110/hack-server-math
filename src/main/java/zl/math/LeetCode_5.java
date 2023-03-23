package zl.math;

/**
 * Description : 
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.03.22 13:54
 */
public class LeetCode_5 {
    public static void main(String[] args) {
        String aba = longestPalindromeV2("ababb");
        System.out.println(aba);
    }

    /**
     * 查询最长回文
     * i j 分别是两个方向的index
     * 则有 dp[j][i] = dp[j][i]
     * 那么求 dp[0][length] = dp[length][0]
     *
     * @author ff_wind_zl
     * @date 2023-03-22 13:55
     **/
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0 || length == 1) {
            return s;
        }
        String res = "";
        boolean[][] dp = new boolean[length][length];
        for (int gap = 0; gap < length; gap++) {
            for (int i = 0; i + gap < length; i++) {
                int j = i + gap;
                if (gap == 0) {
                    // 0
                    dp[i][j] = true;
                } else if (gap == 1) {
                    //
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
                        //说明是回文
                        dp[i][j] = true;
                    }
                }
                //取最长的结果
                if (dp[i][j] && gap + 1 > res.length()) {
                    res = s.substring(i, i + gap + 1);
                }
            }
        }
        return res;
    }

    static int lo, maxLen;

    /**
     * @description 第二种解法
     * @param str 字符串
     * @author ff_wind_zl
     * @date 2023-03-23 15:19
     **/
    public static String longestPalindromeV2(String str) {
        int length = str.length();
        if (length < 2) {
            return str;
        }
        for (int i = 0; i < length; i++) {
            //区分字符串长度 奇数和偶数的情况
            //已i为中心两边找
            searchPalindrome(str, i, i);
            //已i 和i+1 为中心两边找
            searchPalindrome(str, i, i + 1);
        }
        return str.substring(lo, lo + maxLen);
    }

    public static void searchPalindrome(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            lo = i + 1;
        }
    }
}
