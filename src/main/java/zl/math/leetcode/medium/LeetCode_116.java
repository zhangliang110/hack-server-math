package zl.math.leetcode.medium;

/**
 * Description :
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.05.11 15:00
 */
public class LeetCode_116 {

    /**
     * 递归答案。其他的可以使用层级排序，然后把每层的数据加到一个list 遍历list 增加链接指针应该也是可行的
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null) root.left.next = root.right;
        if (root.next != null && root.right != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
