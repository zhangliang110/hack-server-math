package zl.math.zuochengyun;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 最长重复子串
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/26 22:42 by zl 创建
 **/
public class Code06_MaxRepeatedStr {

    public static void main(String[] args) {
        Code06_MaxRepeatedStr code06 = new Code06_MaxRepeatedStr();
        int i = code06.lengthOfLongestSubstringV2("123asd1231");
        System.out.println(i);
    }

    /**
     * 我自己的解法
     *
     * @param s 字符串
     * @return
     * @create 2023/3/26 23:32 张亮
     */
    public int lengthOfLongestSubstring(String s) {
        int distance = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0, n = s.length(); j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //调整i的值
                i = Math.max(i, map.get(s.charAt(j)));
            }
            distance = Math.max(distance, j - i + 1);
            map.put(s.charAt(j), j + 1);    //j + 1 代表字符所在位置
        }
        return distance;
    }

    /**
     * 学习后的算法
     *
     * @param s 字符串
     * @return
     * @create 2023/3/26 23:41 张亮
     */
    public int lengthOfLongestSubstringV2(String s) {
        //标记每个字符所在的位置，因为ascii 码最多只有255个字符
        int[] map = new int[256];
        map[0] = 0;
        char[] chars = s.toCharArray();
        //每一轮比较的结果值
        int pre = 1;
        //最起码 会是1
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            int p1 = i - map[chars[i]];
            int p2 = pre + 1;
            int cur = Math.min(p1, p2);
            res = Math.max(cur, res);
            pre = cur;
            map[chars[i]] = i;
        }
        return res;
    }
}
