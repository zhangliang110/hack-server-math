package zl.math.zuochengyun;

/**
 * Description: 最少交换步骤
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/15 20:53 by zl 创建
 **/
public class Code2_MinSwapStep {

    public static void main(String[] args) {
        int times = minSwapStep("GBGBGBGBBBB");
        System.out.println(times);
    }
    /**
     * @param
     * @description 一个数组中只有G B 两种字符，一次只能交换相邻字符。问如果要做所有的G 放右边或者左边。
     * 最少需要交换多少次
     * GBGBGB
     * @create 2023/3/15 20:53 张亮
     */
    public static int minSwapStep(String s) {
        if (null == s || s.length() == 0) {
            //异常判断
            return 0;
        }
        char[] chars = s.toCharArray();
        int charIndex = 0;
        int gIndex = 0;
        int gChangeTimes = 0;
        int bIndex = 0;
        int bChangeTimes = 0;
        for (char waitChangeChar : chars) {
            //交换B的次数
            if (waitChangeChar == 'B') {
                bChangeTimes += charIndex - bIndex;
                bIndex++;
            }
            //交换G的次数
            if (waitChangeChar == 'G') {
                gChangeTimes += charIndex - gIndex;
                gIndex++;
            }
            charIndex++;
        }
        return Math.min(bChangeTimes, gChangeTimes);
    }
}
