146. LRU Cache.java

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
------------------------------------------------------------------------------------------
double linked list and hashmap, implement LinkedHashMap:

HashMap<key, DoublyListNode> DoublyListNode {
  prev, next, key, value;
}
• Newest node append to tail.
• Eldest node remove from head.

public class Solution {
    private class Node{
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    };
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        //if find the key, remove key
        Node cur = map.get(key);
        int hitnum = cur.val;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        addToTail(cur);
        return map.get(key).val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(this.get(key) != -1){
            map.get(key).val = value;
            return;
        }
        if(map.size() >= capacity){//remove head.next;
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;//already delete the old head.next
            
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        addToTail(insert);
    }
    private void addToTail(Node cur){// before tail node , tail and head is fake
        cur.prev = tail.prev;
        tail.prev = cur;
        cur.next = tail;
        cur.prev.next = cur;
    }
}
