package LinkedListGroup;

/**
 * Created by baiwe on 2017/4/21.
 */
public class PartitionList {

    ListNode defaultHead;

    public ListNode partition(ListNode head, int val){

        if (head == null || head.next == null){
            return head;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        leftDummy.next = head;
        rightDummy.next = head;

        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null){
            if (head.val < val){
                left.next = head;
                left = head;
            }else{
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;

        return leftDummy.next;
    }

    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        PartitionList pl = new PartitionList();
        pl.defaultHead = new ListNode(0);
        pl.defaultHead.next = new ListNode(4);
        pl.defaultHead.next.next = new ListNode(3);
        pl.defaultHead.next.next.next = new ListNode(2);

        pl.printList(pl.defaultHead);
        pl.defaultHead = pl.partition(pl.defaultHead,3);
        pl.printList(pl.defaultHead);
    }
}
