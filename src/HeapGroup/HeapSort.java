package HeapGroup;

/**
 * Created by Wei on 2017/4/21.
 */
public class HeapSort {

    public HeapSort(){}

    public static void main(String[] args){
        HeapSort hs = new HeapSort();
        String[] input = {"wo","ai","chen"};
        hs.sort(input);
        for (int i = 0; i < input.length; i++){
            System.out.println(input[i]);
        }
    }
    private void sort(Comparable[] pq){
        int n = pq.length;
        for (int k = n/2; k > 1; k--){
            sink(pq, k, n);
        }
        while(n > 1){
            exch(pq,1,n--);
            sink(pq, 1, n);
        }
    }

    private boolean less(Comparable[] pq, int i, int j){
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private void exch(Object[] pq, int i, int j){
        Object temp = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = temp;
    }

    private void sink(Comparable[] pq, int k, int n){
        while (2*k <= n){
            int j = 2*k;
            if (j < n && less(pq, j,j+1)){
                j++;
            }
            if (!less(pq,k,j)){break;}
            exch(pq, k, j);
            k = j;
        }
    }
}
