package zl.math.leetcode.medium;

import java.util.Objects;

/**
 * Description : 设计一个双端队列  基于链表
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2023.04.26 17:39
 */
public class LeetCode_641 {
    int size;
    int capacity;

    transient Node<Integer> first;

    transient Node<Integer> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public LeetCode_641(int k) {
        size = k;
    }

    public boolean insertFront(int value) {
        if (size <= capacity) {
            return false;
        }
        final Node<Integer> f = first;
        Node<Integer> newNode = new Node<>(null, value, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        capacity++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size <= capacity) {
            return false;
        }
        final Node<Integer> l = last;
        Node<Integer> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        capacity++;
        return true;
    }

    public boolean deleteFront() {
        if (first == null) {
            return false;
        }
        Node<Integer> next = first.next;
        first.item = null;
        first.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            first.prev = null;
        }
        capacity--;
        return true;
    }

    public boolean deleteLast() {
        if (last == null) {
            return false;
        }
        final Node<Integer> l = last;
        Node<Integer> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        capacity--;
        return true;
    }

    public int getFront() {
        return Objects.isNull(first) ? 0 : first.item;
    }

    public int getRear() {
        return Objects.isNull(last) ? 0 : last.item;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public static void main(String[] args) {
        LeetCode_641 obj = new LeetCode_641(10);
        boolean param_1 = obj.insertFront(1);
        System.out.println(param_1);
        boolean param_2 = obj.insertLast(2);
        System.out.println(param_1);
        boolean param_3 = obj.deleteFront();
        System.out.println(param_3);
        boolean param_4 = obj.deleteLast();
        System.out.println(param_4);
        int param_5 = obj.getFront();
        System.out.println(param_5);
        int param_6 = obj.getRear();
        System.out.println(param_6);
        boolean param_7 = obj.isEmpty();
        System.out.println(param_7);
        boolean param_8 = obj.isFull();
        System.out.println(param_8);
    }
}
