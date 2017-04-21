package LinkedListGroup;

/**
 * Created by Wei on 2017/4/21.
 */
public class ReverseListIterate {

    Node head;

    private static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            next = null;
        }
    }

    public Node reverse(Node node){
        Node current = node;
        Node pre = null;
        Node next = null;

        while  (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        node = pre;
        return node;
    }

    public void printList(Node head){
        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ReverseListIterate rl = new ReverseListIterate();

        rl.head = new Node(1);
        rl.head.next = new Node(2);
        rl.head.next.next = new Node(3);
        rl.printList(rl.head);
        rl.head = rl.reverse(rl.head);
        rl.printList(rl.head);
    }
}
