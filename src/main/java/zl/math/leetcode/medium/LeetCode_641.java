package zl.math.leetcode.medium;

/**
 * Description : 设计一个双端队列
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
        first = first.next;
        first.prev = last;
        capacity--;
    }

    public boolean deleteLast() {

    }

    public int getFront() {

    }

    public int getRear() {

    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }
}
