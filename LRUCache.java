import java.util.*;
class LRUCache {
    HashMap<Integer,DNode> cache = new HashMap<Integer,DNode>();
    int capacity;
    DNode head = new DNode(0,0),tail = new DNode(0,0);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            DNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.v;
        }else{
            return -1;
        }   
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        if(cache.size()==capacity){
            remove(tail.prev);
        }
        insert(new DNode(key,value));
    }
    public void remove(DNode node){
        cache.remove(node.k);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(DNode node){
        cache.put(node.k,node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

class DNode{
    DNode prev,next;
    int k,v;
    DNode(int k,int v){
        this.k = k;
        this.v = v;
    }
}
