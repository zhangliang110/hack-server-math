package zl.math.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode_86 {
    public static void main(String[] args) {

        List<Integer> initHeadList = Arrays.asList(1, 4, 3, 2, 5, 2);
        ListNode head = null;
        LeetCode_86 leetCode_86 = new LeetCode_86();
        ListNode tmpNode = new ListNode();
        for (Integer ele : initHeadList) {
            ListNode nowNode = new ListNode(ele);
            if (Objects.isNull(head)) {
                head = nowNode;
                head.next = tmpNode;
            } else {
                head.next = nowNode;
                head = head.next;
            }
        }
        ListNode node = leetCode_86.partition(head, 2);

    }

    public ListNode partition(ListNode head, int x) {
        // index , val
        // 如果 i 小于index 则不需要变化
        // 如果 i 大于index 且 i元素小于val 则变
        //反之就需要进行变化
        ListNode smaller = new ListNode();
        ListNode bigger = new ListNode();
        while (Objects.nonNull(head)) {
            ListNode nextNode = new ListNode();
            nextNode.val = head.val;
            if (head.val >= x) {
                if (bigger.val == 0) {
                    //bigger 的第一个
                    bigger.val = head.val;
                } else {
                    bigger = Objects.nonNull(bigger.next) ? bigger.next : bigger;
                    bigger.next = nextNode;
                }
            } else {
                if (smaller.val == 0) {
                    //bigger 的第一个
                    smaller.val = head.val;
                } else {
                    smaller = Objects.nonNull(smaller.next) ? smaller.next : smaller;
                    smaller.next = nextNode;
                }
            }
            head = head.next;
        }
        smaller.next = bigger;
        return smaller;
    }

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
