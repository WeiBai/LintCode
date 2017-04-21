package LinkedListGroup;

/**
 * Created by baiwe on 2017/4/21.
 */
public class RemoveDup {
    // remove duplicated elements for a sorted list

    ListNode defaultHead;

    public ListNode remove(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        while (node != null && node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }

        return head;
    }

    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        RemoveDup rd = new RemoveDup();
        rd.defaultHead = new ListNode(0);
        rd.defaultHead.next = new ListNode(1);
        rd.defaultHead.next.next = new ListNode(1);
        rd.defaultHead.next.next.next = new ListNode(1);

        rd.printList(rd.defaultHead);
        rd.defaultHead = rd.remove(rd.defaultHead);
        rd.printList(rd.defaultHead);
    }

}
