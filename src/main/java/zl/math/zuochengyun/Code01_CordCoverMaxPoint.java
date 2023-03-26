package zl.math.zuochengyun;

/**
 * Description:
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/14 23:07 by zl 创建
 **/
public class Code01_CordCoverMaxPoint {

    public static int maxPoint1(int[] arr, int length) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearest(arr, i, arr[i] - length);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    public static int nearest(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    /**
     * @param arr [1,4,5,7,10,11,123,1111]
     * @return
     * @description
     * @create 2023/3/14 23:18 张亮
     */
    public static int maxPoint2(int[] arr, int length) {
      /*  int L = 0;
        int R = 0;
        int N = arr.length;
        int res = 0;
        while (L < N) {
            while (R < N && arr[R] - arr[L] <= length) {
                R++;
            }
            res = Math.max(res, R - (L++));
        }
        return res;*/
        int l = 0;
        int r = 0;
        int arrLength = arr.length;
        int res = 0;
        while (l < arrLength) {
            while (r < arrLength && arr[r] - arr[r] <= length) {
                r++;
            }
            res = Math.max(res, r - (l++));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 10, 11};
        int i = maxPoint1(arr, 4);
        int y = maxPoint2(arr, 4);
        System.out.println(y);
        System.out.println(i);

    }
}
