package ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//public class LRUCache extends LinkedHashMap<Integer,Integer> {
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}
class LRUCache {
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head ,tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }



    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node != null) {
            node.value = value;
            moveToHead(node);
        }
        else {
            DLinkedNode newNode = new DLinkedNode(key , value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                DLinkedNode tail = removeToTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }
    private void moveToHead(DLinkedNode node) {
        addToHead(node);
        removeNode(node);
    }
    private DLinkedNode removeToTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode res) {
        res.prev.next = res.next;
        res.next.prev = res.prev;
    }

    private void addToHead(DLinkedNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }
}