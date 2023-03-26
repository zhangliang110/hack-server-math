package zl.math.zuochengyun;

/**
 * Description: 司机 N 人，调度中心将司机平分给A /B 两个区域
 * 第i个司机去A 可得收入income[i][0]
 * 第i个司机去B 可得收入income[i][1]
 * 返回所有调度方案中使得所有司机总收入最高的方案。是多少钱？
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/22 21:03 by zl 创建
 **/
public class Code4_drivers {

    public static void main(String[] args) {
        int[][] incomeArr = new int[2][2];
        incomeArr[0][0] = 10;
        incomeArr[0][1] = 20;
        incomeArr[1][0] = 5;
        incomeArr[1][1] = 30;
        int i = calculateMaxMoney(incomeArr);
        System.out.println(i);
    }

    public static int calculateMaxMoney(int[][] incomeArr) {
        if (null == incomeArr || incomeArr.length < 2 || (incomeArr.length & 1) != 0) {
            //司机必须为 偶数不然不能平均分配
            return 0;
        }

        return maxMoney(incomeArr, 0, incomeArr.length / 2);
    }


    /**
     * 函数表示 第index 个待分配的司机到 最后得司机当a地区还剩aRest个名额时，如何分配所得收入的最大
     *
     * @param incomeArr 收入数组 一个 N x 2 的二维数组，存储  第i司机 去 a/b 区域的收入
     * @param aRest     a地区还能接收的司机数
     * @param index     已经分配到的第index 个司机
     * @create 2023/3/22 21:43 张亮
     */
    public static int maxMoney(int[][] incomeArr, int index, int aRest) {
        if (incomeArr.length == index) {
            //分配完了
            return 0;
        }

        //说明都可以放入到aRest中
        if (incomeArr.length - index <= aRest) {
            return incomeArr[index][0] + maxMoney(incomeArr, index + 1, aRest - 1);
        } else {
            int p1 = incomeArr[index][1] + maxMoney(incomeArr, index + 1, aRest);
            int p2 = incomeArr[index][0] + maxMoney(incomeArr, index + 1, aRest - 1);
            return Math.max(p1, p2);
        }

    }
}

