package LinkedListGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class DeepCopy {

    RandomListNode defaultHead;

    public RandomListNode copy(RandomListNode head){

        // copy node and insert to original list
        RandomListNode p = head;
        while (p != null){
            RandomListNode copy = new RandomListNode(p.label);

            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy random node
        p = head;
        while (p != null){
            if (p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // split list
        p = head;
        RandomListNode newHead = head.next;
        while (p != null){
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null) { // pay attention
                temp.next = temp.next.next;
            }
            p = p.next;
        }
        return newHead;
    }

    public static void main(String[] args){
        RandomListNode n1 = new RandomListNode(1);

        RandomListNode n2 = new RandomListNode(2);

        RandomListNode n3 = new RandomListNode(3);

        n1.next = n2;
        n1.random = n3;

        n2.next = n3;

        DeepCopy dc = new DeepCopy();
        //dc.defaultHead = n1;

        RandomListNode copyn1 = dc.copy(n1);
        while (copyn1 != null){
            System.out.print(copyn1.label + ", ");
            copyn1 = copyn1.next;
        }
    }




    static class RandomListNode{
        int label;
        RandomListNode next, random;

        public RandomListNode(int label){
            this.label = label;
        }
    }


}
