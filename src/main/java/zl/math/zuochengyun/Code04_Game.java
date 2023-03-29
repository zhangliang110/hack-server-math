package zl.math.zuochengyun;

import java.util.Arrays;

/**
 * Description:给定一个数组arr，代表每个人的能力值，再给定一个非负数k，如果两个人的能力值正好相差为k,那么可以凑在一起比赛。
 * 一局比赛只有两个人，返回最多可以同时有多少场比赛。
 * [3,1,5,7]
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/28 22:53 by zl 创建
 **/
public class Code04_Game {
    public static void main(String[] args) {
        Code04_Game gameCountClass = new Code04_Game();
        int gameCount = gameCountClass.gameCount(new int[]{2, 2, 2, 4, 4, 4}, 2);
        System.out.println(gameCount);
    }

    /**
     * 返回最多能比多少次比赛 （窗口模式）
     *
     * @param abilities 能力数组值
     * @create 2023/3/28 23:03 张亮
     */
    public int gameCount(int[] abilities, int k) {
        if (null == abilities || abilities.length < 2) {
            return 0;
        }
        Arrays.sort(abilities);
        //当两个值的差值 小于 k 时 ，移动 end 指针，大于k时移动 start指针
        int start = 0, end = 1;
        int gameCount = 0;
        boolean[] usedAbilities = new boolean[abilities.length];
        for (; end < abilities.length; ) {
            if (usedAbilities[end]) {
                end++;
            }
            if (usedAbilities[start]) {
                start++;
            }
            if (abilities[end] - abilities[start] == k) {
                gameCount++;
                usedAbilities[end++] = true;
                start++;
            } else if (abilities[end] - abilities[start] > k) {
                start++;
            } else {
                end++;
            }
        }
        return gameCount;
    }
}
