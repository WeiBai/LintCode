package LinkedListGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class RecycleList {

    ListNode defaultHead;

    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (slow != fast.next){
            if (fast.next == null || fast.next.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String [] args){
        RecycleList rl = new RecycleList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        rl.defaultHead = n1;
        rl.defaultHead.next = n2;
        rl.defaultHead.next.next = n1;

        boolean result = rl.hasCycle(rl.defaultHead);

        System.out.println(result);
    }
}
