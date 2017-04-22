package LinkedListGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class SortList {

    ListNode defaultNode;

    public ListNode findMiddle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (node1 != null && node2 != null){
            if (node1.val < node2.val){
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        if (node1 != null){
            head.next = node1;
        }
        else {
            head.next = node2;
        }

        return dummy.next;
    }

    public ListNode sort(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        ListNode middle = findMiddle(head);

        // divide
        ListNode right = sort(middle.next);
        middle.next = null;
        ListNode left = sort(head);

        // conquer
        return merge(left,right);
    }

    public static void main(String[] args){
        SortList sl = new SortList();
        sl.defaultNode = new ListNode(1);
        sl.defaultNode.next = new ListNode(4);
        sl.defaultNode.next.next = new ListNode(3);
        sl.defaultNode.next.next.next = new ListNode(7);

        ListNode result = sl.sort(sl.defaultNode);
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}
