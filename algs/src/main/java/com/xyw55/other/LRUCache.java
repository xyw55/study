/*
 * @(#) LRUCache.java 2019-09-01
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.other;

import java.util.HashMap;

/**
 * leetcode 146
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * @author xyw55
 * @version 2019-09-01
 */
public class LRUCache <T> {

    private HashMap<String, Node> cache;

    // head id old，tail is new
    private Node head = null;
    private Node tail = null;

    private int capacity;

    /**
     * idea
     * LinkedHashMap method
     * hashMap storage data，key->value(Node.class), init a empty head and tail
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity + 1, 1);
        this.capacity = capacity;
        head = new Node("", null, null, null);
        tail = new Node("", null, head, null);
        head.next = tail;
    }

    public T get(String key) {
        // 1.get value
        Node result = cache.get(key);
        if (result == null) {
            return null;
        }
        // 2.refresh
        refresh(key);
        return (T) result.value;
    }

    public void put(String key, T value) {
        // 1.set value
        Node result = cache.get(key);
        if (result == null) {
            //add
            this.cache.put(key, new Node(key, value, null, null));
        } else {
            //update
            result.value = value;
        }
        // 2.judge cache is full, if it's full, delete head
        if (cache.size() > capacity) {
            Node old = head.next;
            head.next = old.next;
            old.next.prev = head;
            old.next = null;
            old.prev = null;
            this.cache.remove(old.key);
        }
        // 3.refresh order
        refresh(key);
    }

    private void refresh(String key) {
        // 1.get value
        Node e = cache.get(key);
        if (e == null) {
            return;
        }
        if (e.next == null && e.prev == null) {
            // add
            tail.prev.next = e;
            e.prev = tail.prev;
            e.next = tail;
            tail.prev = e;
        } else if (tail.prev == e) {
        } else {
            // exchange
            e.prev.next = e.next;
            e.next.prev = e.prev;
            tail.prev.next = e;
            e.prev = tail.prev;
            e.next = tail;
            tail.prev = e;
        }

    }

    class Node <T> {
        private String key;
        private T value;
        private Node prev;
        private Node next;

        Node(String key, T value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
        try {

            cache.put("1", 1);
            cache.put("2", 2);
            System.out.println(cache.get("1"));       // returns 1
            cache.put("3", 3);    // evicts key 2
            System.out.println(cache.get("2"));       // returns -1 (not found)
            cache.put("4", 4);    // evicts key 1
            System.out.println(cache.get("1"));       // returns -1 (not found)
            System.out.println(cache.get("3"));       // returns 3
            System.out.println(cache.get("4"));       // returns 4

            cache.put("2",1);
            cache.put("1",1);
            cache.put("2",3);
            cache.put("4",1);
            System.out.println(cache.get("1"));
            System.out.println(cache.get("2"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(cache);
        }

    }

}
