package GraphGroup;

import java.util.HashMap;

/**
 * Created by Wei on 2017/4/29.
 */
public class CloneRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;

        while (head != null){

            if (map.containsKey(head)){
                newNode = map.get(head); // keypoint
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }

            pre.next = newNode;

            if (head.random != null) { // keypoint
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = pre.next;
            head = head.next;
        }

        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x){
        this.label = x;
    }
}
