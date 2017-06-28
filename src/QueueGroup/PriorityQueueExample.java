package QueueGroup;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
/**
 * Created by baiwe on 2017/6/27.
 */
public class PriorityQueueExample {

    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue(7, idComparator);
        addDataToQueue(pq);
        pollDataFromQueue(pq);
    }

    // define a comparator
    private static Comparator<Customer> idComparator = new Comparator<Customer>(){
      @Override
        public int compare(Customer c1, Customer c2){
          return (int)(c1.getId() - c2.getId());
      }
    };

    // add an element to the priority queue
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue){
        Random random = new Random();
        for (int i = 0; i < 7; i++){
            int id = random.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Bai"+id));
        }
    }

    // poll elements from a priority queue
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue){
        while (true){
            Customer customer = customerPriorityQueue.poll();
            if (customer == null){
                break;
            }
            System.out.println("Poll customer with ID = " + customer.getId());
        }
    }
}
