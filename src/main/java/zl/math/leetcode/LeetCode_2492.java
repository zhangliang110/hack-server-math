package zl.math.leetcode;

import java.util.*;

/**
 * Description :
 * You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
 *
 * The score of a path between two cities is defined as the minimum distance of a road in this path.
 *
 * Return the minimum possible score of a path between cities 1 and n.
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.03.24 10:49
 */
public class LeetCode_2492 {
    int minPath = Integer.MAX_VALUE;

    /**
     * 定义一条边
     */
    static class Edge {
        private Integer start;

        private Integer end;

        private Integer score;

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    public int minScore(int n, int[][] roads) {
        if (Objects.isNull(roads)) {
            return 0;
        }
        Map<Integer, List<Edge>> allEdgeMap = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            allEdgeMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            int score = roads[i][2];
            Edge edge = new Edge();
            edge.setEnd(end);
            edge.setStart(start);
            edge.setScore(score);
            allEdgeMap.get(edge.getStart()).add(edge);
            allEdgeMap.get(edge.getEnd()).add(edge);
        }
        Queue<Integer> allEdgeList = new LinkedList<>();
        allEdgeList.add(1);
        Integer start = null;
        int minScore = Integer.MAX_VALUE;
        int[] vis = new int[n + 1];
        Arrays.fill(vis, 0);
        vis[1] = 1;
        while ((start = allEdgeList.poll()) != null) {
            List<Edge> edges = allEdgeMap.get(start);
            for (Edge edge : edges) {
                minScore = Math.min(edge.getScore(), minScore);
                if (vis[edge.getEnd()] == 0) {
                    vis[edge.getEnd()] = 1;
                    allEdgeList.add(edge.getEnd());
                }
            }
        }
        return minScore;
    }


    public static void main(String[] args) {
        int n = 36;
        int[][] roads = {{7, 11, 418}, {13, 23, 287}, {16, 25, 7891}, {15, 7, 9695}, {4, 3, 9569},
                {17, 7, 1809}, {14, 3, 4720}, {14, 4, 6118}, {9, 2, 4290}, {32, 17, 5645}, {14, 16, 426},
                {36, 7, 6721}, {13, 30, 9444}, {3, 25, 4635}, {33, 5, 1669}, {22, 18, 8910},
                {5, 28, 7865}, {13, 10, 9466}, {7, 9, 2457}, {11, 8, 4711}, {17, 11, 6308},
                {7, 34, 3789}, {8, 33, 9659}, {16, 3, 4187}, {16, 20, 3595}, {23, 10, 6251},
                {26, 22, 6180}, {4, 16, 5577}, {26, 7, 5398}, {6, 36, 8671}, {10, 19, 3028},
                {23, 30, 1330}, {19, 13, 8315}, {25, 20, 4740}, {25, 4, 5818}, {30, 10, 8030},
                {30, 19, 7527}, {28, 6, 6804}, {21, 27, 1746}, {18, 9, 5189}, {7, 27, 6560}, {20, 14, 2450},
                {27, 32, 3951}, {2, 21, 3927}, {1, 15, 9283}, {3, 20, 5428}, {15, 26, 5871}, {19, 23, 4533},
                {14, 25, 6992}, {4, 20, 5831}};
//        int[][] roads = {{2, 9, 2308}, {2, 5, 2150}, {12, 3, 4944}, {13, 5, 5462},
//                {2, 10, 2187}, {2, 12, 8132}, {2, 13, 3666}, {4, 14, 3019}, {2, 4, 6759},
//                {2, 14, 9869}, {1, 10, 8147}, {3, 4, 7971}, {9, 13, 8026}, {5, 12, 9982}, {10, 9, 6459}};
        LeetCode_2492 leetCode2492 = new LeetCode_2492();
        int i = leetCode2492.minScore(n, roads);
        System.out.println(i);
    }
}
