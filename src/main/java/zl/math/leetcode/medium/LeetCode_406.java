package zl.math.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.04.28 17:23
 */
public class LeetCode_406 {
    public int[][] reconstructQueue(int[][] people) {
        //其实就是先按照 people[i][1] 排序 然后按照 people[i][0] 排序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ordered = new LinkedList<>();
        for (int[] p : people) {
            ordered.add(p[1], p);
        }
        return ordered.toArray(new int[people.length][2]);
    }
}
