package LinkedListGroup;

/**
 * Created by baiwe on 2017/4/21.
 */

public class RemoveDup2 {

    ListNode defaultHead;

    public ListNode remove(ListNode head){
        if (head == null && head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null){
            if (head.next.val == head.next.next.val){
                int value = head.next.val;
                while (head.next != null && head.next.val == value) {
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }

        return dummy.next;
    }

    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        RemoveDup2 rd = new RemoveDup2();
        rd.defaultHead = new ListNode(0);
        rd.defaultHead.next = new ListNode(1);
        rd.defaultHead.next.next = new ListNode(1);
        rd.defaultHead.next.next.next = new ListNode(2);

        rd.printList(rd.defaultHead);
        rd.defaultHead = rd.remove(rd.defaultHead);
        rd.printList(rd.defaultHead);
    }

}

