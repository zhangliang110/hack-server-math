package zl.math.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description : 纯暴力解法，通过是通过了。但是不清楚有啥更加优化的点。
 * 时间复杂度 O（n^2） 空间复杂度O(n)吧，又没有二维数组。
 * 优化点的话：就是如何简单的判断statisticsConcatenatedStr() 比如运用hash 之类的结构，
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.04.19 15:04
 */
public class LeetCode_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexLists = new ArrayList<>();
        //空值判断
        if (Objects.isNull(words) || words.length < 0 || Objects.isNull(s) || s.length() < 0) {
            return indexLists;
        }
        //先对words进行排序
        Arrays.sort(words);
        //每次skip的值
        int step = words[0].length();
        int substringLength = step * words.length;
        for (int i = 0; i <= s.length() - substringLength; i++) {
            String substring = s.substring(i, i + substringLength);
            //substring 是否满足concatenated str？
            if (statisticsConcatenatedStr(substring, words)) {
                indexLists.add(i);
            }
        }
        return indexLists;
    }

    public boolean statisticsConcatenatedStr(String equalLengthStr, String[] words) {
        int step = words[0].length();
        String[] strWords = new String[words.length];
        int arrayIndex = 0;
        for (int i = 0; i < equalLengthStr.length(); i += step) {
            strWords[arrayIndex] = equalLengthStr.substring(i, i + step);
            arrayIndex++;
        }
        Arrays.sort(strWords);
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(strWords[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_30 code_30 = new LeetCode_30();
        List<Integer> splitInteger = code_30.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(splitInteger);
    }
}
