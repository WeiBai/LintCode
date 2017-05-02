package HashGroup;

/**
 * Created by baiwe on 2017/5/2.
 */
public class ReHashing {

    public ListNode[] rehash(ListNode[] hashTable){
        if (hashTable.length <= 0){
            return hashTable;
        }

        int newCapacity = 2 * hashTable.length;
        ListNode[] newhashTable = new ListNode[newCapacity];

        for (int i = 0; i < hashTable.length; i++){
            while (hashTable[i] != null){
                int newIndex= (hashTable[i].val % newCapacity + newCapacity) % newCapacity;

                if (newhashTable[newIndex] == null){
                    newhashTable[newIndex] =  new ListNode(hashTable[i].val);
                } else {
                    ListNode dummy = newhashTable[newIndex];
                    while (dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }

        return newhashTable;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
