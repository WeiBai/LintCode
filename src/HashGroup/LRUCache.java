package HashGroup;

import java.util.HashMap;

/**
 * Created by baiwe on 2017/5/3.
 */
public class LRUCache {

    Node head = null;
    Node end = null;
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if (head != null){
            head.pre = n;
        }

        head = n;

        if (end == null){
            end = head;
        }
    }

    public void remove(Node n){
        if (n.pre != null){
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null){
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created); // keypoint
        }
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
}
