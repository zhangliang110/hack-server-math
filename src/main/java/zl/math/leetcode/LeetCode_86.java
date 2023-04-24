package zl.math.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode_86 {
    public static void main(String[] args) {

        List<Integer> initHeadList = Arrays.asList(1, 4, 3, 2, 5, 2);

        ListNode head = null;
        ListNode current = null;
        LeetCode_86 leetCode_86 = new LeetCode_86();
        for (Integer ele : initHeadList) {
            ListNode nowNode = new ListNode(ele);
            if (Objects.isNull(head)) {
                head = nowNode;
                current = nowNode;
            } else {
                current.next = nowNode;
                current = nowNode;

            }
        }
        ListNode node = leetCode_86.partition(head, 3);
        System.out.println(node);

    }

    public ListNode partition(ListNode head, int x) {
        // index , val
        // 如果 i 小于index 则不需要变化
        // 如果 i 大于index 且 i元素小于val 则变
        //反之就需要进行变化
        ListNode smaller = null;
        ListNode bigger = null;
        ListNode currentBigger = null;
        ListNode currentSmaller = null;
        while (Objects.nonNull(head)) {
            ListNode nextNode = new ListNode(head.val);
            nextNode.val = head.val;
            if (head.val >= x) {
                if (Objects.isNull(bigger)) {
                    //bigger 的第一个
                    bigger = nextNode;
                    currentBigger = nextNode;
                } else {
                    currentBigger.next = nextNode;
                    currentBigger = nextNode;
                }
            } else {
                if (Objects.isNull(smaller)) {
                    //bigger 的第一个
                    smaller = nextNode;
                    currentSmaller = nextNode;
                } else {
                    currentSmaller.next = nextNode;
                    currentSmaller = nextNode;
                }
            }
            head = head.next;
        }
        if (Objects.isNull(smaller) && Objects.isNull(bigger)) {
            return null;
        }
        if (Objects.isNull(bigger)) {
            return smaller;
        }
        if (Objects.isNull(smaller)) {
            return bigger;
        }
        ListNode tempSmallerNode = smaller;
        while (null != tempSmallerNode.next) tempSmallerNode = tempSmallerNode.next;
        tempSmallerNode.next = bigger;

        return smaller;
    }

    public ListNode partition2(ListNode head, int x) {
        List<Integer> lessOnce = new ArrayList<>();
        List<Integer> notLessOnce = new ArrayList<>();
        ListNode copy = head;
        while(copy!=null){
            if(copy.val < x){
                lessOnce.add(copy.val);
            }
            else{
                notLessOnce.add(copy.val);
            }
            copy=copy.next;
        }

        copy = head;

        for(int i=0;i<lessOnce.size();i++){
            copy.val = lessOnce.get(i);
            copy=copy.next;
        }

        for(int i=0;i<notLessOnce.size();i++){
            copy.val = notLessOnce.get(i);
            copy=copy.next;
        }
        return head;
    }

    /**
     * 链表节点
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
