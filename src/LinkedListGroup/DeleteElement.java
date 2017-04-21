package LinkedListGroup;

public class DeleteElement{

    ListNode defaultHead;

    public ListNode delete(ListNode head, int val){
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        head = dummy;

        while (head.next != null){
            if (head.next.val == val){
                head.next = head.next.next;
                //break;
            }else{
                head = head.next;
            }
        }

        return dummy.next;
    }

    public void printList(ListNode node){
        while(node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        DeleteElement de = new DeleteElement();
        de.defaultHead = new ListNode(9);
        de.defaultHead.next = new ListNode(7);
        de.defaultHead.next.next = new ListNode(10);
        de.defaultHead.next.next.next = new ListNode(7);

        de.printList(de.defaultHead);
        de.defaultHead = de.delete(de.defaultHead, 7);
        de.printList(de.defaultHead);
    }
}