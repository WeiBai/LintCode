package LinkedListGroup;

/**
 * Created by Wei on 2017/4/21.
 */
public class InsertNode {

    ListNode heads;

    public ListNode insert(ListNode head, int val){

        if (head == null){
            return new ListNode(val);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.val < val){
            head = head.next;
        }

        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;

        return dummy.next;
    }

    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        InsertNode rl = new InsertNode();

        rl.heads = new ListNode(1);
        rl.heads.next = new ListNode(2);
        rl.heads.next.next = new ListNode(4);
        rl.printList(rl.heads);
        rl.heads = rl.insert(rl.heads, 3);
        rl.printList(rl.heads);
    }
}
