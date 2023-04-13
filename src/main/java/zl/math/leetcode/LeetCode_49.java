package zl.math.leetcode;

import java.util.*;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/4/13 23:44 by zl 创建
 **/
public class LeetCode_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LeetCode_49 leetCode49 = new LeetCode_49();
        List<List<String>> lists = leetCode49.groupAnagrams(new String[]{"asd"});
        System.out.println(lists);
    }
}

