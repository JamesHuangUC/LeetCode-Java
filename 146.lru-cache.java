/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (26.61%)
 * Likes:    3607
 * Dislikes: 146
 * Total Accepted:    352.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 // capacity );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

class Node {
    int key;
    int val;
    Node prev = null;
    Node next = null;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> hm = null;
    int cap;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.hm = new HashMap<>();
    }
    
    public int get(int key) {
        if (hm.containsKey(key)) {
            Node temp = hm.get(key);
            remove(temp);
            setHead(temp);
            return temp.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node temp = hm.get(key);
            remove(temp);
            temp.val = value;
            setHead(temp);
        } else {
            if (hm.size() >= cap) {
                hm.remove(tail.key);
                remove(tail);
            }
            Node temp = new Node(key, value);
            hm.put(key, temp);
            setHead(temp);
        }
    }

    void setHead(Node t) {
        if (head != null) {
            head.prev = t;
        }
        t.next = head;
        t.prev = null;
        head = t;

        if (tail == null) {
            tail = head;
        }
    }

    void remove(Node t) {
        if (t.prev != null) {
            t.prev.next = t.next;
        } else {
            head = t.next;
        }

        if (t.next != null) {
            t.next.prev = t.prev;
        } else {
            tail = t.prev;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

