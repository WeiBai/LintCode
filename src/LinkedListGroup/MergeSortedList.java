package LinkedListGroup;

/**
 * Created by baiwe on 2017/4/21.
 */
public class MergeSortedList {
    ListNode l1;
    ListNode l2;

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                lastNode.next = l1;
                l1 = l1.next;
            }else{
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null){
            lastNode.next = l1;
        }

        if (l2 != null){
            lastNode.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        MergeSortedList msl = new MergeSortedList();
        msl.l1 = new ListNode(1);
        msl.l1.next = new ListNode(7);
        msl.l1.next.next = new ListNode(10);
        msl.l1.next.next.next = new ListNode(12);


        msl.l2 = new ListNode(2);
        msl.l2.next = new ListNode(8);
        msl.l2.next.next = new ListNode(9);
        msl.l2.next.next.next = new ListNode(11);

        ListNode node = msl.merge(msl.l1,msl.l2);
        msl.printList(node);
    }

    public void printList(ListNode node){
        while(node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }
}
