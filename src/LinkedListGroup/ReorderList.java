package LinkedListGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class ReorderList {

    ListNode defaultHead;

    public ListNode findMiddle(ListNode head){
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

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        head = pre;

        return head;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        int index = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(head1 != null && head2 != null){
            if (index % 2 == 0){
                head.next = head1;
                head1 = head1.next;
            }else {
                head.next = head2;
                head2 = head2.next;
            }
            index++;
            head = head.next;
        }
        if (head1 != null){
            head.next = head1;
        }else {
            head.next = head2;
        }
        return dummy.next;
    }

    public ListNode reorder(ListNode head){
        ListNode middle = findMiddle(head);

        ListNode right = middle.next;
        middle.next = null;
        System.out.println("hahaha:");
        printList(head);
        System.out.println("hahaha:");

        right = reverse(right);
        System.out.println("hahaha:");
        printList(right);
        System.out.println("hahaha:");
        ListNode newNode = merge(head, right);

        return newNode;
    }

    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        ReorderList rl = new ReorderList();
        rl.defaultHead = new ListNode(1);
        rl.defaultHead.next = new ListNode(2);
        rl.defaultHead.next.next = new ListNode(3);
        rl.defaultHead.next.next.next = new ListNode(4);
        rl.printList(rl.defaultHead);
        ListNode m = rl.findMiddle(rl.defaultHead);

        System.out.println(m.val);
        rl.reorder(rl.defaultHead);
        rl.printList(rl.defaultHead);
    }
}
