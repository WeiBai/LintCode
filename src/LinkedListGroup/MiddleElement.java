package LinkedListGroup;

/**
 * Created by baiwe on 2017/4/21.
 */
public class MiddleElement {

    ListNode defaultHead;

    public ListNode middle(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args){
        MiddleElement me = new MiddleElement();
        me.defaultHead = new ListNode(0);
        me.defaultHead.next = new ListNode(1);
        me.defaultHead.next.next = new ListNode(2);
        me.defaultHead.next.next.next = new ListNode(3);
        me.defaultHead.next.next.next.next = new ListNode(4);


        ListNode middleNode = me.middle(me.defaultHead);

        System.out.println(middleNode.val);
    }
}
